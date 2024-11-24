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
public class ServiceNow_CreateNewProposal extends BaseClass {
	@Test
	public void newProposal() throws InterruptedException {
		Thread.sleep(15000);
		Actions obj = new Actions(driver);
		WebElement filter = dom.findElementByXPath("//input[@id='filter']");
		obj.click(filter).sendKeys("Proposal").pause(Duration.ofSeconds(3)).sendKeys(Keys.ENTER).perform();
		Thread.sleep(15000);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		dom.findElementByXPath("//a[@id='lookup.std_change_proposal.short_description']").click();
		Set<String> noOfWindow = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(noOfWindow);
		driver.switchTo().window(win.get(1));
		WebElement sel = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[3]//a"));
		String text1 = sel.getText();
		sel.click();
		driver.switchTo().window(win.get(0));
		driver.switchTo().frame(frame);
		dom.findElementByXPath("//button[text()='Submit']").click();
		List<WebElement> row = dom.findElementsByXPath("//table[@id='std_change_proposal_table']/tbody/tr");
		int rowCount = row.size();
		String text = dom.findElementByXPath("//table[@id='std_change_proposal_table']/tbody/tr[" + rowCount + "]/td[4]").getText();
		if(text.equals(text1)) { 
			System.out.println("New Proposal is created");
		}else { 
			System.out.println("New Proposal is not created"); 
		}
	}
}