package JAVAHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class QA1 { WebDriver driver;

	public void launch() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "X:\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://vitshr.com/");
		
	}
	public void Title() {
		String title= driver.getTitle();
		Assert.assertEquals("Pass",title, "VITS HR");
		
		
		driver.get("https://www.facebook.com/");
		driver.navigate().back();
		System.out.println("Current url:" + driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.quit();
	}
    
}
