package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExceUtilsTest {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	//	public static void main(String[] args) {
	//		String excelPath = "./data/theTestData.xlsx";
	//		String sheetName = "dataSetOne";
	//		ExcelUtils2 excel = new ExcelUtils2(excelPath, sheetName);
	//		
	//		excel.getData();
	//
	//	}

	@DataProvider
	public Object getData() {
		String excelPath = "./data/theTestData.xlsx";
		String sheetName = "dataSetOne";
		ExcelUtils2 excel = new ExcelUtils2(excelPath, sheetName);
		Object value = excel.getData();
		return value;
	}

	@Test(dataProvider = "getData")
	public void printData(String firstName, String lastName, String placeName, int id, int comments) {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(placeName);
		System.out.println(id);
		System.out.println(comments);
	}
}