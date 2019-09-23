package com.syn.SpringDataNeo4jDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@ComponentScan
@EnableNeo4jRepositories
public class Config {

}
