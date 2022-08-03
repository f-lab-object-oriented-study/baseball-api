package kr.flab.baseballapi.presentation.data;

import lombok.Getter;

@Getter
public class Response {
    private boolean success;
    private Data data;
    private Error error;

    public Response(Data data) {
        this.success = true;
        this.data = data;
        this.error = null;
    }

    public Response(Error error) {
        this.success = false;
        this.data = null;
        this.error = error;
    }
}
