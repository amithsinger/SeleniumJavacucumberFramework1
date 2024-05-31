package genrics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel file reader and writer.
 */
public class Excel {

	public static String getdata(String path, String sheet, int row, int cell) {
		String v;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void ExcelWriter(String path, String sheet_name, int rownum, int cellnum, String data) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheet_name);
			if (sheet == null) {
				sheet = workbook.createSheet(sheet_name);
			}
			Row row = sheet.getRow(rownum);
			if (row == null) {
				row = sheet.createRow(rownum);
			}
			Cell cell = row.getCell(cellnum);
			if (cell == null) {
				cell = row.createCell(cellnum);
			}
			cell.setCellValue(data);

			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
			workbook.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
