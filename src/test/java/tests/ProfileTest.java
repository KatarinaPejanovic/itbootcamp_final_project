package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.visitSignUp();
        signupPage.doSignUp("Katarina", signupPage.getFakeEmail(), "myPass123456");
        profilePage.closeVerifyAccountButton();
        profilePage.openEditProfile();
    }

    @Test
    public void t1EditProfile() throws InterruptedException {
        String fakeName = faker.name().firstName();
        String fakePhoneNum = String.valueOf(faker.phoneNumber().cellPhone());
        String fakeCountry = faker.country().name();
        String fakeTwitter = faker.internet().url();
        String fakeGit = faker.internet().url();
        profilePage.insertData(fakeName, fakePhoneNum, fakeCountry, fakeTwitter, fakeGit);

        Assert.assertTrue(profilePage.readProfileEditedMessage().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getNameAttributeValue(), fakeName);
        Assert.assertEquals(profilePage.getPhoneAttributeValue(), fakePhoneNum);
        Assert.assertEquals(profilePage.getCountryAttributeValue(), fakeCountry);
        Assert.assertEquals(profilePage.getTwitterAttributeValue(), "https://" + fakeTwitter);
        Assert.assertEquals(profilePage.getGitAttributeValue(), "https://" + fakeGit);
    }

    @AfterMethod
    public void afterMethod() {
        profilePage.doLogout();
    }
}
