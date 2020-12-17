package com.johan.project.filesearchservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class FileSearchService {

  @Value("${com.johan.project.file.content}")
  private final String fileContent;

  public String searchForKeyword(final String keyword) {
    final int startingIndex = fileContent.indexOf(keyword);
    if(startingIndex == -1)
      throw new RuntimeException();
    return fileContent
      .substring(Math.max(startingIndex - 10, 0),
        Math.min(startingIndex + keyword.length() + 10, fileContent.length()));
  }
}
