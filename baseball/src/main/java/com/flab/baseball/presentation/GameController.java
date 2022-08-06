package com.flab.baseball.presentation;

import static com.flab.baseball.presentation.response.ErrorCode.CLOSED_GAME;

import com.flab.baseball.application.GameHistoriesSearchProcessor;
import com.flab.baseball.application.GamePlayProcessor;
import com.flab.baseball.application.GameStartProcessor;
import com.flab.baseball.application.RoomResultQueryProcessor;
import com.flab.baseball.application.data.GameHistoriesData;
import com.flab.baseball.application.data.GamePlayData;
import com.flab.baseball.application.data.GameStartData;
import com.flab.baseball.application.data.RoomResultQueryData;
import com.flab.baseball.presentation.response.GameResponse;
import com.flab.baseball.presentation.response.dto.GameHistoriesResponse;
import com.flab.baseball.presentation.response.dto.GamePlayResponse;
import com.flab.baseball.presentation.response.dto.GameStartResponse;
import com.flab.baseball.presentation.response.dto.RoomResultQueryResponse;
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
	private final RoomResultQueryProcessor roomResultProcessor;
	private final GameHistoriesSearchProcessor gameHistoriesSearchProcessor;

	@PostMapping("/start")
	public GameResponse<GameStartResponse> gameStart() {
		GameStartData gameStartData = gameStartProcessor.execute();
		return new GameResponse<>(
			new GameStartResponse(gameStartData)
		);
	}

	@PostMapping("/{roomId}/answer")
	public GameResponse<Object> gamePlay(@PathVariable Long roomId, @RequestBody GamePlayRequest request) {
		try {
			GamePlayData gamePlayData = gamePlayProcessor.execute(roomId, request.getAnswer());
			return new GameResponse<>(
				new GamePlayResponse(gamePlayData)
			);
		} catch (IllegalStateException e) {
			return GameResponse.toError(CLOSED_GAME);
		}
	}

	@GetMapping("/{roomId}")
	public GameResponse<RoomResultQueryResponse> roomResultQuery(@PathVariable Long roomId) {
		RoomResultQueryData roomResultData = roomResultProcessor.execute(roomId);
		return new GameResponse<>(
			new RoomResultQueryResponse(roomResultData)
		);
	}

	@GetMapping("/{roomId}/history")
	public GameResponse<GameHistoriesResponse> findHistory(@PathVariable Long roomId) {
		GameHistoriesData histories = gameHistoriesSearchProcessor.execute(roomId);
		return new GameResponse<>(
			new GameHistoriesResponse(histories)
		);
	}

}
