package test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.HomePage;
import pages.LoginPage;
import utilits.Utility;


public class Tests {
	public static WebDriver driver;
	ExtentReports extent;
	 ExtentTest logger;
	 
	@BeforeTest
	public void StartReport() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentFinalReportTwo.html");
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    logger=extent.createTest("Twitter Assessment Test Cases");
	}
	 
	@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@Test
	public void TweetWithValidText() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    hpage.TweetwithValidText();
	    Assert.assertEquals(true,hpage.ConfirmationDisplay());
	}
	@Test
	public void TweetWithMoreThanMaxLength() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    hpage.TweetwithInvalidText();
	    Assert.assertEquals("-2",hpage.CountErrorDisplay());
	}
	@Test
	public void TweetWithValidTweetTwice() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    	hpage.TypeTweetTwice();
	    Assert.assertEquals(true,hpage.TweetTwoErrorDisplay());
	}
	@Test
	public void TestAddingPoll() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    hpage.AddPollQuestion();
	    Assert.assertEquals(true,hpage.ConfirmationDisplay());
	}
	@Test
	public void TweetWithValidGif() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    hpage.AddGif();
	    Assert.assertEquals(true,hpage.ConfirmationDisplay());
	}
	@Test
	public void TweetWithInvalidFileType() throws Exception {
		LoginPage lopga = new LoginPage(driver);
		HomePage hpage = new HomePage(driver);
		lopga.SetUpChrome();
	    hpage=	lopga.Login("testtwe71186212","Test@12345");
	    hpage.TweetWithInvalidFileType();
	    Assert.assertEquals(true,hpage.TweetTwoErrorDisplay());
	}
	@AfterMethod
	public void tearDown(ITestResult result)throws IOException {
		if(result.getStatus()==ITestResult.FAILURE )
		{
			String temp=Utility.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String temp=Utility.getScreenshot(driver);
			logger.log(Status.PASS, "Test Case Passed.", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.close();	
	}
//	@AfterTest
//	public void CloseDriver() {
//		
//	}
	
}