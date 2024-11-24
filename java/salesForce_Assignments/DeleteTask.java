package salesForce_Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteTask {

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
		WebElement tab = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']"));
		driver.executeScript("arguments[0].click()", tab);
		driver.findElement(By.xpath("(//span[@class='slds-truncate'])[18]")).click();
		driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
		driver.findElement(By.xpath("//li[@class='slds-dropdown__item has-icon--left   highlighted slds-is-selected forceVirtualAutocompleteMenuOption']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		WebElement del = driver.findElement(By.xpath("//div[text()='Delete']"));
		driver.executeScript("arguments[0].click()", del);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		if(text.contains("deleted.")) {
			System.out.println("Task deleted successfully");
		}else {
			System.out.println("Task was not deleted");
		}
		driver.close();
	}

}
