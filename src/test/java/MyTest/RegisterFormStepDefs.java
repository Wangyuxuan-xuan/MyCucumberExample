package MyTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class RegisterFormStepDefs extends AbstractStepDefs{
    @And("the register email address is filled with {string}")
    public void theRegisterEmailAddressIsFilledWith(String msg) {
        homepage.fillFieldById("email_create",msg);
    }



    @And("the Customer First Name is filled with {string} in register form")
    public void theCustomerFirstNameIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("customer_firstname",arg0);
    }

    @And("the Customer Last Name is filled with {string} in register form")
    public void theCustomerLastNameIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("customer_lastname",arg0);
    }

    @And("the Address First Name is filled with {string} in register form")
    public void theAddressFirstNameIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("firstname",arg0);
    }

    @And("the Address Last Name is filled with {string} in register form")
    public void theAddressLastNameIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("lastname",arg0);
    }

    @And("the Address Field is filled with {string} in register form")
    public void theAddressFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("address1",arg0);
    }

    @And("the City Field is filled with {string} in register form")
    public void theCityFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("city",arg0);
    }

    @And("the Mobile Number Field is filled with {string} in register form")
    public void theMobileNumberFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("phone_mobile",arg0);
    }

    @And("the Alias Field is filled with {string} in register form")
    public void theAliasFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("alias",arg0);
    }

    @And("the State Field is selected with {string} in register form")
    public void theStateFieldIsSelectedWithInRegisterForm(String arg0) {
        homepage.selectDropDown("id_state",arg0);
    }

    @And("the Country Field is selected with {string} in register form")
    public void theCountryFieldIsSelectedWithInRegisterForm(String arg0) {
        homepage.selectDropDown("id_country",arg0);
    }

    @Then("success")
    public boolean success() {
        return true;
    }

    @And("the Zip Code Field is filled with {string} in register form")
    public void theZipCodeFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("postcode",arg0);
    }


    @When("the Register button is clicked")
    public void theRegisterButtonIsClicked() {
        homepage.clickRegisterButton();
    }

    @Given("the {string} is filled with {string} in register form")
    public void theFieldIsFilledWithParameterInRegisterForm(String field , String msg) {
        homepage.fillFieldById(field, msg);
    }

    @Then("the {string} error message is shown in register form")
    public void theMsgErrorMessageIsShownInRegisterForm(String msg) {
        Optional<String> errorMessage = homepage.getRegisterFormError();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }

    @And("the Password Field is filled with {string} in register form")
    public void thePasswordFieldIsFilledWithInRegisterForm(String arg0) {
        homepage.fillFieldById("passwd",arg0);
    }
}
