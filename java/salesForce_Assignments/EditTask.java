package salesForce_Assignments;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class EditTask {

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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
		driver.executeScript("arguments[0].click()", task);
		WebElement tab = driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']"));
		driver.executeScript("arguments[0].click()", tab);
		driver.findElement(By.xpath("(//span[@class='slds-truncate'])[18]")).click();
		driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
		driver.findElement(By.xpath("//li[@class='slds-dropdown__item has-icon--left   highlighted slds-is-selected forceVirtualAutocompleteMenuOption']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		WebElement edit = driver.findElement(By.xpath("//div[text()='Edit']"));
		driver.executeScript("arguments[0].click()", edit);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(dateFormat.format(date));
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		WebElement save = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click()", save);
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		if(text.contains("saved.")) {
			System.out.println("Task edited successfully");
		}else {
			System.out.println("Task was not edited");
		}
		driver.close();
	}
}