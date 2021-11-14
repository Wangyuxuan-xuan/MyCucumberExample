package MyTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class RegisterStepDefs extends AbstractStepDefs{


    @And("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        homepage.clickSignInButton();
    }


    @Given("the {string} is filled with {string} in register")
    public void theFieldIsFilledWithParameterInRegister(String fieldName , String msg) {
        homepage.fillFieldById(fieldName, msg);
    }

    @When("the Create An Account button is clicked")
    public void theCreateAnAccountButtonIsClicked() {
        homepage.clickCreateAnAccountButton();
    }

    @Then("the {string} error message is shown in register")
    public void theMsgErrorMessageIsShownInRegister(String msg) {
        Optional<String> errorMessage = homepage.getRegisterError();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }
}
