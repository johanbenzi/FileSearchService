package com.johan.project.filesearchservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class FileSearchController {

  @GetMapping(path = "/documents")
  @ResponseStatus(value = HttpStatus.OK)
  public String searchForKeyword(@RequestParam(value = "keyword") final String keyword) {
    return "Lorem ips " + keyword + " lorem ips";
  }
}
