package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignUpTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.visitSignUp();
    }

    @Test
    public void t1VisitSignUp() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void t2CheckInputType() {
        Assert.assertEquals(signupPage.getEmailAttributeType(), "email");
        Assert.assertEquals(signupPage.getPassAttributeType(), "password");
        Assert.assertEquals(signupPage.getConfirmPassAttributeType(), "password");
    }

    @Test
    public void t3UserExistsError() {
        signupPage.doSignUp("Test Test", "admin@admin.com", "123654");
        Assert.assertTrue(signupPage.readSignupError().contains("E-mail already exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void t4SignUp() throws InterruptedException {
        signupPage.doSignUp("Katarina P", signupPage.getFakeEmail(), "myPass12345"); //fakeEmail sam stavila, zato sto ne kreira novi account ako je prilikom svakog testiranja isti email, vec izbacuje error E-mail already exists
        Thread.sleep(2000);
        Assert.assertTrue(homePage.readVerifyAccountMssg().contains("Verify your account"));
    }
}
