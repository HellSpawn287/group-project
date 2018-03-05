package com.github.java5wro.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{

    EventEntity findOneByUuid(String uuid);
    Set<EventEntity> findAllByName(String name);
    Set<EventEntity> findAllByAuthor(Long author);
}