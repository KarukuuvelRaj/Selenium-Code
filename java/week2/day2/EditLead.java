package week2.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class EditLead {
	public static void main(String[] args) {
		String newComp="HCL";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']")).sendKeys("Raj");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
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
		driver.close();
	}
}