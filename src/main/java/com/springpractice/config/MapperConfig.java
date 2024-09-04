package com.springpractice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MapperConfig {
  private ModelMapper mapper;

  public MapperConfig () {
    mapper = new ModelMapper();
  }

  @Bean
  public ModelMapper modelMapper() {
    return mapper;
  }
}
