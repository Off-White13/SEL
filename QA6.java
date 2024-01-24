package JAVAHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class QA6 {static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "X:\\edgedriver_win64\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("http://jqueryui.com/droppable/webpage");
	
 Actions action= new Actions(driver);
	WebElement frameEle= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	//
	driver.switchTo().frame(frameEle);
	 
	WebElement ele1= driver.findElement(By.id("draggable"));
	WebElement ele2= driver.findElement(By.id("droppable"));
	//no need to use build method since we are only using one element.
    action.dragAndDropBy(ele1, 44,66).perform();
	 
    if(ele2.getText().matches("Dropped!"))
	 {
		 System.out.println("Success");
	 }
    else
	{
		 System.out.println("failure");
   }
 
}
}

	

