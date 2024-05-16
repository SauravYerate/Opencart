package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactoryFinder;

public class HomePage extends BasePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		
	}
	
	
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;
    
    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement register;
    
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login;
    
    public void setAccount()
    {
    	myAccount.click();
    }
    
    public void setRegister()
    {
    	register.click();
    }
    
    public void clickLogin()
    {
    	login.click();
    }
	

}
