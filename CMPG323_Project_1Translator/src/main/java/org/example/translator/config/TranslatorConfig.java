package org.example.translator.config;

import org.example.repo.persistence.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.example.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "org.example.translator"
        // here we tell it to go and scan in "org.example.translator" package
})
public class TranslatorConfig {

}
