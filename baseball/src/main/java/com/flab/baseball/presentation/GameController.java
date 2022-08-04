package com.flab.baseball.presentation;

import com.flab.baseball.presentation.data.GameStartData;
import com.flab.baseball.application.GameStartProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

	private final GameStartProcessor gameStartProcessor;

	@PostMapping("/start")
	public GameResponse<GameStartData> gameStart() {
		GameStartData gameStartData = gameStartProcessor.gameStart();
		return new GameResponse<>(gameStartData);
	}

}
