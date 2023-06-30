import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public ArrayList<String> getData(String testcasename) throws IOException {
	//Step 1 - Get hold of excel file by creating object of XSSFWorkbook class	
	//XSSFWorkbook accepts FIleInputStream as argument
	ArrayList<String> a = new ArrayList<String>();
	FileInputStream excel = new FileInputStream("C://Misc//Desktop//Selenium//Book1.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excel);
	int sheetNumber=workbook.getNumberOfSheets();
	for(int i=0;i<sheetNumber; i++) {
	if(workbook.getSheetName(i).contains("Selenium")) {	
		XSSFSheet sheet = workbook.getSheetAt(i);
		Iterator<Row> rows = sheet.iterator();
		Row firstRow=rows.next();
		Iterator<Cell> cells = firstRow.cellIterator();
		int k=0;
		int column = 0;
		while(cells.hasNext()) {
			if(cells.next().getStringCellValue().equalsIgnoreCase("Testcase")) {
			//desired cell
				column=k;	
		  }k++;
		}System.out.println(column);
		while(rows.hasNext()){
			Row r = rows.next();
			if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
			Iterator<Cell> ce =r.cellIterator();
			while(ce.hasNext()) {
				Cell cellvalue = ce.next();			
				if (cellvalue.getCellTypeEnum()==CellType.STRING) {
				
				a.add(cellvalue.getStringCellValue());
				}else {
				  a.add(NumberToTextConverter.toText(cellvalue.getNumericCellValue()));		
				}
			}
			}
		}
	}
}return a;
}
}
	//Step-2 Identify Testcase column by scanning through entire first row.
	//Once column is identified scan entire Testcase column and identify "Purchase"-row.
	//Then pull all the data and provide to the testcase.
	
	//XSSFSheet sheet = workbook.getSheet("Selenium");

	


