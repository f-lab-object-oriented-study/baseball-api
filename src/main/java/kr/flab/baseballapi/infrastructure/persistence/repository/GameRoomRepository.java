package kr.flab.baseballapi.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameRoomEntity;

@Repository
public interface GameRoomRepository extends JpaRepository<GameRoomEntity, Long> {

}
