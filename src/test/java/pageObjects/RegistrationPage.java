package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	

    @FindBy(xpath="//input[@id='input-telephone']") 
    WebElement txtTelephone;

	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement noRadio;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement submit;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement check;
	
	
	public void setName(String name)
	{
		firstName.sendKeys(name);
	}
	public void setLastName(String lname)
	{
		
	lastName.sendKeys(lname);	
	}
	
	public void setEmail(String emails) {
	
	email.clear();
	email.sendKeys(emails);
		

	} 
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}
     
	
     public void setPassword(String passwords)
     {
    	 password.clear();
    	 password.sendKeys(passwords);
     }
     
     public void setConfirmPassword(String pwd) {
    		txtConfirmPassword.sendKeys(pwd);

    	}
     
     public void setNewsLetter()
     {
    	 noRadio.click();
    	 
     }
     
     public void checkPrivcy()
     {
    	 privacy.click(); 
     }
     
     public void clickSubmit()
     {
    	//sol1 
    		//submit.click();
    		
    		//sol2 
    		//btnContinue.submit();
    		
    		//sol3
//    		Actions act=new Actions(driver);
//    		act.moveToElement(submit).click().perform();
    					
//    		//sol4
//    		JavascriptExecutor js=(JavascriptExecutor)driver;
//    		js.executeScript("arguments[0].click();", submit);
    		
    		//Sol 5
    		submit.sendKeys(Keys.RETURN);
    		
    		//Sol6  
//    		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    		mywait.until(ExpectedConditions.elementToBeClickable(submit)).click();
     }
	
     public String getConfirmationMsg() {
    		try {
    			return (check.getText());
    		} catch (Exception e) {
    			return (e.getMessage());

    		}

    	}
	

}
