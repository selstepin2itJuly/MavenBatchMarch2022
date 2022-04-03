package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.DashboardPage;
import pages.ForgotYourPassword;
import pages.LandingPage;
import testbase.TestBase;
import testutility.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	private WebDriver dr;
	private LandingPage landingpage;
	private ForgotYourPassword fyp;
	private DashboardPage dp;
	
  @Test(priority=-1, description="Login Success")
  public void LoginSuccess_001() {
	  landingpage.loginToApplication(TestData.username, TestData.password);
	  TestUtility.attachImagesToReport();
	  Assert.assertTrue(dp.isWelcomeDisplayed());
	  //Assert.assertEquals(dp.getWelcomeMsg(), "Welcome smita");
	  Assert.assertTrue(dp.getWelcomeMsg().contains("Welcome"));
  }
  
  @Test(priority=-2, description="Login unsuccessful", enabled=false)
  public void LoginUnsuccessful_002() {
	  landingpage.loginToApplication(TestData.username, "Random");
	  TestUtility.attachImagesToReport();
	  Assert.assertFalse(dp.isWelcomeDisplayed());
	  Assert.assertEquals(landingpage.getErrorMsg(), "Invalid credentials");
	  
  }
  
  @Test(priority=0, description="Forgot Password")
  public void ForgotPassword_003() {
	  landingpage.clickOnFYP();
	  TestUtility.attachImagesToReport();
	  Assert.assertTrue(fyp.isResetButtonDisplayed());
	  fyp.clickCancel();
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr = TestBase.getInstance();
	  landingpage = new LandingPage(dr);
	  fyp = new ForgotYourPassword(dr);
	  dp = new DashboardPage(dr);
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
