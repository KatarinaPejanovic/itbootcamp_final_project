package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
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
        return nameColumn.getText();
    }

    public void delete() {
        deleteButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")));
        secondDeleteButton.click();
    }

    public String readCityDeletedMessage() {
        return cityDeletedMessage.getText();
    }
}
