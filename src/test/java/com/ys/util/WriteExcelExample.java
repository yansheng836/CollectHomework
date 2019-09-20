package com.ys.util;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 主要是为了测试在“写入数据到excel文件中”时如何捕获异常。
 * 
 * @author yansheng
 * @date 2019/06/22
 */
public class WriteExcelExample {

    public static void main(String[] args) {

        String excelPath = "写文件到16计算机科学与技术3学生名单.xls";
        WritableWorkbook workbook = null;

        try {
            workbook = Workbook.createWorkbook(new File(excelPath));

            WritableSheet sheet = workbook.createSheet("the first sheet", 0);
            Label lable = new Label(1, 1, "这是第一行的第一个单元格");
            sheet.addCell(lable);

            workbook.write();
            // 如果上面的语句都没有发生异常，
            System.out.println("----写数据到(" + excelPath + ")成功。----\n");

        } catch (NullPointerException e) {
            System.out.println("NullPointerException:File路径名为空。");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException:创建工作表时发生异常。");
            e.printStackTrace();
        } catch (RowsExceededException e1) {
            System.out.println("RowsExceededException:添加单元格到工作表时，当写入的函数超过最大值时(10000以内不会)抛出异常。");
            e1.printStackTrace();
        } catch (WriteException e1) {
            System.out.println("WriteException:添加单元格到工作表时，可能发生的异常。");
            e1.printStackTrace();
        } finally {
            ExcelUtil.closeWorkbook(workbook);
        }

    }

}
