package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	private WebDriver dr;
	
	public LandingPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	//@FindBy, @FingBys, @FindAll
	
	@FindBy(css="input#txtUsername")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement login;
	
	@FindBy(xpath="//span[starts-with(text(),'Invalid credentials')]")
	private WebElement errorMsg;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement fyp;
	
	public void enterUsername(String str)
	{
		username.sendKeys(str);
	}

	public void enterPassword(String str)
	{
		password.sendKeys(str);
	}
	
	public void clickOnLoginButton()
	{
		login.click();
	}
	
	public void clickOnFYP()
	{
		fyp.click();
	}
	public void loginToApplication(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
	
	public String getErrorMsg()
	{
		return errorMsg.getText().trim();
	}
	
	public boolean isErrorMsgDisplayed()
	{
		boolean b=false;
		try {
			b = errorMsg.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
