package StepDefPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Logincode{ WebDriver driver;
	@Given("Read 5 employees from csv file and register")
	
		public void readEmployees(){
		try {
		FileInputStream fis= new FileInputStream("src\\JAVAHW\\Employees.csv");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheetAt(0);
		
		for(int r=1; r<sh.getLastRowNum(); r++)
		{
			Row row= sh.getRow(r);
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			WebElement unmCompany= driver.findElement(By.id("Enter Username"));
			unmCompany.sendKeys(username);
			WebElement pasCompany= driver.findElement(By.id("Enter Password"));
			pasCompany.sendKeys(password);
			driver.findElement(By.linkText("Register")).click();
		}
		
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Employees read from the csv file");
	}
	
	@And("Login to each employee")
	public void LogEmployee(){
		driver.get("http://www.vitshr.com");
		Scanner scanner = new Scanner(System.in);
		try {
			FileInputStream fis= new FileInputStream("src\\JAVAHW\\Employees.csv");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh= wb.getSheetAt(1);
			for(int r=1; r<sh.getLastRowNum(); r++)
			{
				Row row= sh.getRow(r);
				String username = row.getCell(0).getStringCellValue();
				String password = row.getCell(1).getStringCellValue();
				 // Prompt the user for login credentials
                System.out.println("Enter your credentials for User " + (r + 1));
                System.out.print("Username: ");
                String enteredUsername = scanner.nextLine();
                System.out.print("Password: ");
                String enteredPassword = scanner.nextLine();
             // Perform login validation
                if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
                    System.out.println("Login successful for User " + (r + 1));
                } else {
                    System.out.println("Login failed for User " + (r + 1) + ". Invalid credentials.");
                }
            }

			
			}catch (IOException e)
			{
				e.printStackTrace();
		

	}
	
	}
	@When("40 hours are entered in the timesheet for one employee")
    public void enterHoursInTimesheet(){
    		Scanner scanner = new Scanner(System.in);
    		try {
    			FileInputStream fis= new FileInputStream("src\\JAVAHW\\Employees.csv");
    			XSSFWorkbook wb = new XSSFWorkbook(fis);
    			XSSFSheet sh= wb.getSheetAt(2);
    			double[][] timesheet= new double[5][5];
    			
    			for(int r=1; r<sh.getLastRowNum(); r++)
    			{
    				System.out.println("Enter hours worked for Employee " + (r + 1) + " for each day");
    				for (int c = 1; c < sh.getRow(0).getLastCellNum(); c++) {
    	                System.out.print("Enter hours for day " + (c + 1) + ": ");
    	                timesheet[r][c] = scanner.nextDouble();
    				}
    	                // Calculate total hours for the week
        		        double totalHours = 0;
        		        for (int c = 1; c < sh.getRow(0).getLastCellNum(); c++) {
        		                totalHours += timesheet[r][c];
        		            }

        		            System.out.println("Total\t" + totalHours + " hours");
        		        }

        		       
        		        scanner.close();
        		    
    			}catch (IOException e)
			{
				e.printStackTrace();
			}
		

	}
	
    		
    		@Then(" Timesheet is updated succesfully")
    		public void Timesheet() {
    			System.out.println("TImesheet has been updated");
    		}
	}
	

    		       

    		       

    		    

    		          
    		        
