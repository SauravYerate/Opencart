package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_01_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"regression"})
    public void verifyAccountRegistration() {
        logger.info("**** Starting TC_01_AccountRegistrationTest *****");

        logger.debug("Application logs started...");
        logger.debug("Application logs.............");

        try {
            HomePage hp = new HomePage(driver);
            hp.setAccount();
            logger.info("Clicked on MyAccount link");

            hp.setRegister();
            logger.info("Clicked on Registration link");

            logger.info("Entering customer details...");

            RegistrationPage rp = new RegistrationPage(driver);
            rp.setName(randomeString().toUpperCase());
            rp.setLastName(randomeString().toUpperCase());
            rp.setEmail(randomeString() + "@gmail.com"); // Randomly generated email
            rp.setTelephone(randomeNumber());

            String password = randomAlphaNumeric();

            rp.setPassword(password);
            rp.setConfirmPassword(password);
            rp.setNewsLetter();
            rp.checkPrivcy();

            rp.clickSubmit();
            logger.info("Clicked on Continue...");

            String confmsg = rp.getConfirmationMsg();
//        	Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");
//            logger.info("Validated expected message.");
            
            if(confmsg.equals("Your Account Has Been Created!"))
            {
            	logger.info("......Test Passed.....");
            	Assert.assertTrue(true);
            }
            else
            {
            	logger.info("......Test Failed.....");
            	Assert.fail();
            }

        } catch (Exception e) {
            logger.error("Test failed.", e);
            logger.debug("Debug logs...");
            Assert.fail("Test case failed due to an exception: " + e.getMessage());
        }

        logger.debug("Application logs end...");
        logger.info("**** Finished TC_01_AccountRegistrationTest *****");
    }
}
