package org.example.logic.config;

import org.example.translator.config.TranslatorConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages ={ // this will pickup our component in FetchAccountTypeFlowImpl
    "org.example.logic.flow"
        })
public class LogicConfig {
}
