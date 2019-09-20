CollectHomework
================

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fb667a64f8724b798789c67e9c392d38)](https://app.codacy.com/app/yansheng836/CollectHomework?utm_source=github.com&utm_medium=referral&utm_content=yansheng836/CollectHomework&utm_campaign=Badge_Grade_Dashboard)  [![Build Status](https://travis-ci.org/yansheng836/CollectHomework.svg?branch=master)](https://travis-ci.org/yansheng836/CollectHomework)

出发点：为了方便学习委员收作业，自动清算已交作业的学生名单和未交作业的学生名单。

---

Table of Contents
=================

* [实现功能](#%E5%AE%9E%E7%8E%B0%E5%8A%9F%E8%83%BD)
* [主要类图](#%E4%B8%BB%E8%A6%81%E7%B1%BB%E5%9B%BE)
* [局限性](#%E5%B1%80%E9%99%90%E6%80%A7)
* [测试环境](#%E6%B5%8B%E8%AF%95%E7%8E%AF%E5%A2%83)
* [如何使用](#%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8)
  * [简单使用](#%E7%AE%80%E5%8D%95%E4%BD%BF%E7%94%A8)
  * [开发](#%E5%BC%80%E5%8F%91)
* [注意事项](#%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9)
* [声明](#声明)
* [License](#license)

---

## 实现功能

![工具截图](https://s2.ax1x.com/2019/09/20/nX0W6O.jpg)

1. 输入班级点名册(Excel)路径（绝对路径，包含盘符、扩展名，如: `G:\\Workspaces\\班级点名册.xls`），读取表格中的数据，获得学生列表。（对于一些有特殊情况的同学，即有备注的，则不加入学生列表中。）
2. 输入（存放学生作业的）文件夹路径（绝对路径），读取该目录下的所有文件的文件名（不递归读取次级文件夹内的文件），获得文件列表。
3. 按照学号或者是姓名，将1和2中的数据（即学生列表和文件列表）进行对比，可得到已交作业学生名单和未交作业的学生名单。
4. 提供接口，实现将3中的名单写到 Excel 中。


## 主要类图

![主要类图](https://s2.ax1x.com/2019/09/20/nX6L3n.jpg)


## 局限性
1. 因为这里读写Excel用的是jxl 工具包，该包只能读写以“.xls”为后缀的表格文件。

2. Excel内容需按照要求填写，不然无法正确读写（读取时，如果序号不为空，则认为该行有数据）：

<table align="center" style="text-align:center>
    <tr>
                             <th colspan="4"><b>班级名称，如：16计算机科学与技术1班</b></th>
    </tr>      
    <tr>
    	 <th>序号</th><th>学号</th><th>姓名</th><th>备注</th>
    </tr>
    <tr>
    	<td>1</td><td>20160310100</td><td>张三</td><td></td>
    </tr>
    <tr>
    	<td>2</td><td>20160310101</td><td>李四</td><td></td>
    </tr>
    <tr>
    	<td>……</td><td>……</td><td>……</td><td></td>
    </tr>
    <tr>
    	<td>10</td><td>20160310110</td><td>王五</td><td>休学</td>
    </tr>
    <tr>
    	<td>11</td><td>20160310111</td><td>王麻子</td><td>留级</td>
    </tr>
    <tr>
    	<td>12</td><td>20160310112</td><td>小六子</td><td>退学</td>
    </tr>
    <tr>
    	<td>……</td><td>……</td><td>……</td><td></td>
    </tr>
</table>


3. 备注内容只能是：休学、留级、退学。（如有差异，可以更改`com.ys.util.ExcelUtil`类中的：

   `String[] signs = { "留级", "退学", "休学" };`部分代码）

4. 文件夹路径下的每个学生交的作业命名有一定要求，参考：***学号+姓名+作业名***，eg:***20160310100yansheng-java作业***。

## 测试环境

1. Windows 10  
2. JDK1.8  
3. Eclipse 4.0  
4. Maven 3.6  

## 如何使用

### 简单使用

1. 下载 [最新版本的发布包](<https://github.com/yansheng836/MyOA1/releases>)。

2. 运行 `CollectHomework-*-SNAPSHOT.jar` 。

3. 按照 [实现功能](#%E5%AE%9E%E7%8E%B0%E5%8A%9F%E8%83%BD) 部分内容进行操作，如下为运行测试数据的结果图：

![运行测试数据的结果图](https://s2.ax1x.com/2019/09/20/nXgpsP.jpg)


### 开发

1. git clone <https://github.com/yansheng836/CollectHomework.git> 或者到该网址下载zip包。
2. 将项目导入到Eclipse中。
3. 运行src/main/java下的com.ys.gui的CollectHomeworkMain类（或者com.ys.main的Main类），默认使用项目里面的测试数据（即点名册为："./测试用班级点名册.xls"，文件夹为："./测试用文件夹--已收作业"）；如需修改可以在对应位置进行修改，也可在GUI的文本框中输入对应路径。


## 注意事项

1. 项目使用Maven来管理，Maven依赖为：

   ```xml
   <!-- https://mvnrepository.com/artifact/net.sourceforge.jexcelapi/jxl -->
   		<dependency>
   			<groupId>net.sourceforge.jexcelapi</groupId>
   			<artifactId>jxl</artifactId>
   			<version>2.6.12</version>
   		</dependency>
   ```

   如不使用Maven，则需要将对应jar加到类路径中。
   
2.  如果读取表格时发生错误，有可能是表格的格式有问题。


## 声明

本项目中的测试数据纯属虚构，仅用于测试；如有雷同，不胜荣幸，但是请不要对号入座。


## License

This work is licensed under a [MIT](https://github.com/yansheng836/CollectHomework/blob/master/LICENSE.txt).