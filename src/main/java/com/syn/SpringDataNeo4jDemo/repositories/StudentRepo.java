package com.syn.SpringDataNeo4jDemo.repositories;

import com.syn.SpringDataNeo4jDemo.entities.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends Neo4jRepository<Student, Long> {

    Optional<Student> findByName(String name);

    void deleteAllByName(String name);
}
