package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    private String fakeCity = faker.address().city();

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.visitLogIn();
        loginPage.doLogin("admin@admin.com", "12345");
        homePage.visitAdminCities();
    }

    @AfterMethod
    public void afterMethod() {
        homePage.doLogOut();
    }

    @Test
    public void t1VisitAdminCities() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogOut().isDisplayed());
    }

    @Test
    public void t2CreateNewCity() {
        adminCitiesPage.createNewCity(fakeCity);
        Assert.assertTrue(adminCitiesPage.readCitySavedMessage().contains("Saved successfully"));
    }

    @Test
    public void t3EditCity() {
        adminCitiesPage.editMyFakeCity(fakeCity);
        Assert.assertTrue(adminCitiesPage.readCitySavedMessage().contains("Saved successfully"));
    }

    @Test
    public void t4SearchCity() {
        Assert.assertTrue(adminCitiesPage.findMyEditedCity(fakeCity).contains(fakeCity + "- edited"));
    }

    @Test
    public void t5DeleteCity() throws InterruptedException {
        Assert.assertTrue(adminCitiesPage.findMyEditedCity(fakeCity).contains(fakeCity + "- edited"));
        adminCitiesPage.delete();
        Thread.sleep(2000);
        Assert.assertTrue(adminCitiesPage.readCityDeletedMessage().contains("Deleted successfully"));
    }
}
