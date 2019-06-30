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
 * <p>Title: </p>
 * <p>Description:作为读写Excel的工具类，提供读写服务 </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-03 21:35:32
 * @version v1.0 
 */
public class ExcelUtil {

	/**
	 * @Title readExcel
	 * @author yansheng
	 * @version v2.0
	 * @date 2019-06-22 14:51:00
	 * @Description 读取excel文件中的数据，保存到ArrayList中
	 * @param excelPath	需要读取的excel文件路径
	 * @return   
	 * ArrayList<Student> 返回学生集
	 * @see  Student 学生类详见Student
	 * @exception NullPointerException	传入参数为空时，抛出异常。
	 * @exception FileNotFoundException 系统中没有找到该文件时，抛出异常。
	 * @exception BiffException Excel表格的格式不是xls
	 * @exception IOException 读文件时发生异常。
	 * @exception IndexOutOfBoundsException 读取的工作表数量、单元格的行数或者越界。
	 * @exception Exception 关闭文件失败时抛出异常
	 */
	public static ArrayList<Student> readExcel(String excelPath) {

		System.out.println("----读取excel文件(" + excelPath + ")中的信息：");

		// 定义ArrayList，用于存储bean（Student）的集合
		ArrayList<Student> students = new ArrayList<Student>();

		// 该数组主要存放一些特殊的标记，如留级、休学等，作用：点名册中的学生如果有这些标记的就不加入现有学生列表中。
		String[] signs = { "留级", "退学", "休学" };
		int signsLength = signs.length;
		// 遍历-测试
		// for (String sign : signs) {
		// System.out.println(sign);
		// }

		// 1. 新建（打开）一个工作簿对象
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(excelPath));
			// 2. 获得第一个工作表对象
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			// System.out.println(rows);

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
					// System.out.println("sign:" + sign);

					Student student = new Student(no, sno, sname);
					// 如果第4列有特殊标记，则不添加该学生姓名到列表中,否则将该学生添加到列表中
					for (int j = 0; j < signsLength; j++) {
						if (signs[j].equalsIgnoreCase(sign)) {
							System.out.println(student + "的情况特殊，标志sign为：" + sign + ",故不加入学生列表。");
							// 匹配到一个就跳出循环
							break;
						} else if (j == signsLength - 1) {
							// 遍历关键字列表都没有匹配到，将该学生添加到列表中
							students.add(student);
						}
					}
				}
			}

			// 遍历列表
			// System.out.println("\n班级学生列表有学生" + students.size() + "人，具体信息如下：");
			// for (Student student : students) {
			// System.out.println(student);
			// }

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
		} catch (IndexOutOfBoundsException e) {
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
		return students;
	}

	/**
	 * @Title writeExcel
	 * @author yansheng
	 * @version v2.0
	 * @date 2019-06-22 15:30:23
	 * @Description 将学生列表的数据写到Excel的方法
	 * @param students 学生列表
	 * @param excelPath 读取的excel表格路径
	 * void 
	 * @see  Student
	 * @exception NullPointerException File路径名为空。
	 * @exception java.io.IOException 创建工作表时发生异常。
	 * @exception jxl.write.biff.RowsExceededException 添加单元格到工作表时，当写入的函数超过最大值时(10000以内不会)抛出异常。
	 * @exception jxl.write.WriteException 添加单元格到工作表时，可能发生的异常。
	 * @exception java.lang.Exception 关闭workbook时发生异常。
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

	/**
	 * @Title getSaveExcelFileName
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-30 11:47:47
	 * @Description 设置需要保持的数据的excel的文件名
	 * @param excelPath
	 * @return   
	 * String 
	 */
	public static String getSaveExcelFileName(String excelPath) {
		// 提取不含扩展名的文件名
		// System.out.println("excelPath:"+excelPath);
		String perfix = excelPath.substring(0, excelPath.lastIndexOf("."));
		String excelPath1 = perfix + "--未交作业的学生名单.xls";
		// System.out.println("perfix:" + perfix);
		// System.out.println("excelPath1:" + excelPath1);

		return excelPath1;
	}
}
