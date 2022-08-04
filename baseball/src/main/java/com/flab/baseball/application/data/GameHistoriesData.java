package com.flab.baseball.application.data;

import com.flab.baseball.domain.GameHistory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class GameHistoriesData {

	private final List<GameHistoryData> histories;

	public GameHistoriesData(List<GameHistory> gameHistories) {
		histories = gameHistories.stream()
			.map(GameHistoryData::new)
			.collect(Collectors.toList());
	}

}
