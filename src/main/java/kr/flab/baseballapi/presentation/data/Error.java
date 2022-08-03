package kr.flab.baseballapi.presentation.data;

import lombok.Getter;

@Getter
public class Error {
    private ErrorCode code;
    private String message;
}
