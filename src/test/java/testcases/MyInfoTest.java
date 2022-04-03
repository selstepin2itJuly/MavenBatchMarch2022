package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.DashboardPage;
import pages.LandingPage;
import pages.MyInfoPage;
import testbase.TestBase;
import testutility.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class MyInfoTest {
	private WebDriver dr;
	private LandingPage lp;
	private DashboardPage dp;
	private MyInfoPage mp;

	@Test(priority = 1, description="Get My Info Side Menu Items")
	public void getMyInfoSideMenuItems_005() {
		
		lp.enterUsername(TestData.username);
		lp.enterPassword(TestData.password);
		lp.clickOnLoginButton();
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(dp.isWelcomeDisplayed());
		mp.clickOnMyInfoTab();
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(mp.isMyInfoDisplayed());
		List<String> actual = mp.getSideMenuItemsText();

		List<String> exp = new ArrayList<String>();
		exp.add("Personal Details");
		exp.add("Contact Details");
		exp.add("Emergency Contacts");
		exp.add("Dependents");
		exp.add("Immigration");
		exp.add("Job");
		exp.add("Salary");
		exp.add("Tax Exemptions");
		exp.add("Report-to");
		exp.add("Qualifications");
		exp.add("Memberships");
		 TestUtility.attachImagesToReport();
		 Reporter.log(actual+"--->"+exp);
		Assert.assertEquals(actual, exp);
	}

	@Test(priority=2, description="Side Menu item count")
	public void getMyInfoSideMenuItemsCount_007() {
		lp.enterUsername(TestData.username);
		lp.enterPassword(TestData.password);
		lp.clickOnLoginButton();
		Assert.assertTrue(dp.isWelcomeDisplayed());
		mp.clickOnMyInfoTab();
		 TestUtility.attachImagesToReport();
		Assert.assertTrue(mp.isMyInfoDisplayed());
		int actual = mp.getSideMenuItemsCount();
		int exp = 11;
		 TestUtility.attachImagesToReport();
		 Reporter.log(actual+"--->"+exp);
		Assert.assertEquals(actual, exp);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		dr = TestBase.getInstance();
		lp = new LandingPage(dr);
		dp = new DashboardPage(dr);
		mp = new MyInfoPage(dr);
	}

	@AfterMethod
	public void afterMethod() {
		dr.quit();
	}

}
