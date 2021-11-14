package MyTest;

import io.cucumber.java.en.*;
import org.junit.Assert;

import static org.junit.Assert.*;

import java.util.Optional;

public class SignInButtonStepDefs extends AbstractStepDefs{



    @Given("the {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field,String parameter) {
       homepage.fillFieldById(field,parameter);
    }

    @When("the Submit Sign In button is clicked")
    public void theSubmitSignInButtonIsClicked() {
        homepage.clickSubmitSignInButton();
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homepage.getLoginError();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }
}
