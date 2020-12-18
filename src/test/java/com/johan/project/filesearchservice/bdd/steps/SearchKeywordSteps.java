package com.johan.project.filesearchservice.bdd.steps;

import com.johan.project.filesearchservice.bdd.steps.api.SearchKeywordApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchKeywordSteps {

  @Steps
  private SearchKeywordApiSteps searchKeywordApiSteps;

  @Given("^Keyword (.*)$")
  public void saveKeyword(final String keyword) {
    searchKeywordApiSteps.saveKeyword(keyword);
  }

  @When("The keyword is attempted to be matched")
  public void searchKeyword() {
    searchKeywordApiSteps.searchKeyword();
  }

  @Then("^A response code (.*) is obtained")
  public void assertResponseStatus(final int statusCode) {
    searchKeywordApiSteps.assertResponseCode(statusCode);
  }

  @Then("^The search context (.*) is obtained")
  public void assertSearchContext(final String searchContext) {
    searchKeywordApiSteps.assertResponseMessage(searchContext);
  }

  @Then("^An Error message (.*) is obtained")
  public void assertErrorMessage(final String errorMessage) {
    searchKeywordApiSteps.assertResponseMessage(errorMessage);
  }
}
