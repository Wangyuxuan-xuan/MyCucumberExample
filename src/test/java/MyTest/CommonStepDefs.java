package MyTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs{
    @Given("the home page is opened")
    public void theHomePageIsClicked() {
        homepage.openPage();
    }

}
