package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement signupErrorMessage;


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void doSignUp(String name, String email, String password) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
        signUpButton.click();
    }

    public String getEmailAttributeType() {
        return email.getAttribute("type");
    }

    public String getPassAttributeType() {
        return password.getAttribute("type");
    }

    public String getConfirmPassAttributeType() {
        return password.getAttribute("type");
    }

    public String readSignupError() {
        return signupErrorMessage.getText();
    }

    public String getFakeEmail() {
        String fakeEmail = faker.internet().emailAddress();
        return fakeEmail;
    }
}
