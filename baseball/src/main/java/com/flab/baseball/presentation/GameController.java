package com.flab.baseball.presentation;

import static com.flab.baseball.presentation.response.ErrorCode.CLOSED_GAME;

import com.flab.baseball.application.GameHistoriesSearchProcessor;
import com.flab.baseball.application.GamePlayProcessor;
import com.flab.baseball.application.GameStartProcessor;
import com.flab.baseball.application.RoomResultProcessor;
import com.flab.baseball.application.data.GameHistoriesData;
import com.flab.baseball.application.data.GamePlayData;
import com.flab.baseball.application.data.GameStartData;
import com.flab.baseball.application.data.RoomResultData;
import com.flab.baseball.presentation.response.GameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

	private final GameStartProcessor gameStartProcessor;
	private final GamePlayProcessor gamePlayProcessor;
	private final RoomResultProcessor roomResultProcessor;
	private final GameHistoriesSearchProcessor gameHistoriesSearchProcessor;

	@PostMapping("/start")
	public GameResponse<GameStartData> gameStart() {
		GameStartData gameStartData = gameStartProcessor.execute();
		return new GameResponse<>(gameStartData);
	}

	@PostMapping("/{roomId}/answer")
	public GameResponse<Object> gamePlay(@PathVariable Long roomId, @RequestBody GamePlayRequest request) {
		try {
			GamePlayData gamePlayData = gamePlayProcessor.execute(roomId, request.getAnswer());
			return new GameResponse<>(gamePlayData);
		} catch (IllegalStateException e) {
			return GameResponse.toError(CLOSED_GAME);
		}
	}

	@GetMapping("/{roomId}")
	public GameResponse<RoomResultData> roomResult(@PathVariable Long roomId) {
		RoomResultData roomResultData = roomResultProcessor.execute(roomId);
		return new GameResponse<>(roomResultData);
	}

	@GetMapping("/{roomId}/history")
	public GameResponse<GameHistoriesData> findHistory(@PathVariable Long roomId) {
		GameHistoriesData histories = gameHistoriesSearchProcessor.execute(roomId);
		return new GameResponse<>(histories);
	}

}
