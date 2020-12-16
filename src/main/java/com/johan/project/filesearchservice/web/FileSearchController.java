package com.johan.project.filesearchservice.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@Tag(name = "File Search Controller", description = "Handles requests for various search operations on pre loaded documents.")
public class FileSearchController {

  @GetMapping(path = "/documents")
  @ResponseStatus(value = HttpStatus.OK)
  @Operation(summary = "Search for a keyword in preloaded memory and return context if matched")
  @ApiResponse(responseCode = "200", description = "Keyword matched and context returned", content = @Content(schema = @Schema(implementation = String.class), examples = @ExampleObject(value = "This is an Awesome text matched")))
  @ApiResponse(responseCode = "400", description = "Bad data found", content = @Content)
  @ApiResponse(responseCode = "404", description = "Cannot find keyword in document", content = @Content)
  @ApiResponse(responseCode = "500", description = "Internal server error.", content = @Content)
  public String searchForKeyword(
    @Parameter(description = "keyword to be matched", example = "Awesome text") @RequestParam(value = "keyword") final String keyword) {
    return "Lorem ips " + keyword + " lorem ips";
  }
}
