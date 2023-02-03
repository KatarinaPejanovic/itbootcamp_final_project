package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    @Test
    public void t1SetToSpanish() {
        localePage.setToSpanish();
        Assert.assertTrue(localePage.readMainMessage().contains("Página de aterrizaje"));
    }

    @Test
    public void t2SetToEnglish() {
        localePage.setToEnglish();
        Assert.assertTrue(localePage.readMainMessage().contains("Landing"));
    }

    @Test
    public void t3SetToFrench() {
        localePage.setToFrench();
        Assert.assertTrue(localePage.readMainMessage().contains("Page d'atterrissage"));
    }
}
