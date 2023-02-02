package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement loginError;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void doLogin(String email, String password) {
        this.email.clear();
        this.password.clear();

        this.email.sendKeys(email);
        this.password.sendKeys(password);

        logInButton.click();
    }

    public String getEmailAttributeType() {
        return email.getAttribute("type");
    }

    public String getPassAttributeType() {
        return password.getAttribute("type");
    }

    public String getFakeEmail() {
        String fakeEmail = faker.internet().emailAddress();
        return fakeEmail;
    }

    public String getFakePassword() {
        String fakePassword = faker.internet().password();
        return fakePassword;
    }

    public String readLoginErrorMssg() {
        return loginError.getText();
    }

}
