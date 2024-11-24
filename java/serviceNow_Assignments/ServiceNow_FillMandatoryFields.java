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
public class ServiceNow_FillMandatoryFields extends BaseClass {
	@Test
	public void fillMandatoryFields() throws InterruptedException {
		Thread.sleep(5000);
		Actions obj = new Actions(driver);
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		obj.click(filter).sendKeys("Knowledge").pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER).perform();
		Thread.sleep(4000);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		Thread.sleep(3000);	
		dom.findElementByXPath("//span[text()='Create an Article']").click();
		Thread.sleep(5000);
		dom.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']").click();
		Set<String> window = driver.getWindowHandles();
		List<String> lis = new ArrayList<String>(window);
		driver.switchTo().window(lis.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(lis.get(0));
		WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		dom.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_category']").click();
		driver.findElement(By.xpath("//div[@class='list-item arrow']/span[text()='IT']")).click();
		driver.findElement(By.xpath("//div[@class='list-item']/span[text()='Java']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		dom.findElementByXPath("//input[@id='kb_knowledge.short_description']").sendKeys("New Article");
		dom.findElementByXPath("//button[text()='Submit']").click();
	}
}