package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private WebDriver dr;

	public MyInfoPage(WebDriver driver) {
		this.dr = driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="menu_pim_viewMyDetails")
	private WebElement myInfoTab;
	
	@FindBy(xpath="//ul[@id='sidenav']/li/a")
	private List<WebElement> sideMenu;
	
	public void clickOnMyInfoTab()
	{
		myInfoTab.click();
	}
	
	public boolean isMyInfoDisplayed()
	{
		boolean b = false;
		try 
		{
			b=myInfoTab.isDisplayed();
		}catch(Exception e)
		{}
		return b;
	}
	
	public int getSideMenuItemsCount()
	{
		return sideMenu.size();
	}
	
	public List<String> getSideMenuItemsText()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement s:sideMenu)
		{
			temp.add(s.getText());
		}
		return temp;
	}
}
