package week2.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Facebook {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[text()='Forgotten password?']/following::a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Karukkuvel");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Raj");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567891");
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select sel = new Select(date);
		sel.selectByVisibleText("3");
		WebElement month = driver.findElement(By.id("month"));
		Select sel1=new Select(month);
		sel1.selectByValue("3");
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select sel2 = new Select(year);
		sel2.selectByValue("1995");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
	}
}