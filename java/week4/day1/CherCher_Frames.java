package week4.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CherCher_Frames {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("ABC");
		//driver.switchTo().defaultContent();
		WebElement frame = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select obj = new Select(dropDown);
		obj.selectByVisibleText("Big Baby Cat");
		Thread.sleep(3000);
		driver.close();
	}
}