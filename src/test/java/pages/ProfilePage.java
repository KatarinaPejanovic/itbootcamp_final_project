package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfile;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "urlTwitter")
    private WebElement twitterField;
    @FindBy(id = "urlGitHub")
    private WebElement gitField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button")
    private WebElement verifyAccountCloseButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")
    private WebElement profileEditedMessage;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void doLogout() {
        logOutButton.click();
    }

    public void closeVerifyAccountButton() {
        verifyAccountCloseButton.click();
    }

    public void openEditProfile() {
        myProfile.click();
    }

//    public String getFakeName() {
//        String fakeName = faker.name().firstName();
//        return fakeName;
//    }

//    public String getFakePhone() {
//        String fakePhoneNum = String.valueOf(faker.phoneNumber().cellPhone());
//        return fakePhoneNum;
//    }

//    public String getFakeCountry() {
//        String fakeCountry = faker.country().name();
//        return fakeCountry;
//    }

//    public String getFakeTwitter() {
//        String fakeTwitter = faker.internet().url();
//        return fakeTwitter;
//    }

//    public String getFakeGit() {
//        String fakeGit = faker.internet().url();
//        return fakeGit;
//    }


    public void insertData(String name, String phone, String country, String twitter, String git) throws InterruptedException {
        Thread.sleep(1000);
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);
        nameField.sendKeys(name);
        Thread.sleep(1000);
        phoneField.sendKeys(phone);
        Thread.sleep(1000);
        cityField.sendKeys("New York");
        cityField.sendKeys(Keys.ARROW_DOWN);
        cityField.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        countryField.sendKeys(country);
        Thread.sleep(1000);
        twitterField.sendKeys("https://" + twitter);
        Thread.sleep(1000);
        gitField.sendKeys("https://" + git);
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(5000);
    }

    public String readProfileEditedMessage() {
        return profileEditedMessage.getText();
    }

    public String getNameAttributeValue() {
        return nameField.getAttribute("value");
    }

    public String getPhoneAttributeValue() {
        return phoneField.getAttribute("value");
    }

    public String getCountryAttributeValue() {
        return countryField.getAttribute("value");
    }

    public String getTwitterAttributeValue() {
        return twitterField.getAttribute("value");
    }

    public String getGitAttributeValue() {
        return gitField.getAttribute("value");
    }
}
