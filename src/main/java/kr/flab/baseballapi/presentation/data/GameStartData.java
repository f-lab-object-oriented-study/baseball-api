package kr.flab.baseballapi.presentation.data;

import kr.flab.baseballapi.presentation.data.common.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameStartData implements Data {
    private Long roomId;
}
