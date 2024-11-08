package com.amit.springbootwebtutorial.springbootwebtutorial.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
    @Bean
    public   ModelMapper getmodelMapper(){
        return new ModelMapper();
    }
}
