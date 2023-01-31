package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
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
    public void t5LogIn() throws InterruptedException {
        loginPage.doLogin("admin@admin.com", "12345");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void t6LogOut() throws InterruptedException {  //da li moze nesto da se skrati??
        Assert.assertTrue(homePage.getLogOut().isDisplayed());
        homePage.doLogOut();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
