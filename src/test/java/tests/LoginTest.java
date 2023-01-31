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
    public void visitLoginPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checkInputType() {
        Assert.assertEquals(loginPage.getEmailAttributeType(), "email");
        Assert.assertEquals(loginPage.getPassAttributeType(), "password");
    }

    @Test
    public void userNotExist() {
        loginPage.doLogin(loginPage.getFakeEmail(), loginPage.getFakePassword());
        Assert.assertTrue(loginPage.LoginErrorMssg().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void wrongPass() {
        loginPage.doLogin("admin@admin.com", loginPage.getFakePassword());
        Assert.assertTrue(loginPage.LoginErrorMssg().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }
}
