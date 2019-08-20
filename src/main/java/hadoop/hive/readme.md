Hive概述之Hive是什么？
由Facebook开源，用于解决海量结构和日志的数据统计问题
构建再Hadoop之上的数据仓库
Hive提供的SQL查询语音：HQL
底层支持多种不同的执行引擎


Hive底层执行引擎支持：MR/Tez/Spark

Hive概述之为什么要使用Hive
简单、容易上手
为超大数据集设计的计算/扩展能力

统一元数据管理：
Hive数据是存放在HDFS
元数据信息是存放再MySQL中
SQL on Hadoop：Hive、Spark SQL、impala......

Hive体系架构：
client：shell、thrift/jdbc(server/client)、WebUI(HUE/Zeppelin)
metastore：
driver
mapreduce
RDBMS
Hadoop Storage(HDFS,HBase)

Hive 离线处理、批处理

Hive部署：
1.下载
2.解压
3.配备系统环境变量
vi ~/.bash_profile
export HIVE_HOME
export PATH
source ～/.bash_profile

4.修改配置
hive-env.sh
cp hive-env.sh.template hive-env.sh
vi hive-env.sh
set HADOOP_HOME（如果环境变量中存在，就不需要更改）

hive-site.xml
<configuration>
<property>
<name>javax.jdo.option.ConnectionURL</name>
<value>jdbc:mysql://0.0.0.0:3306/db?createDatabaseIfNotExist=true&amp;useSSL=false</value>  
</property>

<property>
<name>javax.jdo.option.ConnectionDriverName</name>
<value>com.mysql.jdbc.Driver</value>
</property>

<property>
<name>javax.jdo.option.ConnectionUserName</name>
<value>root</value>
</property>

<property>
<name>javax.jdo.option.ConnectionPassword</name>    
<value>root</value>
</property>
</configuration>


<property>
	<name>hive.cli.print.header</name>
	<value>true</value>
</property>l

<property>
	<name>hive.cli.print.current.db</name>
	<value>true</value>
</property>
</configuration>

5.拷贝数据库驱动包到$HIVE_HOME/lib
cp 数据库驱动到 hive/lib




