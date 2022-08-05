package com.djyun.oopjavabaseballAPI.application;

import com.djyun.oopjavabaseballAPI.domain.entity.GameHistories;
import com.djyun.oopjavabaseballAPI.domain.entity.GuessResult;
import com.djyun.oopjavabaseballAPI.domain.generator.AnswerGenerator;
import com.djyun.oopjavabaseballAPI.domain.generator.GameIdGenerator;
import com.djyun.oopjavabaseballAPI.domain.entity.Game;
import com.djyun.oopjavabaseballAPI.domain.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;
	private final GameIdGenerator gameIdGenerator;
	private final AnswerGenerator answerGenerator;

	/**
	 * roomId, random answer 생성 게임 생성 게임 저장
	 *
	 * @return 저장한 게임
	 */
	public int gameStart() {
		Game game = new Game(gameIdGenerator.generate(), false, answerGenerator.generate(), 10, 10);
		Game savedGame = gameRepository.save(game);
		return savedGame.getRoomId();
	}

	public GuessResult gamePlay(int roomId, String guessAnswer) {
		Game currentGame = gameRepository.findById(roomId);
		// 게임 결과 계산
		GuessResult gamePlayResult = currentGame.guess(guessAnswer);
		// 히스토리 저장
		GameHistories gameHistories = currentGame.makeHistory(gamePlayResult);
		gameRepository.saveHistory(roomId, gameHistories);
		// 게임 결과 반환
		return gamePlayResult;
	}


	public Game getGameResult(int roomId) {
		return gameRepository.findById(roomId);
	}

	public GameHistories getHistories(int roomId) {
		return gameRepository.getHistories(roomId);
	}
}
