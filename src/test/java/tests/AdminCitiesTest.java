package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.visitLogIn();
        loginPage.doLogin("admin@admin.com", "12345");
        homePage.visitAdminCities();
    }

    @Test
    public void t1VisitAdminCities() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogOut().isDisplayed());
    }

    @Test
    public void t2CreateNewCity() {
        adminCitiesPage.createNewCity();
        Assert.assertTrue(adminCitiesPage.readCitySavedMessage().contains("Saved successfully"));
    }
}
