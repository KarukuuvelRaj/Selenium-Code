package week5.day1_day2;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class CreateLead extends BaseClass {
	@Test(dataProvider = "createLead")
	public void createLead(String compName, String fName, String lName) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider(name="createLead")
	public String[][] data() {
		String[][] fetchData=new String[2][3];
		fetchData[0][0]="HCL";
		fetchData[0][1]="Karukuuvel";
		fetchData[0][2]="Raj";

		fetchData[1][0]="Google";
		fetchData[1][1]="Karkuvel";
		fetchData[1][2]="Raj";
		return fetchData;
	}
}





