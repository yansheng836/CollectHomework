package com.ys.bean;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * 测试Student
 * 
 * @author yansheng
 * @date 2019/06/03
 */
public class StudentTest {
    
    String name = this.getClass().toString();
    Logger log  = Logger.getLogger("name");

    @Test
    public void testStudent() {
        
        Student student = new Student("16", "20160310339", "yansheng");

        log.info(student.toString());
    }

}
