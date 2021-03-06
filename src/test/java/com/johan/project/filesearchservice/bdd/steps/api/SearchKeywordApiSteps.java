package com.johan.project.filesearchservice.bdd.steps.api;

import lombok.extern.log4j.Log4j2;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Ignore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Ignore
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration
@Log4j2
public class SearchKeywordApiSteps {
  @LocalServerPort
  private int port;

  private String fileSearchServiceRunningUrl;

  @Step(value = "Save a keyword in serenity session")
  public void saveKeyword(final String keyword) {
    Serenity.getCurrentSession().put("KEYWORD", keyword);
  }

  @Step(value = "Attempt to match keyword against text block by hitting the endpoint")
  public void searchKeyword() {
    setFileSearchServiceRunningUrl();
    SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
    SerenityRest.given()
      .contentType("application/json")
      .accept("application/json")
      .when()
      .get(format("%s/documents?keyword=%s", fileSearchServiceRunningUrl, Serenity.getCurrentSession().get("KEYWORD")));
  }

  @Step(value = "Assert response code")
  public void assertResponseCode(final int statusCode) {
    assertThat(SerenityRest.then().extract().statusCode(), is(statusCode));
  }

  @Step(value = "Assert response message")
  public void assertResponseMessage(final String responseMessage) {
    assertThat(SerenityRest.then().extract().response().getBody().prettyPrint(), is(responseMessage));
  }

  private void setFileSearchServiceRunningUrl() {
    SerenityRest.reset();
    try {
      fileSearchServiceRunningUrl = format("http://%s:%s", InetAddress.getLocalHost().getHostAddress(), port);
    }
    catch(final UnknownHostException e) {
      log.error(e, e);
    }
  }
}
