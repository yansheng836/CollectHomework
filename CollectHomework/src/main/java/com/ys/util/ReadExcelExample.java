/**  
 * @Title TestReadExcel.java
 * @Package com.ys.util
 * @Description TODO
 * @author yansheng
 * @date 2019-06-22 01:00:45
 * @version v1.0
 */
package com.ys.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * <p>Title: </p>
 * <p>Description:主要是为了测试在“读取excel文件中的数据”时如何捕获异常。 </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-22 01:00:45
 * @version v1.0 
 */
public class ReadExcelExample {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-22 01:00:45
	 * @Description 主要是为了测试在“读取excel文件中的数据”时如何捕获异常。
	 * @param args   
	 */
	public static void main(String[] args) {

		String excelPath = "16计算机科学与技术3学生名单.xls";
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(excelPath));

			Sheet sheet = workbook.getSheet(0);
//			System.out.println(sheet);

			Cell cell = sheet.getCell(7, 5);
			System.out.println("第一个单元格的内容是："+cell.getContents());

			// 如果上面的语句都没有发生异常，
			System.out.println("----读Excel成功。----\n");

		} catch (NullPointerException e) {
			System.out.println("NullPointerException:File路径名为空。");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException:系统找不到File指定的文件。");
			e.printStackTrace();
		} catch (BiffException | IOException e) {
			// BiffException:Exception thrown when reading a biff file
			// biff:Binary Interchange File Format(二进制文件交换格式)
			System.out.println("BiffException | IOException：Excel表格的格式不是xls。");
			e.printStackTrace();
		} catch (IndexOutOfBoundsException  e) {
			System.out.println("IndexOutOfBoundsException：读取的工作表数量、单元格的行数或者越界。");
			e.printStackTrace();
		} finally {
			// 如果资源没有gc被回收，手动关闭资源。
			if (workbook != null) {
				try {
					workbook.close();
				} catch (Exception e) {
					System.out.println("Exception：关闭workbook时发生异常。");
					e.printStackTrace();
				}
			}
		}
	}

}
