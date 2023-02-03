package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItem;

    @FindBy(id = "name")
    private WebElement insertName;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement citySavedMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement allCities;

    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editCityButton;

    @FindBy(id = "search")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement nameColumn;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "/html/body/div/div[7]/div/div/div[2]/button[2]/span")
    //todo nadji dobar xpath / class za ovaj element!!!!
    private WebElement secondDeleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement cityDeletedMessage;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void createNewCity(String fakeCity) {
        newItem.click();
        insertName.sendKeys(fakeCity);
        saveButton.click();
    }

    public String readCitySavedMessage() {
        return citySavedMessage.getText();
    }

    public void editMyFakeCity(String fakeCity) {
        search.sendKeys(fakeCity);
        editCityButton.click();
        insertName.sendKeys(fakeCity + "- edited");
        saveButton.click();
    }

    public String findMyEditedCity(String fakeCity) {
        search.sendKeys(fakeCity + "- edited");
        //Sacekati da broj redova u tabeli bude 1 ???
        return nameColumn.getText();
    }

    public void delete() {
        deleteButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[7]/div/div")));
        // secondDeleteButton.click(); //todo obrisati komentar nakon sto nadjes ispravan xpath za delete
    }

    public String readCityDeletedMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated((By) cityDeletedMessage));
        return cityDeletedMessage.getText();
    }
}
