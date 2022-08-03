package kr.flab.baseballapi.presentation.data;

import lombok.Getter;

@Getter
public class Response {
    private boolean success;
    private Data data;
    private Error error;

    public Response(boolean success, Data data) {
        this.success = success;
        this.data = data;
    }
    
    public void setError(Error error) {
        this.error = error;
    }
}
