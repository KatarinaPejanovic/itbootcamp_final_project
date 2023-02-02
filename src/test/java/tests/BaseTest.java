package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    Faker faker = new Faker();

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\IT Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
