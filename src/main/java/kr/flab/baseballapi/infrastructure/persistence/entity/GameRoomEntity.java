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
public class GameRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    @Column
    private Long remainingCount;
    @Column
    private Long answerCount;
    @Column
    private String answer;
    @Column
    private boolean closed;

    public GameRoomEntity(Long remainingCount, String answer, boolean closed) {
        this.remainingCount = remainingCount;
        this.answerCount = 0L;
        this.answer = answer;
    }

    public void updateCounts(Long remainingCount, Long answerCount) {
        this.remainingCount = remainingCount;
        this.answerCount = answerCount;
    }

    public void updateClosed() {
        this.closed = true;
    }
}
