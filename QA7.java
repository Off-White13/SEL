package JAVAHW;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class QA7 {

	public static void main(String[] args) { static WebDriver driver;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "X:\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("https://www.gmail.com");
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("kartik.shashni@gmail.com");
		driver.findElement(By.id("name")).click();
		WebElement pass=driver.findElement(By.linkText("password"));
		pass.sendKeys("123134");
		driver.findElement(By.linkText("Sign-in")).click();
	    WebElement succ= driver.findElement(By.id("Account created successfully"));
	    
		Assert.assertEquals("Account created successfully", succ.isDisplayed());
		
		driver.findElement(By.id("Compose")).click();
		String composeid=driver.getWindowHandle();
		
		Set<String> allWin = driver.getWindowHandles();
		int cnt= allWin.size();
		System.out.println("count of windows:" + cnt);
		
		for(String w:allWin) 
		{
			if(w.matches(composeid))
				{
				driver.switchTo().window(w);
				System.out.println("mail window:" + driver.getCurrentUrl());
				}
			else
			{
				driver.switchTo().window(w);
				System.out.println("main window:" + driver.getTitle());
			}
		WebElement sid=driver.findElement(By.id("email"));
		sid.sendKeys("qatesting@vitsconsulting.com");
		WebElement sub=driver.findElement(By.name("subject"));
		sub.sendKeys("QA Atuomation Test Mail");
		WebElement body=driver.findElement(By.linkText("Body"));
		body.sendKeys("automation");
		
		driver.findElement(By.id("Send")).click();
			
		
		}
		
	}

}