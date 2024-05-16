package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOut;
	
	
	public boolean isMyAccountPageExist()
	{
		try {
			return myHeading.isDisplayed();
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	
	public void clickLogout()
	{
		logOut.click();
	}

}
