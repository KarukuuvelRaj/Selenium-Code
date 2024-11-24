package week5.day1_day2;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook workBook = new XSSFWorkbook("ExcelData's/CreateLead.xlsx");
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		System.out.println("The row count is: "+rowCount);
		short colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("The Coloumn count is: "+colCount);
		for(int i=1; i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);
			}
		}
		workBook.close();
	}
}