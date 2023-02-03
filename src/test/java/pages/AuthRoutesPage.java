package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthRoutesPage extends BasePage {

    public AuthRoutesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void visitAPage(String route) {
        driver.get("https://vue-demo.daniel-avellaneda.com" + route);
    }
}
