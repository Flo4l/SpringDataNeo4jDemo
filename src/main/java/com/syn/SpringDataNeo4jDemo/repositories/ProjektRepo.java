package com.syn.SpringDataNeo4jDemo.repositories;

import com.syn.SpringDataNeo4jDemo.entities.Projekt;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepo extends Neo4jRepository<Projekt, Long> {

    Long deleteAllByName(String name);
}
