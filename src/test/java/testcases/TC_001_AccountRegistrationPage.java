package testcases;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_AccountRegistrationPage extends BaseClass{
    @Test
    public void verify_account_registration()
    {
        logger.info("starting TC_001_AccountRegistrationPage");
        logger.debug("debbug logs");
        HomePage hp=new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked on myAcc link");
        hp.clickRegister();
        logger.info("Clicked on registration link");

        logger.info("Entering customer details ");
        AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

        regpage.setFirstName(randomeString().toUpperCase());
        regpage.setLastName(randomeString().toUpperCase());
        regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
        regpage.setTelephone(randomeNumber());

        String password=randomAlphaNumeric();

        regpage.setPassword(password);
        regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        regpage.clickContinue();
        logger.info("clicked on continue");

        String confmsg=regpage.getConfirmationMsg();
        logger.info("Validate expected name");
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        logger.info("Finish TC_001_AccountRegistrationPage");

    }
}
