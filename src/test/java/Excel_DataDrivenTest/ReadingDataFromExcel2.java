package Excel_DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingDataFromExcel2 {

	@Test
	public void test_read_data() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\testNG_framework\\testdata\\data2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row_count=sheet.getLastRowNum();
		
		int col_count=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total number of rows:"+row_count);
		System.out.println("Total number of cols:"+col_count);
		
		for (int i=0;i<row_count;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			
			for (int j=0;j<col_count;j++)
			{
				String value=currentrow.getCell(j).toString();
				System.out.print("   "+value);
			}
			System.out.println();
		}
		
		
		                      
		
	}
}
