package kr.flab.baseballapi.application.data;

import kr.flab.baseballapi.presentation.data.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameStartData implements Data {
    private Long roomId;
}
