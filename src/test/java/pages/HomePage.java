package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement logIn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement signUp;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logOut;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div")
    private WebElement verifyAccount;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void visitLogIn() {
        logIn.click();
    }

    public void visitSignUp() {
        signUp.click();
    }

    public WebElement getLogOut() {
        return logOut;
    }

    public void doLogOut() {
        logOut.click();
    }

    public String readVerifyAccountMssg() {
        return verifyAccount.getText();
    }
}
