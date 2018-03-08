package cronapi.telegram.bots;

import cronapi.Var;
import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.models.Update;
import cronapi.util.Callback;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class TelegramBotSession extends Thread {
    private static final Logger LOGGER = Logger.getLogger(TelegramBotSession.class.getName());
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private final GetUpdates request;
    private final Callback handler;
    private int lastReceivedUpdate;

    TelegramBotSession(GetUpdates request, Callback handler) {
        this.request = request;
        this.handler = handler;
        this.lastReceivedUpdate = request.getOffset() == null ? 0 : request.getOffset() - 1;
    }

    @Override
    public void run() {
        setPriority(Thread.MIN_PRIORITY);
        while (!isInterrupted()) {
            try {
                request.setOffset(lastReceivedUpdate + 1);
                List<Update> updates;
                try {
                    updates = request.execute();
                } catch (IOException | TelegramBotException e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    Thread.sleep(500);
                    updates = Collections.emptyList();
                }

                updates.removeIf(x -> x.getUpdateId() < lastReceivedUpdate);
                lastReceivedUpdate = updates.parallelStream()
                    .map(Update::getUpdateId)
                    .max(Integer::compareTo)
                    .orElse(0);

                updates.forEach(update -> executor.execute(() -> {
                    try {
                        handler.call(Var.valueOf(update));
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    }
                }));
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
