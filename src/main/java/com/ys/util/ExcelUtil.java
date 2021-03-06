package com.ys.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.ys.bean.Student;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 读写Excel的工具类，提供读写Excel的方法。
 * 
 * @author yansheng
 * @date 2019/06/03
 */
public class ExcelUtil {

    /**
     * 读取excel文件中的数据，保存到ArrayList中。
     * 
     * @param excelPath
     *            需要读取的excel文件路径
     * @return ArrayList<Student>[] 返回学生列表数组
     */
    public static ArrayList<Student>[] readExcel(String excelPath) {

        System.out.println("----读取excel文件(" + excelPath + ")中的信息：");

        // 定义ArrayList，用于存储bean（Student）的集合，设置初始容量为40
        ArrayList<Student> students = new ArrayList<Student>(40);
        ArrayList<Student> specialStudents = new ArrayList<Student>(10);

        // 该数组主要存放一些特殊的标记，如留级、休学等，作用：点名册中的学生如果有这些标记的就不加入现有学生列表中。
        String[] signs = {"留级", "退学", "休学"};
        int signsLength = signs.length;

        // 1. 新建（打开）一个工作簿对象
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(excelPath));
            // 2. 获得第一个工作表对象
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();

            // 假设第一行是标题，第二行是表头，从第三行开始读数据（下标从0开始）
            for (int i = 2; i < rows; i++) {
                // 判空,如果编号不为空则认定该行有数据
                // An empty cell can still contain formatting information and comments
                Cell cellNo = sheet.getCell(0, i);
                if (cellNo.getType() != CellType.EMPTY) {
                    Cell cellSno = sheet.getCell(1, i);
                    Cell cellSname = sheet.getCell(2, i);
                    // 该列(第四列)主要是一些特殊的标记
                    Cell cellSign = sheet.getCell(3, i);

                    String no = cellNo.getContents().trim();
                    String sno = cellSno.getContents().trim();
                    String sname = cellSname.getContents().trim();
                    String sign = cellSign.getContents().trim();

                    Student student = new Student(no, sno, sname);
                    // 如果第4列有特殊标记，则不添加该学生姓名到列表中,否则将该学生添加到列表中
                    for (int j = 0; j < signsLength; j++) {
                        if (signs[j].equalsIgnoreCase(sign)) {
                            System.out.println(student + "的情况特殊，标志sign为：" + sign + ",故不加入学生列表。");
                            // 匹配到一个就跳出循环
                            specialStudents.add(student);
                            break;
                        } else if (j == signsLength - 1) {
                            // 遍历关键字列表都没有匹配到，将该学生添加到列表中
                            students.add(student);
                        }
                    }
                }
            }

            // 如果上面的语句都没有发生异常，
            System.out.println("----读Excel成功。----\n");

        } catch (NullPointerException e) {
            System.err.println("NullPointerException:File路径名为空。");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException:系统找不到File指定的文件。");
            e.printStackTrace();
        } catch (BiffException | IOException e) {
            // BiffException:Exception thrown when reading a biff file
            // biff:Binary Interchange File Format(二进制文件交换格式)
            System.err.println("BiffException | IOException：Excel表格的格式不是xls。");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException：读取的工作表数量、单元格的行数或列数者越界。");
            e.printStackTrace();
        } finally {
            closeWorkbook(workbook);
        }

        // 定义一个学生列表数组，第一个列表包含无特殊情况的学生，第二个列表包含特殊的学生。
        ArrayList<Student>[] studentsArray = new ArrayList[2];
        studentsArray[0] = students;
        studentsArray[1] = specialStudents;

        return studentsArray;
    }

    /**
     * 将学生列表的数据写到Excel的方法。
     * 
     * @param excelPath1    需要读取的Excel表格路径
     * @param students 学生列表
     */
    public static void writeExcel(String excelPath1, ArrayList<Student> students) {
        // 保存数据的excel文件名
        String excelPath = getSaveExcelFileName(excelPath1);

        // 1.1 打开文件
        WritableWorkbook workbook = null;
        try {
            workbook = Workbook.createWorkbook(new File(excelPath));

            // 1.2 生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet = workbook.createSheet("第一页", 0);

            // 设置表头（第一行数据）（列，行）,读字符串用Label对象
            Label labelNo = new Label(0, 0, "序号");
            Label labelSno = new Label(1, 0, "学号");
            Label labelSname = new Label(2, 0, "姓名");
            sheet.addCell(labelNo);
            sheet.addCell(labelSno);
            sheet.addCell(labelSname);
            
            // 从第二行开始写
            int rows = students.size();
            for (int i = 0; i < rows; i++) {
                // 依次取得学生列表中每个学生的信息
                labelNo = new Label(0, i + 1, students.get(i).getNo());
                labelSno = new Label(1, i + 1, students.get(i).getSno());
                labelSname = new Label(2, i + 1, students.get(i).getSname());

                sheet.addCell(labelNo);
                sheet.addCell(labelSno);
                sheet.addCell(labelSname);
            }

            // 将统计人数信息写到表中
            Label labelConuter = new Label(0, rows + 2, "共有学生" + students.size() + "名");
            sheet.addCell(labelConuter);
            workbook.write();
            // 如果上面的语句都没有发生异常，
            System.out.println("\n----写数据到(" + excelPath + ")成功。----\n");
        } catch (NullPointerException e) {
            System.err.println("NullPointerException:File路径名为空。");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IOException:创建工作表时发生异常。");
            e.printStackTrace();
        } catch (RowsExceededException e1) {
            System.err.println("RowsExceededException:添加单元格到工作表时，当写入的函数超过最大值时(10000以内不会)抛出异常。");
            e1.printStackTrace();
        } catch (WriteException e1) {
            System.err.println("WriteException:添加单元格到工作表时，可能发生的异常。");
            e1.printStackTrace();
        } finally {
            closeWorkbook(workbook);
        }
    }

    /**
     * 关闭WritableWorkbook（写Excel的）对象。
     * 
     * @param workbook
     *            WritableWorkbook对象
     */
    public static <T extends WritableWorkbook> void closeWorkbook(T workbook) {
        if (workbook != null) {
            try {
                workbook.close();
            } catch (WriteException e) {
                System.err.println("WriteException：写表格时，发生异常。");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("IOException：写表格后，关闭workbook时发生异常。");
                e.printStackTrace();
            }
        }

    }

    /**
     * 关闭Workbook（读excel的）对象。（重载方法）
     * 
     * @param workbook
     *            Workbook对象
     */
    public static <T extends Workbook> void closeWorkbook(T workbook) {
        if (workbook != null) {
            workbook.close();
        }
    }

    /**
     * 设置需要保持的数据的excel的文件名。
     * 
     * @param excelPath
     *            原Excel数据路径
     * @return String 保存Excel数据的文件名（路径名）
     */
    public static String getSaveExcelFileName(String excelPath) {
        // 提取不含扩展名的文件名
        String perfix = excelPath.substring(0, excelPath.lastIndexOf("."));
        String excelPath1 = perfix + "--未交作业的学生名单.xls";

        return excelPath1;
    }
}
