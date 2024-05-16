package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData" ,dataProviderClass = DataProviders.class)
	
	public void verify_LoginDDT(String email, String password, String exp_result)
	{
		
		logger.info("............Starting TC_03_LoginDDT Test caces...... ");
		
		try {
        HomePage hp = new HomePage(driver);
		
		hp.setAccount();
		logger.info(".......Clicked on my account tabl......");
		
		hp.clickLogin();
		
		logger.info(".....Clicked on login link on home Page under my Account....");
		
		LoginPage lp = new LoginPage(driver);
		logger.info(".........Entering valid email and password....");
		
		lp.setEmail(email);
		lp.setPassword(password);
		
		lp.clickOnLogin();
		logger.info(".......Clicked on Login Button......");
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean target_page = map.isMyAccountPageExist();
		
		if(exp_result.equalsIgnoreCase("valid"))
		{
			if(target_page==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			}else
			{
				Assert.fail();
			}
			
		}
		if(exp_result.equalsIgnoreCase("invalid"))
		{
			if(target_page==true)
			{
				Assert.assertTrue(false);
				map.clickLogout();
			}
			else {
				Assert.assertTrue(true);
			}
				
		}
		
	}catch (Exception e) {
		Assert.fail();
		logger.info("*********Finished Data Driven Test Cases********");
	}
		
	}
}
