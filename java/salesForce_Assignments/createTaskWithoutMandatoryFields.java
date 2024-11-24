package salesForce_Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createTaskWithoutMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(8000);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
		driver.executeScript("arguments[0].click()", task);
		driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']")).click();
		WebElement newTask = driver.findElement(By.xpath("//div[text()='New Task']"));
		driver.executeScript("arguments[0].click()", newTask);
		WebElement contact = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		WebElement con = driver.findElement(By.xpath("(//input[@title='Search Contacts']//following::li)[3]"));
		Actions obj = new Actions(driver);
		obj.click(contact).moveToElement(con).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='quickTextKeyboardTip']/following::textarea")).sendKeys("SALES FORCE Automation Using Selenium");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		boolean displayed = driver.findElement(By.xpath("//div[@class='slds-form-element__help']")).isDisplayed();
		System.out.println("Error message displayed: "+displayed);
		driver.close();
	}

}
