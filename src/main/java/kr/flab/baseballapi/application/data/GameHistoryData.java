package kr.flab.baseballapi.application.data;

import java.util.List;

import kr.flab.baseballapi.presentation.data.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameHistoryData implements Data {
    private List<History> histories;
}
