package com.ys.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 主要是为了测试在“读取excel文件中的数据”时如何捕获异常。
 * 
 * @author yansheng
 * @date 2019/06/22
 */
public class ReadExcelExample {

    public static void main(String[] args) {

        String excelPath = "16计算机科学与技术3学生名单.xls";
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(excelPath));

            Sheet sheet = workbook.getSheet(0);

            Cell cell = sheet.getCell(7, 5);
            System.out.println("第一个单元格的内容是：" + cell.getContents());

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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException：读取的工作表数量、单元格的行数或者越界。");
            e.printStackTrace();
        } finally {
            ExcelUtil.closeWorkbook(workbook);
        }
    }

}
