package JAVAHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class QA4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 if (args.length == 0) {
	            System.out.println("Please provide the browser as a command line argument.");
	            return;
	        }

	       
	        String browser = args[0].toLowerCase();

	       
	        String driverPath;

	        
	        WebDriver driver;

	        switch (browser) {
	            case "chrome":
	                driverPath = "path/to/chromedriver"; // Replace with the actual path
	                System.setProperty("webdriver.chrome.driver", driverPath);
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                driverPath = "path/to/geckodriver"; // Replace with the actual path
	                System.setProperty("webdriver.gecko.driver", driverPath);
	                driver = new FirefoxDriver();
	                break;
	            default:
	                System.out.println("Unsupported browser: " + browser);
	                return;
	                
	                driver.get("https://www.ebay.com/");
	                WebElement search=driver.findElement(By.linkText("Search"));
	                search.sendKeys("Apple Watches");
	                WebElement category= driver.findElement(By.name("Categories"));
	                Select elec= new Select(driver.findElement(By.linkText("Electronics")));
	                
	                search.click();
	                
	        }
	}

}
