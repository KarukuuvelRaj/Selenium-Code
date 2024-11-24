package serviceNow_Assignments;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class ServiceNow_CreateNewCaller extends BaseClass {
	@Test
	public void newCaller() throws InterruptedException {
		Thread.sleep(5000);
		Actions obj = new Actions(driver);
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		obj.click(filter).sendKeys("Callers").pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).perform();
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String fName = "New";
		dom.setImplicitWait(5);
		dom.findElementByXPath("//input[@id='sys_user.first_name']").sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Last");
		driver.findElement(By.xpath("//a[@id='lookup.sys_user.title']")).click();
		Set<String> winHan = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(winHan);
		driver.switchTo().window(win.get(1));
		driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[5]//a")).click();
		driver.switchTo().window(win.get(0));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		dom.findElementByXPath("//input[@placeholder='Search']").sendKeys(fName, Keys.ENTER);
		String text = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[4]")).getText();
		if(text.equals(fName)) {
			System.out.println("Caller is created successfully");
		}else {
			System.out.println("Caller is not created");
		}
	}
}