package kr.flab.baseballapi.presentation.data.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {
    private ErrorCode code;
    private String message;
}
