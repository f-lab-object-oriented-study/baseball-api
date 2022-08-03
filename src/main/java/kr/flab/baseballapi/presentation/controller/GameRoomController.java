package kr.flab.baseballapi.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.baseballapi.application.data.GameStartData;
import kr.flab.baseballapi.application.service.GameStartService;
import kr.flab.baseballapi.presentation.data.Response;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameRoomController {

    private final GameStartService gameStartService;

    @PostMapping(value="/start")
    public Response startGame() {
        GameStartData gameStartData = gameStartService.progress();  
        return new Response(true, gameStartData);
    }
    
}
