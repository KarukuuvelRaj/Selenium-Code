package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement fromSta = driver.findElement(By.id("txtStationFrom"));
		fromSta.clear();
		fromSta.sendKeys("MAS");
		Thread.sleep(2000);
		fromSta.sendKeys(Keys.TAB);
		WebElement toSta = driver.findElement(By.id("txtStationTo"));
		toSta.clear();
		toSta.sendKeys("CBE");
		Thread.sleep(2000);
		toSta.sendKeys(Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainCount = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr[contains(@onclick,'TrainsObj.')]"));
		int rowCount = trainCount.size();
		List<String> lis = new ArrayList<String>();
		System.out.println("Below are the train names:");
		for(int i =1; i <= rowCount; i++) {
			String trainNames = driver.findElement(By.xpath("//div[@id='divTrainsList']/table/tbody/tr[contains(@onclick,'TrainsObj.')][" + i + "]/td[2]")).getText();
			System.out.println(trainNames);
			lis.add(trainNames);
		}
		Set<String> one = new HashSet<String>(lis);
		if(one.size() == lis.size()) {		
			System.out.println("No duplicates found");
		}else {
			System.out.println("Duplicates found");
		}
		driver.close();
		}
	}