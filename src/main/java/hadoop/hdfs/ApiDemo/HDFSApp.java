package hadoop.hdfs.ApiDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * 使用Java API 操作Hadoop HDFS文件系统
 * 关键点：
 * 1.创建Configuration
 * 2.获取FileSystem
 * 3.操作HDFS API
 */
public class HDFSApp {

    /**
     * The constant HDFS_PATH.
     */
    public static final String HDFS_PATH="hdfs://localhost:8020";
    /**
     * The File system.
     */
    FileSystem fileSystem = null;
    /**
     * The Configuration.
     */
    Configuration configuration = null;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception{
        configuration = new Configuration();
        configuration.set("dfs.replication","1");
        /**
         * 构造一个访问制定HDFS系统的客户端对象
         * 第一个参数：HDFS的URI
         * 第二个参数：客户端指定的配置参数
         * 第三个参数：客户端身份，用户名
         */
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,"cai");
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown(){
        configuration = null;
        fileSystem = null;
    }

    /**
     * Mkdir.
     *
     * @throws Exception the exception
     */
    @Test
    public void mkdir() throws Exception{
        fileSystem.mkdirs(new Path("/test"));
    }

    /**
     * Text.
     *
     * @throws Exception the exception
     */
    @Test
    public void text() throws  Exception{
		FSDataInputStream in = fileSystem.open(new Path("/hadoop.md"));
	    IOUtils.copyBytes(in,System.out,1024);
    }

    /**
     * Create.
     *
     * @throws Exception the exception
     */
    @Test
    public void create() throws Exception{
	    FSDataOutputStream out = fileSystem.create(new Path("/create.md"));
    	out.writeUTF("hello pk");
    	out.flush();
    	out.close();
    }

    /**
     * Test replication.
     */
    @Test
    public void testReplication(){
		/**
		 * print 3，系统hadoop设置为1，但是因为configuration为一个空的未传入参数的对象，
		 * 所以取/home/cai/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.0-cdh5.15.1/hadoop-hdfs-2.6.0-cdh5.15.1.jar!/hdfs-default.xml 默认的参数
		 * 如果使用命令行则以本地为准
		 * 如果使用api则以jar中的为准，但是可以自己设置参数
		 */
		System.out.println(configuration.get("dfs.replication"));
		System.out.println(configuration.get("hadoop.tmp.dir"));
    }

    /**
     * Rename.
     *
     * @throws Exception the exception
     */
    @Test
    public void rename() throws  Exception{

    	Path oldPath = new Path("/hadoop.md");
    	Path newPath = new Path("/hadoop_new.md");

    	boolean result = fileSystem.rename(oldPath,newPath);
    	System.out.println(result);
    }

    /**
     * Copy from local file.
     *
     * @throws Exception the exception
     */
    @Test
    public void copyFromLocalFile() throws Exception{
	    Path src = new Path("/home/cai/Downloads/hadoop-2.6.0-cdh5.15.1.tar.gz");
	    Path dst = new Path("/hadoop-2.6.0-cdh5.15.1.tar.gz");
	    fileSystem.copyFromLocalFile(src,dst);
    }

    /**
     * 拷贝大文件，带进度条
     *
     * @throws Exception the exception
     */
    @Test
	public void copyFromLocalFileBigFile() throws Exception{

		InputStream in = new BufferedInputStream(new FileInputStream(new File("/home/cai/Downloads/hadoop-2.6.0-cdh5.15.1.tar.gz")));

		FSDataOutputStream out = fileSystem.create(new Path("/file"), new Progressable() {
			@Override
			public void progress() {
				System.out.print(".");
			}
		});

		IOUtils.copyBytes(in,out,4096);

	}

    /**
     * Copy to local file.
     *
     * @throws Exception the exception
     */
    @Test
	public void copyToLocalFile() throws Exception{
		Path src = new Path("/file");
		Path dst = new Path("/home/cai/Desktop/hadoop-2.6.0-cdh5.15.1.tar.gz");
		fileSystem.copyToLocalFile(src,dst);
	}

    /**
     * List files.
     *
     * @throws Exception the exception
     */
    @Test
	public void listFiles() throws Exception{
		FileStatus[] statuses = fileSystem.listStatus(new Path("/"));
		for(FileStatus file : statuses) {
			String isDir = file.isDirectory() ? "文件夹" : "文件";
			String permission = file.getPermission()+"";
			short replication = file.getReplication();
			long length = file.getLen();
			String path = file.getPath()+"";

			System.out.println(isDir+"\t"+permission+"\t"+replication+"\t"+length+"\t"+path);
		}
	}

    /**
     * List files recursive.
     *
     * @throws Exception the exception
     */
    @Test
	public void listFilesRecursive() throws Exception{

		RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/"), true);
		while (files.hasNext()){
			LocatedFileStatus file = files.next();
			String isDir = file.isDirectory() ? "文件夹" : "文件";
			String permission = file.getPermission()+"";
			short replication = file.getReplication();
			long length = file.getLen();
			String path = file.getPath()+"";

			System.out.println(isDir+"\t"+permission+"\t"+replication+"\t"+length+"\t"+path);
		}

	}

    /**
     * Gets file block locations.
     *
     * @throws Exception the exception
     */
    @Test
	public void getFileBlockLocations() throws Exception{
		FileStatus fileStatus = fileSystem.getFileStatus(new Path("/hadoop-2.6.0-cdh5.15.1.tar.gz"));
		BlockLocation[] blocks = fileSystem.getFileBlockLocations(fileStatus,0,fileStatus.getLen());
		for(BlockLocation block : blocks){

			for(String name : block.getNames()){
				System.out.println(name+" : "+block.getOffset() +" : "+block.getLength()+" : "+block.getHosts());
			}
		}
	}

    /**
     * Delete.
     *
     * @throws Exception the exception
     */
    @Test
	public void delete() throws Exception{
		//非递归
		fileSystem.delete(new Path("/hadoop-2.6.0-cdh5.15.1.tar.gz"));
		//递归
		fileSystem.delete(new Path("/hadoop-2.6.0-cdh5.15.1.tar.gz"),true);
	}


}
