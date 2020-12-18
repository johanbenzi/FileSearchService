package com.johan.project.filesearchservice.service;

import com.johan.project.filesearchservice.exceptions.KeywordNotFoundInDocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
@DisplayName("FileSearchService Unit Tests")
class FileSearchServiceTest {

  private static final String FILE_CONTENT = "This is a new sample text we are using to test the class";

  private static final String KEYWORD = "sample";

  @InjectMocks
  private FileSearchService cut;

  @Test
  void searchForKeyword_happyPath() {
    ReflectionTestUtils.setField(cut, "fileContent", FILE_CONTENT);

    Assertions.assertEquals(" is a new sample text we a", cut.searchForKeyword(KEYWORD));
  }

  @Test
  void searchForKeyword_lessCharactersAvailableInLeft() {
    ReflectionTestUtils.setField(cut, "fileContent", FILE_CONTENT.substring(10));

    Assertions.assertEquals("new sample text we a", cut.searchForKeyword(KEYWORD));
  }

  @Test
  void searchForKeyword_lessCharactersAvailableInRight() {
    ReflectionTestUtils.setField(cut, "fileContent", FILE_CONTENT.substring(0, 25));

    Assertions.assertEquals(" is a new sample text", cut.searchForKeyword(KEYWORD));
  }

  @Test
  void searchForKeyword_noKeywordFound_throwsException() {
    ReflectionTestUtils.setField(cut, "fileContent", FILE_CONTENT);

    Assertions.assertThrows(KeywordNotFoundInDocumentException.class,
      () -> cut.searchForKeyword("a text that doesn't exist in content"));
  }

  @Test
  void searchForKeyword_noExtraText() {
    ReflectionTestUtils.setField(cut, "fileContent", KEYWORD);

    Assertions.assertEquals(KEYWORD, cut.searchForKeyword(KEYWORD));
  }
}