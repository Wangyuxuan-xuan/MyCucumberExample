package MyTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchStepDefs extends AbstractStepDefs{
    @When("the search button is clicked")
    public void theSearchButtonIsClicked() {
        homepage.clickSearchButton();
    }

    @Then("the {string} error message is shown in search")
    public void theMsgErrorMessageIsShownInSearch(String msg) {
        Optional<String> errorMessage = homepage.getSearchWarningMsg();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }

    @Given("the {string} is filled with {string} in search field")
    public void theIsFilledWithInSearchField(String fieldName, String msg) {
        homepage.fillFieldById(fieldName, msg);
    }

    @When("the Enter button is pressed")
    public void theEnterButtonIsPressed() {
        homepage.pressEnterButton();
    }

    @Then("the related item {string} is listed in search")
    public void theRelatedItemIsListedInSearch(String name) {
        Assert.assertEquals(true,homepage.searchRelatedItem(name));

    }

    @Then("the related unique item {string} is listed in search")
    public void theRelatedSingleItemIsListedInSearch(String name) {
        Assert.assertEquals(true,homepage.searchUniqueItem(name));
    }
}
