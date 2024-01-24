package JAVAHW;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class QA2 {static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "X:\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("http://www.fb.com");
	
	
	
		String url= driver.getCurrentUrl();
		Assert.assertEquals("Pass",url, "http://www.facebook.com");
    
		WebElement acc=driver.findElement(By.linkText("Create an account"));
		Assert.assertEquals(acc.isDisplayed(), true, "Create an Account");

		WebElement fname=driver.findElement(By.name("FirstName"));
		fname.sendKeys("kartik");
		
		WebElement sname=driver.findElement(By.name("SurName"));
		sname.sendKeys("shashni");
		
		WebElement eid=driver.findElement(By.linkText("Mobile Number or email address"));
		eid.sendKeys("1236712318");
		WebElement rid=driver.findElement(By.partialLinkText("Re-enter mobile number"));
		rid.sendKeys("1236712318");
		WebElement pass=driver.findElement(By.name("New password"));
		pass.sendKeys("ajf");
		WebElement bday= driver.findElement(By.xpath("//select[@name='date of birth']"));
	    Select day= new Select(driver.findElement(By.id("day")));
	    Select month= new Select(driver.findElement(By.id("month")));
	    Select year= new Select(driver.findElement(By.id("year")));
	    String updateday="13";
	    String updatemonth="09";
	    String updateyear="1997";
	    
	    day.selectByVisibleText(updateday);
	    month.selectByVisibleText(updatemonth);
	    year.selectByVisibleText(updateyear);
	    
	    WebElement gen= driver.findElement(By.id("Male"));
	    gen.click();
	    driver.findElement(By.linkText("Create an account")).click();
	    
	    WebElement succ= driver.findElement(By.id("Account created successfully"));
	    
	   Assert.assertEquals("Account created successfully", succ.isDisplayed());

	
	}
}


