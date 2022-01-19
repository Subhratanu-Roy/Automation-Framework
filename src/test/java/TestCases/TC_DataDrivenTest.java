package TestCases;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class TC_DataDrivenTest extends Base {

	@Test(dataProvider = "getData")
	public void ddLogin(String userName, String password) throws InterruptedException, IOException

	{

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.getUserName().sendKeys(userName);
		lpo.getPassword().sendKeys(password);
		lpo.loginMethod().click();
		Thread.sleep(3000);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			getScreenshot(driver, "ddLogin");
			Assert.assertTrue(false);
		}

		else {
			lpo.logout().click();

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\LoginData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sh = wb.getNumberOfSheets();

		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = 0;
		int colCount = 0;
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			rowCount++;
			rows.next();
		}
		Iterator<Row> rows1 = sheet.iterator();
		Row first = rows1.next();
		Iterator<Cell> cell = first.cellIterator();

		while (cell.hasNext()) {
			colCount++;
			cell.next();

		}

		int m = rowCount;
		int n = colCount;

		Iterator<Row> rows2 = sheet.iterator();
		rows2.next();
		Object[][] data = new Object[rowCount - 1][colCount];
		for (int i = 0; i < m - 1; i++) {
			Row r2 = rows2.next();
			for (int j = 0; j < n; j++) {
				if (r2.getCell(j).getCellTypeEnum() == CellType.STRING) {
					data[i][j] = r2.getCell(j).getStringCellValue();
				} else {
					double num = r2.getCell(j).getNumericCellValue();
					String val = NumberToTextConverter.toText(num);
					data[i][j] = val;

				}
			}
		}

		return data;

	}
}
