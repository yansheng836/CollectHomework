package com.ys.bean;

/**
 * <p>Title: </p>
 * <p>Description:测试Student </p>
 * <p>Company: </p>
 * @author yansheng
 * @date 2019-06-03 23:06:01
 * @version v1.0 
 */
public class TestStudent {

	/**
	 * @Title main
	 * @author yansheng
	 * @version v1.0
	 * @Time 2019-06-03 23:06:20
	 * @Description 测试Student
	 * @param args   
	 * @return void 
	 * @see  Student
	 * @exception
	 */
	public static void main(String[] args) {
		
		Student student = new Student("16", "20160310339", "yansheng");
		
		System.out.println(student);

	}

}
