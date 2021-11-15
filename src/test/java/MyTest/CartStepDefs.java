package MyTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs{
    @Given("the Cart button is clicked")
    public void theCartButtonIsClicked() {
        homepage.clickCartButton();
    }

    @Then("the {string} error message is shown in cart")
    public void theErrorMessageIsShownInCart(String msg) {
        Optional<String> errorMessage = homepage.getCartWarningMsg();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }

    @Given("the item {string} is added to cart")
    public void theItemIsAddedToCart(String arg0) throws InterruptedException {
        homepage.clickShortSleeveShirtImage();
        homepage.clickAddToCartButton();
    }

    @Then("the item {string} is listed in cart")
    public void theItemIsListedInCart(String arg0) {
        Assert.assertEquals(true,homepage.checkCartItems(arg0));
    }

    @Given("the item is removed form cart")
    public void theItemIsRemovedFormCart() {
        homepage.clickRemoveItemButton();
    }

    @And("the proceed to check out button is clicked")
    public void theProceedToCheckOutButtonIsClicked() {
        homepage.clickProceedToCheckOutButton();
    }

    @Then("the item {string} is not listed in cart")
    public void theItemIsNotListedInCart(String arg0) {
        Assert.assertEquals(false,homepage.checkCartItems(arg0));
    }
}
