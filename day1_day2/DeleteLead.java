package week5.day1_day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class DeleteLead extends BaseClass {
@Test(enabled = false)
	public void deleteLead() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(7000);
		WebElement findId = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		String leadId = findId.getText();
		System.out.println("The captured Lead ID is: "+leadId);
		driver.executeScript("arguments[0].click()", findId);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(7000);
		boolean message = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		System.out.println("Does No records to display message dislayed: "+message);
	}
}