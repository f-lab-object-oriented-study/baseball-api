package kr.flab.baseballapi.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoom;

@Repository
public interface GameRoomRepository extends JpaRepository<GameRoom, Long> {

}
