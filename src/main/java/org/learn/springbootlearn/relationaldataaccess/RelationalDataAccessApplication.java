package org.learn.springbootlearn.relationaldataaccess;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Configuration, @EnableAutoConfiguration, @ComponentScan을 포함하는 어노테이션
 * @Configuration: 애플리케이션 컨텍스에 대한  bean 정의
 * @EnableAutoConfiguration: SpringBoot에 beans을 추가하고 classpath 설정, bean, 다양한 property 설정
 * @ComponentScan: 현재 패키지에서 다른 구성요소, 구성 및 서비스를 찾도록 Spring에 지시함.
 */
@SpringBootApplication
public class RelationalDataAccessApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RelationalDataAccessApplication.class, args);

    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customer IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
            "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))"
        );

        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
        .map(name -> name.split(" "))
        .collect(Collectors.toList());
        
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        //?를 사용하여 SQL 주입 공격을 피함
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        log.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
            (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
            ).forEach(customer -> log.info(customer.toString()));
    }
}
