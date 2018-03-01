package com.github.java5wro.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{
//    @Query(value = "SELECT EventEntity FROM EventEntity e WHERE e.author LIKE CONCAT ('%', _5,'%')")
//    List<EventEntity> allEventsByAuthor(@Param("author") String author);
//
//    @Query(value = "SELECT EventEntity FROM EventEntity WHERE u.username LIKE CONCAT('%',:username,'%')")
//    List<EventEntity> findUsersWithPartOfName(@Param("username") String username);
//
//    @Query(value = "SELECT EventEntity FROM EventEntity WHERE e.name LIKE CONCAT ('%', :name, '%')")
//    List<EventEntity> eventsByName (@Param("name") String name);
}