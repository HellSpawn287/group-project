package com.github.java5wro.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{
    @Query("SELECT e FROM EventEntity e WHERE e.author LIKE CONCAT ('%', :author,'%')")
    List<EventEntity> allEventsByAuthor(@Param("author") Long author);

    @Query("SELECT e FROM EventEntity e WHERE e.name LIKE CONCAT ('%', :name, '%')")
    List<EventEntity> eventsByName (@Param("name") String name);
}