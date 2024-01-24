package JAVAHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class QA5 { static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "X:\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("http://www.vitshr.com");
		WebElement register= driver.findElement(By.linkText("Register a company"));
		register.click();
		driver.findElement(By.id("Name")).sendKeys("Zed");
		driver.findElement(By.id("Username")).sendKeys("Z@vits.com");
		driver.findElement(By.linkText("Password")).sendKeys("132");
		driver.findElement(By.linkText("Industry")).sendKeys("Tech");
		driver.findElement(By.id("Register")).click();
		//sign in as a company
		driver.findElement(By.name("Sign-in")).click();
		WebElement uname = driver.findElement(By.id("username"));
        WebElement pass= driver.findElement(By.id("password"));
        WebElement login= driver.findElement(By.id("loginButton"));
        uname.sendKeys("Z@vits.com");
        pass.sendKeys("132");
        login.click();
        
        WebElement adminDashboard = driver.findElement(By.id("adminDashboard"));

        if (adminDashboard.isDisplayed()) {
            System.out.println("Login Successful - Admin Dashboard is displayed!");
        } else {
            System.out.println("Login Failed - Admin Dashboard not displayed!");
        }
	}

}
