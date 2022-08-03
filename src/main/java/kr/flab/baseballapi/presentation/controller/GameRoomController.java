package kr.flab.baseballapi.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.baseballapi.application.data.GamePlayData;
import kr.flab.baseballapi.application.data.GameStartData;
import kr.flab.baseballapi.application.service.GamePlayService;
import kr.flab.baseballapi.application.service.GameStartService;
import kr.flab.baseballapi.presentation.command.GamePlayCommand;
import kr.flab.baseballapi.presentation.data.Error;
import kr.flab.baseballapi.presentation.data.ErrorCode;
import kr.flab.baseballapi.presentation.data.Response;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameRoomController {

    private final GameStartService gameStartService;
    private final GamePlayService gamePlayService;

    @PostMapping("/start")
    public Response startGame() {
        GameStartData gameStartData = gameStartService.progress();  
        return new Response(gameStartData);
    }

    @PostMapping("/{roomId}/answer")
    public Response playGame(@PathVariable("roomId") Long roomId, @RequestBody GamePlayCommand playCommand) {
        Optional<GamePlayData> gamePlayData = gamePlayService.progress(roomId, playCommand.getAnswer());

        if (gamePlayData.isEmpty()) {
            return new Response(new Error(ErrorCode.CLOSED_GAME, ""));
        }
        return new Response(gamePlayData.get());
    }
    
    
}
