package io.bio.componet;

import org.junit.Test;

import java.io.*;

/**
 *
 * inputStream
 * 1.节点流：节点流偏向实现细节，直接与细节打交道
 * 2.处理流：处理流偏功能，以目标功能为抽象
 *
 * @see ByteArrayInputStream（字节数组输入流）节点流
 * @see PipedInputStream（管道输入流）节点流
 * @see SequenceInputStream（合并输入流）节点流
 * @see FileInputStream（文件输入流） 节点流
 * @see ObjectInputStream（对象输入流）节点流
 *
 * @see FilterInputStream（过滤输入流）
 * @see DataInputStream（数据输入流）处理流
 * @see BufferedInputStream（缓冲输入流）处理流
 * @see PushbackInputStream（回退输入流）处理流
 */
public class InputStreamDemo {

    private static InputStream inputStream = null;
    private static String file = "/home/cai/Documents/file/2019.md";

    /**
     * FileInputStream读取文件
     * @throws IOException
     */
    @Test
    public void fileInputStream() throws IOException {
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

    @Test
    public void bufferedInputStream() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String str = new String(bytes, "utf-8");
        System.out.println(str);
    }

    /**
     * 专门用来读各种各样的数据的，比如（int，char，long等）
     * 一定要注意 DataOutputStream 与DataInputStream配合使用，而且二者读写的顺序要一样
     */
    @Test
    public void dataInputStream() throws IOException{
//        @Data
//        @Builder
//        class Enitiy{
//            private int id;
//            private String name;
//        }
//        DataInputStream dataInputStream = new DataInputStream(new DataOutputStream(new ObjectOutputStream()));
//        System.out.println(dataInputStream.readChar());
    }

}
