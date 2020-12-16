package com.johan.project.filesearchservice.web;

import com.johan.project.filesearchservice.service.FileSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("FileSearchController Unit Tests")
class FileSearchControllerTest {

  private static final String KEYWORD = "sample";

  @Mock
  private FileSearchService fileSearchService;

  @InjectMocks
  private FileSearchController cut;

  @Test
  void searchForKeyword_happyPath() {
    cut.searchForKeyword(KEYWORD);

    verify(fileSearchService, times(1)).searchForKeyword(KEYWORD);
    verifyNoMoreInteractions(fileSearchService);
  }

  @Test
  void searchForKeyword_emptyKeyword_throwsIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> cut.searchForKeyword(""));

    verifyNoInteractions(fileSearchService);
  }
}