package com.moa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil extends Initiate{
	//***************************************************************
	//Reading starts here
	//***************************************************************
	private void CaptureFileToRead(String filePath) {
		try {
			fileInputStream = new FileInputStream(filePath);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//#Note: CaptureFileToRead method is required to call before calling below method 
	public void CaptureExcelFileToRead(String filePath) {
		try {
			this.CaptureFileToRead(filePath);
			workbook = WorkbookFactory.create(fileInputStream);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public Sheet CaptureExcelSheetToRead(String sheetName) {
		Sheet sheet = null;
		try {
			//this.CaptureExcelFileToRead(filePath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return sheet;
	}
	public Cell CaptureExcelCellToRead(String sheetName,int row, int col) {
		Cell cell = null;
		try {
			Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			cell = sheet.getRow(row).getCell(col);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cell;
	}
	public Cell CaptureExcelCellToRead(Sheet sheet,int row, int col) {
		Cell cell = null;
		try {
			//Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			cell = sheet.getRow(row).getCell(col);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cell;
	}
	public String CaptureExcelCellValueToRead(String sheetName,int row, int col) {
		String value = null;
		try {
			Cell cell = this.CaptureExcelCellToRead(sheetName, row, col);
			value = this.CaptureExcelCellValueToRead(cell);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	public String CaptureExcelCellValueToRead(Sheet sheet,int row, int col) {
		String value = null;
		try {
			Cell cell = this.CaptureExcelCellToRead(sheet, row, col);
			value = this.CaptureExcelCellValueToRead(cell);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	private String CaptureExcelCellValueToRead(Cell cell) {
		String value = null;
		try {
			CellType cellType = cell.getCellType();
			switch(cellType) {
			case FORMULA: 
				value = this.getNumericValue(cell); 
				break;
			case STRING: 
				value =  cell.getStringCellValue();
				break;
			case NUMERIC:
				value = this.getNumericValue(cell);
				break;
			//Boolean to be implemented
			default:
				value = null;
				break;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return value;
	}
	private String getNumericValue(Cell cell) {
		String value = null;
		Date date = null;
		try {
			if (DateUtil.isCellDateFormatted(cell)) {
				date = cell.getDateCellValue();
				value = new SimpleDateFormat("MM/dd/yyyy").format(date);
			} else {
				int intValue = (int) Math.round(cell.getNumericCellValue());
				double doubleValue = cell.getNumericCellValue();
				if((intValue - doubleValue) == 0.0) {
					value = Integer.toString(intValue);
				}else {
					value = new BigDecimal(Double.toString(cell.getNumericCellValue())).toPlainString();
				}

			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
	public String[][] CaptureExcelRowValueToRead(String sheetName,int row, int beginCol, int endCol) {
		String[][] value = new String[1][endCol - beginCol + 1];
		Cell cellLoc;
		Row rowLoc;
		try {
			Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			rowLoc = sheet.getRow(row);
			for(int colIndex = 0; colIndex <= endCol - 1 ; colIndex++) {
				cellLoc = rowLoc.getCell(beginCol + colIndex);
				value[0][colIndex] = this.CaptureExcelCellValueToRead(cellLoc);
				//System.out.println("value[0][" +colIndex  + "]" + value[0][colIndex]);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
	public String[][] CaptureExcelRowValueToRead(Sheet sheet, int row, int beginCol, int endCol) {
		String[][] value = new String[1][endCol - beginCol + 1];
		Cell cellLoc;
		Row rowLoc;
		try {
			//Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			rowLoc = sheet.getRow(row);
			for(int colIndex = 0; colIndex <= endCol - 1 ; colIndex++) {
				cellLoc = rowLoc.getCell(beginCol + colIndex);
				value[0][colIndex] = this.CaptureExcelCellValueToRead(cellLoc);
				//System.out.println("value[0][" +colIndex  + "]" + value[0][colIndex]);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
	public String[][] CaptureExcelRangeValueToRead(String sheetName,int beginRow, int beginCol, int endRow, int endCol) {
		String[][] value = new String[endRow - beginRow + 1][endCol - beginCol + 1];
		Cell cellLoc;
		Row rowLoc;
		//excelUtil.CaptureExcelRangeValueToRead(sheetName, 3, 1, 5, 4);
		try {
			Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			for(int rowIndex = 0; rowIndex <= endRow - beginRow; rowIndex++) {
				rowLoc = sheet.getRow(beginRow + rowIndex);
				for(int colIndex = 0; colIndex <= endCol - beginCol ; colIndex++) {
					cellLoc = rowLoc.getCell(beginCol + colIndex);
					value[rowIndex][colIndex] = this.CaptureExcelCellValueToRead(cellLoc);
					//System.out.println("value[" + rowIndex + "][" +colIndex  + "]" + value[rowIndex][colIndex]);
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
	//***************************************************************
	//Reading ends here
	//Writing starts here
	//***************************************************************
	public void writeExcel(String filePath, String sheetName, int rowNum, int cellNum, String value){
		try {
			Sheet sheet = this.CaptureExcelSheetToRead(sheetName);
			Row row = sheet.createRow(rowNum);
			 Cell cell = row.createCell(cellNum);
			 //cell.setCellType(CellType.STRING);
			 cell.setCellValue(value);
			 FileOutputStream fos = new FileOutputStream(filePath);
			 workbook.write(fos);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		ExcelUtil excelUtil = new ExcelUtil();
//		excelUtil.writeExcel();
	}
}

