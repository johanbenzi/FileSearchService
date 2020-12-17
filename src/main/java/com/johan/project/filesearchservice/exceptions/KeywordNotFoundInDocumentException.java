package com.johan.project.filesearchservice.exceptions;

public class KeywordNotFoundInDocumentException extends RuntimeException {
  public KeywordNotFoundInDocumentException(final String message) {
    super(message);
  }
}
