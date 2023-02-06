package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.visitLogIn();
    }

    @Test
    public void t1VisitLogin() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t2CheckInputType() {
        Assert.assertEquals(loginPage.getEmailAttributeType(), "email");
        Assert.assertEquals(loginPage.getPassAttributeType(), "password");
    }

    @Test
    public void t3UserNotExist() {
        loginPage.doLogin(loginPage.getFakeEmail(), loginPage.getFakePassword());
        Assert.assertTrue(loginPage.readLoginErrorMssg().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t4WrongPass() {
        loginPage.doLogin("admin@admin.com", loginPage.getFakePassword());
        Assert.assertTrue(loginPage.readLoginErrorMssg().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t5LogIn() {
        loginPage.doLogin("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]")));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void t6LogOut() {
        Assert.assertTrue(homePage.getLogOut().isDisplayed());
        homePage.doLogOut();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
