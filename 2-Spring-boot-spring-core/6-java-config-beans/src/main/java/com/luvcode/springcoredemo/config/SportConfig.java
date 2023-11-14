package com.luvcode.springcoredemo.config;

import com.luvcode.springcoredemo.common.Coach;
import com.luvcode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
