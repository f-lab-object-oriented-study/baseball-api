package com.djyun.oopjavabaseballAPI.presentation;

import com.djyun.oopjavabaseballAPI.application.GameService;
import com.djyun.oopjavabaseballAPI.domain.entity.Game;
import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;
import com.djyun.oopjavabaseballAPI.domain.entity.GuessResult;
import com.djyun.oopjavabaseballAPI.presentation.request.GamePlayRequest;
import com.djyun.oopjavabaseballAPI.presentation.response.GameHistoryResponse;
import com.djyun.oopjavabaseballAPI.presentation.response.GamePlayResponse;
import com.djyun.oopjavabaseballAPI.presentation.response.GameResultResponse;
import com.djyun.oopjavabaseballAPI.presentation.response.GameStartResponse;
import com.djyun.oopjavabaseballAPI.shared.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/game")
@RestController
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;

	@PostMapping("/start")
	public ApiResponse<GameStartResponse> gameStart() {
		return ApiResponse.success(new GameStartResponse(gameService.gameStart()));
	}

	@PostMapping("/{roomId}/answer")
	public ApiResponse<GamePlayResponse> gamePlay(@PathVariable int roomId,
		@RequestBody GamePlayRequest request) {
		GuessResult guessResult = gameService.gamePlay(roomId, request.getAnswer());
		return ApiResponse.success(GamePlayResponse.from(guessResult));
	}

	@GetMapping("/{roomId}")
	public ApiResponse<GameResultResponse> gameResult(@PathVariable int roomId) {
		Game gameResult = gameService.getGameResult(roomId);
		return ApiResponse.success(new GameResultResponse(gameResult.getRemainingCount(),
			gameResult.getTotalCount() - gameResult.getRemainingCount()));
	}

	@GetMapping("/{roomId}/history")
	public ApiResponse<GameHistoryResponse> gameHistory(@PathVariable int roomId) {
		GameHistories histories = gameService.getHistories(roomId);
		return ApiResponse.success(GameHistoryResponse.from(histories));
	}

}
