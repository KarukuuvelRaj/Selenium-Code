package week4.day1;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AlertAndFrames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Raj");
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(text.contains("Raj")) {
			System.out.println("Name is displayed and program working fine");
		}else System.out.println("Program is not working, check your code");
		driver.switchTo().defaultContent();
		driver.close();
	}
}