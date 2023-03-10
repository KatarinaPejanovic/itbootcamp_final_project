package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(className = "btnES")
    private WebElement spanishLanguageButton;

    @FindBy(className = "btnEN")
    private WebElement englishLanguageButton;

    @FindBy(className = "btnFR")
    private WebElement frenchLanguageButton;

    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement mainMessage;

    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void setToSpanish() {
        languageButton.click();
        spanishLanguageButton.click();
    }

    public String readMainMessage() {
        return mainMessage.getText();
    }

    public void setToEnglish() {
        languageButton.click();
        englishLanguageButton.click();
    }

    public void setToFrench() {
        languageButton.click();
        frenchLanguageButton.click();
    }
}
