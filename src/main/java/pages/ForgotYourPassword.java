package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPassword {

	private WebDriver dr;
	public ForgotYourPassword(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(className="searchValues")
	private WebElement reset;
	
	@FindBy(className="cancel")
	private WebElement cancel;
	
	public void clickCancel()
	{
		cancel.click();
	}
	
	public boolean isResetButtonDisplayed()
	{
		boolean b=false;
		try {
			b = reset.isDisplayed();
		}catch(Exception e)
		{
			
		}
		return b;
	}
}
