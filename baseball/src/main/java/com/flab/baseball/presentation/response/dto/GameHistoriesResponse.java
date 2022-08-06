package com.flab.baseball.presentation.response.dto;

import com.flab.baseball.application.data.GameHistoriesData;
import com.flab.baseball.application.data.GameHistoryData;
import java.util.List;
import lombok.Getter;

@Getter
public class GameHistoriesResponse {

	private final List<GameHistoryData> histories;

	public GameHistoriesResponse(GameHistoriesData gameHistoriesData) {
		histories = gameHistoriesData.getHistories();
	}

}
