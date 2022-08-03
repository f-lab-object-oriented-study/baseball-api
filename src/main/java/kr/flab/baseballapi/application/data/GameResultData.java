package kr.flab.baseballapi.application.data;

import kr.flab.baseballapi.presentation.data.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameResultData implements Data {
    private Long remainingCount;
    private Long answerCount;
}
