package testutility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase {

	//Explicit wait.
	public static void waitForElement(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForElementToClickable(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void scrollToElement(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);",ele); 
		//default true
		je.executeScript("window.scrollBy(0,400);", "");
	}
	
	public static void clickUsingJS(WebElement ele) //span unclickable/intraceble
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();",ele); 
	}
	
	public static void captureScreen() throws IOException
	{
		TakesScreenshot tsc= (TakesScreenshot) driver;
		File f=tsc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(getDate()+"_image.png"));//png and jpg
		
	}
	
	public static void attachImagesToReport()
	{
		TakesScreenshot tc=(TakesScreenshot) driver;
		String src = tc.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64," + src + "\" height=\"600\" width=\"800\" />";
		Reporter.log(image);  
	}
	private static String getDate()
	{
		Date dt = new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf= new SimpleDateFormat("y_MMM_dd_HH_mm_ss_SSS");
		String date=sdf.format(dt);
		//System.out.println(date);
		return date;
	}
}
