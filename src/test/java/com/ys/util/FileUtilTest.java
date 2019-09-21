package com.ys.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/09/21
 */
public class FileUtilTest {
    
    private String name = this.getClass().toString();
    private Logger log = Logger.getLogger(name);

    /**
     * Test method for {@link com.ys.util.FileUtil#readDir(java.lang.String)}.
     */
    @Test
    public void testReadDir() {
        // 文件夹路径
        String dirPath = "./测试数据/测试用文件夹--已收作业";

        ArrayList<String> fileList = FileUtil.readDir(dirPath);

        assertFalse(fileList.isEmpty());
        assertNotNull(fileList);

        log.info("----打印文件列表列表：");
        for (String file : fileList) {
            log.info(file);
        }
    }

}
