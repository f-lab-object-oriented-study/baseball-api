package kr.flab.baseballapi.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column
    private Long remainingCount;
    @Column
    private Long answerCount;
    @Column
    private String answer;

    public GameRoom(Long remainingCount, String answer) {
        this.remainingCount = remainingCount;
        this.answerCount = 0L;
        this.answer = answer;
    }
}
