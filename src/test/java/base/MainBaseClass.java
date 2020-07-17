package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExtentManager;



public class MainBaseClass {
	
	final static Logger logger = Logger.getLogger(MainBaseClass.class);
	public static WebDriver driver;
	public static Properties configProp;
	public static Properties orProp;
	public FileInputStream fis;
	
	public ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	
	@BeforeSuite
	public void extentReportSetup() {
		extentReport = ExtentManager.getInstance();		
	}
	
	
	@BeforeSuite
	public void propFileSetup() {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"or.properties");
			
			configProp = new Properties();
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IOException while config file loading >>" +e.getCause());
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config.properties");
			orProp = new Properties();
			orProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IOException while or file loading >>" +e.getCause());
			e.printStackTrace();
		}
		
	}
	
	
	private static ChromeOptions returnChromeOptions() {
		ChromeOptions choptions = new ChromeOptions();
		choptions.addArguments("start-maximized");
		choptions.addArguments("disable-infobars");
		choptions.addArguments("disable-popup-blocking");
		choptions.addArguments("disable-extensions");
		return choptions;
	}
	
	@Parameters ("BrowserType")
	@BeforeSuite
	public void launchBrowser(String browserType) {

		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();			

			driver = new ChromeDriver(this.returnChromeOptions());			
		} else if(browserType.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();

			Capabilities cap = new DesiredCapabilities();			
			
			driver = new FirefoxDriver(cap);

		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(this.returnChromeOptions());
		}
	}
	
	@AfterSuite(alwaysRun=true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
