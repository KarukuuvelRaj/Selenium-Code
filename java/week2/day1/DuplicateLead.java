package week2.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
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
		WebElement compName = driver.findElement(By.id("createLeadForm_companyName"));
		compName.sendKeys("CTS");
		WebElement firName = driver.findElement(By.id("createLeadForm_firstName"));
		firName.sendKeys("Raj");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Ravi");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation Test Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("rajaut@gmail.com");
		WebElement dropDown2 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel1 = new Select(dropDown2);
		sel1.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		//String title = driver.getTitle();
		System.out.println("The title of the page is: "+driver.getTitle());
		//Thread.sleep(5000);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(5000);
		//WebElement compName = driver.findElement(By.id("createLeadForm_companyName"));
		compName.clear();
		compName.sendKeys("HCL");
		firName.clear();
		firName.sendKeys("Karukkuvel");
		driver.findElement(By.name("submitButton")).click();
		System.out.println("The title of the page is: "+driver.getTitle());
		driver.close();
	}
}