package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void t1ForbidVisitHome() {
        authRoutesPage.visitAPage("/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t2ForbidVisitProfile() {
        authRoutesPage.visitAPage("/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t2ForbidVisitAdminCities() {
        authRoutesPage.visitAPage("/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void t2ForbidVisitAdminUsers() {
        authRoutesPage.visitAPage("/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
