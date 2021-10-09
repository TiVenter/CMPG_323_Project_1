package org.example.web.sb.config;

import org.example.logic.config.LogicConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({LogicConfig.class})
// here we tel it to include the config from the logic to get everything into one
@Configuration
//doing a component scan for all our spring components
@ComponentScan(basePackages = {
        "org.example.web.sb.controller",
        "org.example.web.sb.exception"
})
//This will tell it to scan and pickup anaything that is taged with @component
public class WebConfig {

}
