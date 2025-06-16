package com;

import com.alibaba.excel.EasyExcel;
import org.testng.annotations.Test;

import java.util.Map;

public class ReaderExcel {

//    public void test1(){
//        String fileName = "";
//        // 写法1
//        try (ExcelReader excelReader = EasyExcel.read(fileName).build()) {
//            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
//            ReadSheet readSheet1 =
//                    EasyExcel.readSheet(0).head(Map.class).registerReadListener(new DemoDataListener()).build();
//            ReadSheet readSheet2 =
//                    EasyExcel.readSheet(1).head(Map.class).registerReadListener(new DemoDataListener()).build();
//            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
//            excelReader.read(readSheet1, readSheet2);
//        }
//    }

    @Test
    public void test2() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        String fileName = "/home/cai/Downloads/ROW_UPLOAD.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
//        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doReadAll();
        EasyExcel.read(fileName, new NoModelDataListener()).doReadAll();

    }
}
