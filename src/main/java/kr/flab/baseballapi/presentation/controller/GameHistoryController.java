package kr.flab.baseballapi.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.baseballapi.application.service.GameHistoryService;
import kr.flab.baseballapi.presentation.data.GameHistoryData;
import kr.flab.baseballapi.presentation.data.common.Response;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameHistoryController {

    private final GameHistoryService gameHistoryService;

    @GetMapping("/{roomId}/history")
    public Response getHistories(@PathVariable("roomId") Long roomId) {
        GameHistoryData historyData = gameHistoryService.progress(roomId);
        return new Response(historyData);
    }

}
