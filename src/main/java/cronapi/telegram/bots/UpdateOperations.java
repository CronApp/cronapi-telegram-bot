package cronapi.telegram.bots;

import cronapi.CronapiMetaData;
import cronapi.telegram.bots.methods.EditMessageLiveLocation;
import cronapi.telegram.bots.methods.StopMessageLiveLocation;
import java.io.IOException;
import java.io.Serializable;

public class UpdateOperations {

    private UpdateOperations() {

    }

    @CronapiMetaData
    public static Serializable editMessageLiveLocation(EditMessageLiveLocation param)
        throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Serializable stopMessageLiveLocation(StopMessageLiveLocation param)
        throws IOException {
        return param.execute();
    }
}
