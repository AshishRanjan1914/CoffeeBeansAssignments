package mytests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.MainBaseClass;
import sun.misc.JavaSecurityAccess;

public class ClearTripTest extends MainBaseClass {

	WebDriverWait wait;

	private void JSSetValueElement(WebElement ele, String longstring) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', '" + longstring +"')", ele);
	}

	private void JSClickElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	private String getTodayDate(String args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date();
		if (args.equalsIgnoreCase("add")) {
			long ltime=date.getTime()+10*24*60*60*1000;
			date = new Date(ltime);
		}
		
		return formatter.format(date);
		
	}

	@Test
	public void clearTripTest() {
		driver.get(configProp.getProperty("ClearTrip"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orProp.getProperty("FromTag"))));

		driver.findElement(By.id("RoundTrip")).click();
		JSClickElement(driver.findElement(By.id("RoundTrip")));
		driver.findElement(By.id(orProp.getProperty("FromTag"))).click();
		JSSetValueElement(driver.findElement(By.id("From")), "Del");
		
		driver.findElement(By.id(orProp.getProperty("ToTag"))).click();
		JSSetValueElement(driver.findElement(By.id("To")), "BOM");
		
		driver.findElement(By.id(orProp.getProperty("DepartDate"))).click();
		JSSetValueElement(driver.findElement(By.id("FromDate")), getTodayDate(""));
		
		driver.findElement(By.id(orProp.getProperty("DepartDate"))).click();
		JSSetValueElement(driver.findElement(By.id("FromDate")), getTodayDate(""));
		
		JSClickElement(driver.findElement(By.id("SearchBtn")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Details']")));

	}

}
