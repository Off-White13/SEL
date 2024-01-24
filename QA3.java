package JAVAHW;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QA3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	        String browser = args[0].toLowerCase();

	        // Set the path to the corresponding driver executable
	        String driverPath;

	        // Create a WebDriver instance based on the chosen browser
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
	            case "edge":
	            	driverPath = "path/to/geckodriver"; // Replace with the actual path
	                System.setProperty("webdriver.gecko.driver", driverPath);
	                driver = new EdgeDriver();
	                break;
	            default:
	                System.out.println("Unsupported browser: " + browser);
	                return;
	        }

	       
	        driver.get("https://flipkart.com");
	        List<WebElement> links= driver.findElements(By.tagName("a"));
	        System.out.println("Number of links on the website: " + links.size());
	         
	        for(WebElement link: links)
	        {
	        	String linkText= link.getText();
	        	String linkUrl= link.getAttribute("href");
	        	
	        	System.out.println("Link text :" + linkText);
	        	System.out.println("url :" + linkUrl);
	        	
	        }


	        
	        
	}

}
