package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class Homepage {

    private final String PAGE_URL = "http://automationpractice.com/";

    private final By LOGIN_IN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private final By REGISTER_ERROR = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private final By REGISTER_FORM_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol");
    private final By CART_WARNING_MSG = By.xpath("//*[@id=\"center_column\"]/p");

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "SubmitLogin")
    private WebElement submitSignInButton;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement cartButton;

    private WebDriver webDriver;

    public Homepage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage(){
        webDriver.get(PAGE_URL);
        PageFactory.initElements(webDriver,this);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void clickSubmitSignInButton(){
        submitSignInButton.click();
    }

    public void clickCreateAnAccountButton(){
        createAnAccountButton.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void clickCartButton(){
        cartButton.click();
    }

    public void fillFieldById(String fieldName , String msg){
        getField(By.id(fieldName)).sendKeys(msg);
    }

    public void selectDropDown(String fieldName , String text){
        Select select = new Select(getField(By.id(fieldName)));
        select.selectByVisibleText(text);
    }

    public WebElement getField(By locator){
        return webDriver.findElement(locator);
    }

    public Optional<String> getLoginError(){
        return getWebErrorMsg(LOGIN_IN_ERROR);
    }

    public Optional<String> getRegisterError(){
        return getWebErrorMsg(REGISTER_ERROR);
    }

    public Optional<String> getRegisterFormError(){
        return getWebErrorMsg(REGISTER_FORM_ERROR);
    }

    public Optional<String> getCartWarningMsg(){
        return getWebErrorMsg(CART_WARNING_MSG);
    }

    public Optional<String> getWebErrorMsg(By errorLocator){
        Optional<WebElement> webError = getWebError(errorLocator);
        if(webError.isPresent()){
            WebElement errorElement = webError.get();
            return Optional.of(errorElement.getText());
        }else return Optional.empty();
    }

    public Optional<WebElement> getWebError(By errorLocator){
        List<WebElement> webErrorsElements = webDriver.findElements(errorLocator);
        if (webErrorsElements.size() > 0){
            return Optional.of(webErrorsElements.get(0));
        }else return Optional.empty();
    }


    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSubmitSignInButton() {
        return submitSignInButton;
    }
}
