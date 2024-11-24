package week4.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LeafGound_WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click and Confirm new Window Opens
		String title1 = driver.getTitle();
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> obj = new ArrayList<String>(windowHandles);
		driver.switchTo().window(obj.get(1));
		String title2 = driver.getTitle();
		if(title1!=title2) {
			System.out.println("New window opens");
		}else {
			System.out.println("New window didn't open");
		}
		driver.close();
		driver.switchTo().window(obj.get(0));
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> obj1=new ArrayList<String>(windowHandles2);
		System.out.println("The number of opened tabs are: "+obj1.size());
		driver.switchTo().window(obj1.get(0));
		//Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> obj2 = new ArrayList<String>(windowHandles3);
		int size2 = obj2.size();
		for(int i = size2-1; i>0; i--) {
			driver.switchTo().window(obj2.get(i));
			driver.close();
		}
		driver.switchTo().window(obj2.get(0));
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		int size = windowHandles4.size();
		if(size==3) {
			System.out.println("2 new tabs opened");
		}else {
			System.out.println("2 new tabs didn't open");
		}
		driver.quit();
	}
}