package cronapi.telegram.bots.methods;

public final class Response<T> {
    private Boolean ok;
    private Integer errorCode;
    private String errorDescription;
    private Parameters parameters;
    private T result;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static class Parameters {
        private Integer migrateToChatId;
        private Integer retryAfter;

        public Integer getMigrateToChatId() {
            return migrateToChatId;
        }

        public void setMigrateToChatId(Integer migrateToChatId) {
            this.migrateToChatId = migrateToChatId;
        }

        public Integer getRetryAfter() {
            return retryAfter;
        }

        public void setRetryAfter(Integer retryAfter) {
            this.retryAfter = retryAfter;
        }
    }
}
