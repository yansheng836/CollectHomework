package com.ys.bean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/09/21
 */
public class StudentTest {

    private String name = this.getClass().toString();
    private Logger log = Logger.getLogger(name);
    private Student student = null;
    private String no = "20";
    private String sno = "2016031033";
    private String sname = "yansheng";

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        student = new Student(no, sno, sname);
//        log.info("初始化成功");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        if (student != null) {
            student = null;
        }
        assertNull(student);
//        log.info("释放资源成功");
    }

    /**
     * Test method for {@link com.ys.bean.Student#Student(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testStudent() {

        assertNotNull(student);
    }

    /**
     * Test method for {@link com.ys.bean.Student#getNo()}.
     */
    @Test
    public void testGetNo() {
        String[] strings1 = {no};
        String[] strings2 = {student.getNo()};

        assertArrayEquals(strings1, strings2);
    }

    /**
     * Test method for {@link com.ys.bean.Student#getSno()}.
     */
    @Test
    public void testGetSno() {
        String[] strings1 = {sno};
        String[] strings2 = {student.getSno()};

        assertArrayEquals(strings1, strings2);
    }

    /**
     * Test method for {@link com.ys.bean.Student#getSname()}.
     */
    @Test
    public void testGetSname() {
        String[] strings1 = {sname};
        String[] strings2 = {student.getSname()};

        assertArrayEquals(strings1, strings2);
    }

}
