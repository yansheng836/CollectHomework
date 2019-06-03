package com.ys.main;

import java.io.File;
import java.util.ArrayList;

import com.ys.bean.Student;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	// 测试
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "16计算机科学与技术3学生名单.xls";
		readExcel(path);

	}

	/*
	 * 1.读取excel文件中的测试用例
	 */
	public static ArrayList<Student> readExcel(String path) {
		System.out.println("1.读取excel文件(" + path + ")中的信息：");
		// 存储测试用例
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			// 2.1 新建（打开）一个工作簿对象
			Workbook book = Workbook.getWorkbook(new File(path));
			// 2.2 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();
			// System.out.println(rows);

			for (int i = 2; i < rows; i++) {
				// 读取数据
				// 如果该行有数据，则读取对应单元格的值，注意不能用sheet.getRow(i).length!=0判断该行无数据，
				// 因为有可能是MulBlankCell空白单元格

				/*
				 * Excel单元格中可以只输入空格，无论用POI解析还是jxl解析，用 if(cell==null)（HSSFCellcell;jxl.Cell
				 * cell;） 判断是否为空是不行的。jxl有判断单元格是否为空的方法
				 * if(cell.getType==CellType.EMPTY)，但这个方法也不能排除只输入空格的情况。 所以，要排除这个情况，要稍微改进一下：
				 * if(cell.getContents().trim().equals(""))
				 */

				// 判空
				// if (cellIDt.getType() == CellType.EMPTY) {
				// System.out.println(cellIDt.toString());// jxl.read.biff.MulBlankCell@506c589e
				// }
				// 假定id 不为0则有数据（输入数据时要进行控制）
				Cell cellIDJ = sheet.getCell(1, i);
				if (cellIDJ.getType() != CellType.EMPTY) {
					Cell cellID = sheet.getCell(0, i);
					Cell cellA = sheet.getCell(1, i);
					Cell cellB = sheet.getCell(2, i);
					Cell cell3 = sheet.getCell(3, i);

					String no = cellID.getContents();
					String sno = cellA.getContents();
					String sname = cellB.getContents();
					String beizhu = cell3.getContents();
					//System.out.println("beizhu："+beizhu);

					// 如果第4列有备注为“留级，修学分”，则不添加该学生姓名到列表中
					if (beizhu.equalsIgnoreCase("留级") || beizhu.equalsIgnoreCase("休学")) {
						//Student student = new Student(no, sno, sname);
						//System.out.println(student + "的情况特殊，不加入学生列表");
					} else {
						Student student = new Student(no, sno, sname);
						students.add(student);
					}

				}

			}

			for (Student student : students) {
				System.out.println(student);
			}

			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

}
