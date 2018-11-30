package com.travels.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.travels.qa.utility.Testutility;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setUp()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/PHP_Travels_Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("Host Name", "Aditya");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Aditya Bhatt");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("PHP Travels Report");
        htmlReporter.config().setReportName("PHP Travels Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }

	public TestBase() {

		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\10263638\\eclipse-workspace\\PHP_Travels\\src\\main\\java\\com\\travels\\qa\\config\\config.properties");
			properties.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\1 D Drive\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutility.PAGE_LOADING_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutility.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("URL"));
	}
	
	

}
