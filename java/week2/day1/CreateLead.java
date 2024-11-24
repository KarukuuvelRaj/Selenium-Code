package week2.day1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateLead {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Raj");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		WebElement dropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sel = new Select(dropDown);
		sel.selectByValue("LEAD_CONFERENCE");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ravi");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation Test Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("rajaut@gmail.com");
		WebElement dropDown2 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel1 = new Select(dropDown2);
		List<WebElement> options = sel1.getOptions();
		System.out.println("Size is: "+options.size());
		sel1.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println("The title of the page is: "+title);
		if(title.contains("View ")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead not created");
		}
		driver.close();
	}
}