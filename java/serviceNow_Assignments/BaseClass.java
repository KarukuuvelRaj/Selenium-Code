package serviceNow_Assignments;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
public class BaseClass {
	public ChromeDriver driver;
	public Shadow dom;
	@BeforeMethod
	public void preCondition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://dev56587.service-now.com");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Testleaf@93");
		driver.findElement(By.id("sysverb_login")).click();
		dom=new Shadow(driver); 
		Thread.sleep(20000);
		WebElement All = dom.findElementByXPath("//div[@id='all']");
		All.click();
	}
	@AfterMethod
	public void postCondition(){
		driver.close();
	}
}
