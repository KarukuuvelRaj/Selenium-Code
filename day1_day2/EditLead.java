package week5.day1_day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class EditLead extends BaseClass {
	@Test(dependsOnMethods = "week5.day1.CreateLead.createLead")
	public void editLead() throws InterruptedException {
		String newComp="HCL";
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']")).sendKeys("test");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("Expected page title is displaying");
		}else {
			System.out.println("Expected page title is not displaying");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement updateCompName = driver.findElement(By.id("updateLeadForm_companyName"));
		updateCompName.clear();
		updateCompName.sendKeys(newComp);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement newCompName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		//newCompName.getAttribute("value");
		if(newCompName.getText().contains(newComp)) {
			System.out.println("Updated company name is displaying");
		}else{
			System.out.println("Updated company name is not displaying");
		}
	}
}