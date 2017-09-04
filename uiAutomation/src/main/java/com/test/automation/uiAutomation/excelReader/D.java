package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class D {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public D(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path); // creates FileInputStream by
												// opening file connections
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("null")
	public String[][] getDataFromSheet(String sheetname, String excelname) {

		String[][] dataset = null;

		// get sheet from Excel file. This variable stores the sheet name in xml
		// format for internal purpose
		sheet = workbook.getSheet(sheetname);
		System.out.println("sheet " + sheet);
		// count the total active rows
		System.out.println("total rows without adding 1 is "
				+ sheet.getLastRowNum());
		int totalrow = sheet.getLastRowNum() + 1;
		// count the total active columns
		int totalcol = sheet.getRow(0).getLastCellNum();
		dataset = new String[totalrow - 1][totalcol];
		System.out.println(dataset);
		// Get the value of each cell by browsing through each row
		for (int i = 1; i < totalrow; i++) {
			// This row variable will point itself to the specified row location
			row = sheet.getRow(i);
			// On each row, browse through columns
			for (int j = 0; j < totalcol; j++) {
				// This column variable will point itself to the specified
				// column location
				cell = sheet.getRow(i).getCell(j);
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					dataset[i - 1][j] = cell.getStringCellValue();
				}
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					// here need to select valueOf function of int type
					dataset[i - 1][j] = String.valueOf(cell
							.getNumericCellValue());
				}
				if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					dataset[i - 1][j] = String.valueOf(cell
							.getBooleanCellValue());
				}

			}
		}
		return dataset;
	}

	public String getCellData(String sheetname, String columnname, int rownum) {
		try {
			int col_num = 0;
			int index = workbook.getSheetIndex(sheetname);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(columnname)) {
					col_num = i;
					break;
				}
			}
			row = sheet.getRow(rownum - 1);
			cell = row.getCell(col_num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				// here need to select valueOf function of int type
				return String.valueOf(cell.getNumericCellValue());
			}
			if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d = new D("C:\\Users\\umesh_deshmukh\\Desktop\\book1.xlsx");
		d.getDataFromSheet("sheet1", "book1.xlsx");
		String s[][] = d.getDataFromSheet("sheet1", "book1.xlsx");
		System.out.println(s[0][0]);
		System.out.println(s[0][1]);
		System.out.println(d.getCellData("sheet1", "head2", 1));
	}

}

// alternate code
/*
 * String value=""; if(cell!=null) { switch(cell.getCellType()){ case
 * Cell.CELL_TYPE_BOOLEAN:
 * dataset[i-1][j]=String.valueOf(cell.getBooleanCellValue()); break; case
 * Cell.CELL_TYPE_NUMERIC: dataset[i-1][j]=BigDecimal.valueOf(
 * cell.getNumericCellValue()).toPlainString();
 * System.out.println(dataset[i-1][j]); break; case Cell.CELL_TYPE_STRING:
 * dataset[i-1][j]=String.valueOf(cell.getStringCellValue()); break; case
 * Cell.CELL_TYPE_FORMULA:
 * dataset[i-1][j]=String.valueOf(cell.getCellFormula()); break; case
 * Cell.CELL_TYPE_BLANK: dataset[i-1][j]=""; break; } } else {
 * System.out.println("Cell is null"); }
 */