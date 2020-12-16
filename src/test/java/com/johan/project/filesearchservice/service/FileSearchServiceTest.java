package com.johan.project.filesearchservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("FileSearchService Unit Tests")
class FileSearchServiceTest {

  private static final String KEYWORD = "sample";

  @InjectMocks
  private FileSearchService cut;

  @Test
  void searchForKeyword_happyPath() {
    final String searchResponse = cut.searchForKeyword(KEYWORD);

    Assertions.assertNotNull(searchResponse);
  }

}
