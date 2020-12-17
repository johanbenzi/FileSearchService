package com.johan.project.filesearchservice.listener;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.setProperty;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

  @SneakyThrows
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
    setProperty("com.johan.project.file.content",
      Files.readString(Path.of(ClassLoader.getSystemResource("pride-and-predjudice.txt").toURI())));
  }
}