package com.ys.util;

import java.io.File;
import java.util.ArrayList;

import com.ys.bean.Student;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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
	 * 
	 * @Title readExcel
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-03 19:46:19
	 * @Description 1.读取excel文件中的数据，保存到ArrayList中
	 * @param path 需要读取的excel文件路径
	 * @return ArrayList  返回学生集
	 * @see  Student 学生类常见Student
	 * @exception
	 */
	public static ArrayList<Student> readExcel(String path) {

		System.out.println("--读取excel文件(" + path + ")中的信息：");

		// 定义ArrayList，用于存储bean（Student）的集合
		ArrayList<Student> students = new ArrayList<Student>();

		// 该数组主要存放一些特殊的标记，如留级、休学等，作用：点名册中的学生如果有这些标记的就不加入现有学生列表中。
		String[] signs = { "留级", "退学", "休学" };
		// 遍历-测试
		// for (String sign : signs) {
		// System.out.println(sign);
		// }

		// 1. 新建（打开）一个工作簿对象
		Workbook book = null;
		try {
			book = Workbook.getWorkbook(new File(path));
			// 2. 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
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
					// 该列主要是一些特殊的标记
					Cell cellSign = sheet.getCell(3, i);

					String no = cellNo.getContents().trim();
					String sno = cellSno.getContents().trim();
					String sname = cellSname.getContents().trim();
					String sign = cellSign.getContents().trim();
					// System.out.println("sign:" + sign);

					Student student = new Student(no, sno, sname);
					// 如果第4列有特殊标记，则不添加该学生姓名到列表中,否则将该学生添加到列表中
					for (int j = 0; j < signs.length; j++) {
						if (signs[j].equalsIgnoreCase(sign)) {
							System.out.println(student + "的情况特殊，标志sign为：" + sign + ",故不加入学生列表。");
							// 匹配到一个就跳出循环
							break;	
						} else if (j == signs.length - 1) {
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

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
			System.out.println("读Excel成功。");
		}
		return students;
	}

	/**
	 * @Title writeExcel
	 * @author yansheng
	 * @version v1.0
	 * @date 2019-06-03 21:47:04
	 * @Description 2.写Excel的方法
	 * @param students   
	 * @return void 
	 * @see  
	 * @exception
	 */
	public static void writeExcel(ArrayList<Student> students) {

		String path = "16计算机科学与技术3--未交作业的学生名单.xls";
		System.out.println("\n--将学生列表写到excel文件(" + path + ")中:");

		// 1.1 打开文件
		WritableWorkbook book = null;
		try {
			book = Workbook.createWorkbook(new File(path));

			// 1.2 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页", 0);

			// 设置第一行（列，行）,读字符串用Label对象
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
			
			// 写入数据
			book.write();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
			System.out.println("写Excel成功。");
		}
	}

}
