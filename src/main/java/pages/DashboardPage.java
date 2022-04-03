package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver dr;

	public DashboardPage(WebDriver driver) {
		this.dr = driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//a[starts-with(text(),'Welcome')]")
	private WebElement welcome;
	
	@FindBy(id="menu_dashboard_index")
	private WebElement dashboard;
	
	@FindBy(css="span.quickLinkText")
	private List<WebElement> quickLaunch;
	
	public String getWelcomeMsg()
	{
		return welcome.getText().trim();
	}
	
	public boolean isWelcomeDisplayed()
	{
		boolean b=false;
		try {
			b = welcome.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public boolean isDashboardDisplayed()
	{
		boolean b=false;
		try {
			b = dashboard.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public List<String> getQuickLanchItems()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement s:quickLaunch)
		{
			temp.add(s.getText());
		}
		return temp;
	}
	
	public int getQuickLaunchItemCounts()
	{
		return quickLaunch.size();
	}
	
	
}
