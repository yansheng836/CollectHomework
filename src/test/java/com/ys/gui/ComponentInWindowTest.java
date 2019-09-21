package com.ys.gui;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/09/21
 */
public class ComponentInWindowTest {

    // 设置初始化变量
    private String excelPath = null;
    private String dirPath = null;
    private String sign = null;
    private ComponentInWindow win = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        excelPath = "./测试数据/测试用班级点名册.xls";
        dirPath = "./测试数据/测试用文件夹--已收作业";
        sign = "sno";
        win = new ComponentInWindow();
        win.setExcelPath(excelPath);
        win.setDirPath(dirPath);
        win.setSign(sign);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}

    /**
     * Test method for {@link com.ys.gui.ComponentInWindow#getExcelPath()}.
     */
    @Test
    public void testGetExcelPath() {

        String[] strings1 = {excelPath};
        String[] strings2 = {win.getExcelPath()};

        assertArrayEquals(strings1, strings2);
    }

    /**
     * Test method for {@link com.ys.gui.ComponentInWindow#getDirPath()}.
     */
    @Test
    public void testGetDirPath() {
        String[] strings1 = {dirPath};
        String[] strings2 = {win.getDirPath()};

        assertArrayEquals(strings1, strings2);
    }

    /**
     * Test method for {@link com.ys.gui.ComponentInWindow#getSign()}.
     */
    @Test
    public void testGetSign() {
        String[] strings1 = {sign};
        String[] strings2 = {win.getSign()};

        assertArrayEquals(strings1, strings2);
    }

}
