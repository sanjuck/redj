package com.redjframeworksample.test.web.excel;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.redjframework.http.HTTPServletRequestWrapper;
import com.redjframework.xos.Viewer;

public class ExcelViewer implements Viewer<List<Object>> {

	List<String> headers = null;

	List<List<Object>> datas = null;

	@Override
	public void doDisplay(HTTPServletRequestWrapper arg0,
			HttpServletResponse response) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sheet name");

//		HSSFSheet sheet = workbook.createSheet();
//		workbook.setSheetName( 0 , "한글" , HSSFWorkbook.ENCODING_UTF_16 );

		HSSFCellStyle s = workbook.createCellStyle();
		s.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		s.setBottomBorderColor(HSSFColor.BLACK.index);
		s.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		s.setLeftBorderColor(HSSFColor.GREEN.index);
		s.setBorderRight(HSSFCellStyle.BORDER_THIN);
		s.setRightBorderColor(HSSFColor.BLUE.index);
		s.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		s.setTopBorderColor(HSSFColor.BLACK.index);

		int i = 0;
		if(headers != null){
			HSSFRow r = sheet.createRow(i++);

			int j = 0;
			for(String header: headers){
				HSSFCell c = r.createCell(j++);
				c.setCellStyle(s);
				c.setCellValue(header);
			}
		}

		if(datas != null){
			for(List<Object> row: datas){
				HSSFRow r = sheet.createRow(i++);
				int j = 0;
				for(Object data: row){
					HSSFCell c = r.createCell(j++);
					c.setCellStyle(s);
					c.setCellValue(data.toString());
				}
			}
		}

		response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
		response.setHeader("Content-Description", "JSP Generated Data");
		response.setContentType("application/vnd.ms-excel");
		workbook.write(response.getOutputStream());
	}

	@Override
	public void reset() {
	}

}
