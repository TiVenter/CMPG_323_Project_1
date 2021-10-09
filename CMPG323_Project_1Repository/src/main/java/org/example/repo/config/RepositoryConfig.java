package org.example.repo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("org.example.repo.persistence") // scans for the respostories(AccountTypeRepository) in our persistence package
@EntityScan("org.example.domain.persistance")// Scans for our database entities specifed in CMPG323Domain child class
// specify were to find the classpath then the class path wil connect and get data from oracle
@PropertySource(value = "classpath:application-db.properties")

public class RepositoryConfig {
}
