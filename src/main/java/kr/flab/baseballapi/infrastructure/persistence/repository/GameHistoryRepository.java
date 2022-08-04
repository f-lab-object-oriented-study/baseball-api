package kr.flab.baseballapi.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.flab.baseballapi.infrastructure.persistence.entity.GameHistoryEntity;

@Repository
public interface GameHistoryRepository extends JpaRepository<GameHistoryEntity, Long> {
    List<GameHistoryEntity> findByRoomId(Long roomId);
}

