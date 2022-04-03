package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	//singleton -> one browser instance for framework.
	
	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static WebDriver getInstance() throws IOException
	{
		String file="src/main/java/config/config.properties";
		FileInputStream input=new FileInputStream(file);
		
		prop = new Properties();
		prop.load(input);
		browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();	
		} else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();	
		} else if( browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		} /*else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}*/
		else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		//Implicit wait
		//Duration.ofSeconds(30);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

}
