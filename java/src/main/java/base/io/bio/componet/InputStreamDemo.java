package base.io.bio.componet;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @see java.io.BufferedInputStream 缓冲输入流
 * @see java.io.ByteArrayInputStream 字节数组
 * @see java.io.DataInputStream
 * @see java.io.FilterInputStream
 * @see java.io.PushbackInputStream
 *
 * @see java.io.FileInputStream 从文件中读取信息
 */
public class InputStreamDemo {

    private static InputStream inputStream = null;
    private static String file = "/home/cai/Documents/file/2019.md";

    /**
     * FileInputStream读取文件
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        try{
            // 创建输入流
            inputStream = new FileInputStream(file);
            // available返回剩余可读取的字节序列的长度
            byte[] bytes = new byte[inputStream.available()];
            // 读取字节数组到指定的byte数组中,可以指定偏移量，这里我全读了就不用了
            inputStream.read(bytes);
            // 转成字符串，输出
            String str = new String(bytes, "utf-8");
            System.out.println(str);
        }finally {
            inputStream.close();
        }
    }

    public void test2(){
//            inputStream = ;
//            Scanner scanner = new BufferedInputStream(new FileInputStream(file));

    }


}
