package kr.flab.baseballapi.domain.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballTests {
    private GameRoom gameRoom;

    @BeforeEach
    public void setupGameRoom() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        gameRoom = new GameRoom(10000);
        
        Field gameField = gameRoom.getClass().getDeclaredField("game");
        gameField.setAccessible(true);
        Game game = (Game) gameField.get(gameRoom);

        Field correctAnswerField = game.getClass().getDeclaredField("correctAnswer");
        correctAnswerField.setAccessible(true);
        correctAnswerField.set(game, new Answer(1, 2, 3));
    }

    @Test
    public void strike_judged() {
        assertEquals(1,
            gameRoom.judge(
                new Answer(1, 8, 9)
            ).get()
            .getStrikes()
        );
    }

    @Test
    public void ball_judged() {
        assertEquals(1,
            gameRoom.judge(
                new Answer(8, 1, 9)
            ).get()
            .getBalls()
        );
    }

    @Test
    public void out_judged() {
        assertEquals(1,
            gameRoom.judge(
                new Answer(1, 2, 9)
            ).get()
            .getOuts()
        );
    }

    @Test
    public void three_strike_closed_judged() {
        assertEquals(3,
            gameRoom.judge(
                new Answer(1, 2, 3)
            ).get()
            .getStrikes()
        );
        
        assertEquals(true, gameRoom.isClosed());
    }
}
