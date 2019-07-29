资源调度框架YARN
YARN产生背景
YARN概述
YARN架构
YARN执行流程
YARN环境搭建
提交作业到YARN上执行



一、YARN产生背景
MapReduce1.x
master/slave:JobTracker/TaskTracker

JobTracker是一个单点的，压力大
MapReduce1.x只能跑MapReduce

资源利用率：
所有的计算框架运行在一个集群中，共享一个集群的资源，按需分配 

YARN概述：
1.Yet Another Resource Negotiator
2.通用的资源管理系统
3.为上层应用提供统一的资源管理和调度

ResourceManger(RM)
ApplicationMaster(AM)
NodeManager（MM）

YARN框架
Client：向RM提交任务、杀死任务等
ApplicationMaster：每个应用程序对应一个AM，AM向RM申请资源用于在NM上启动对应的Task。数据切分，为每个task向RM申请资源（container），NodeManager通信，任务的监控。
NodeManager：（多个）干活、向RM发送心跳信息、任务的执行情况、启动任务。接收来自RM请求来启动任务。处理来自AM的命令
ResourceManager：集群中同一时刻对外提供服务的只有1个，负责资源相关处理来自客户端的请求：提交、杀死。启动/监控AM。监控NM。资源相关
container：任务的运行抽象，memory、cpu......

master/slave:RM/NM 

--------------------------------------------------------------------------------------------------------------------------------------------

YARN on Single Node

Configure parameters as follows:

etc/hadoop/mapred-site.xml:
<configuration>
<property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
</property>
</configuration>

etc/hadoop/yarn-site.xml:
<configuration>
<property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
</property>
</configuration>


<property>
<name>yarn.resourcemanager.scheduler.class</name>
<value>org.apache.hadoop.yarn.server.resourcemanager.scheduler.capacity.CapacityScheduler</value>
</property>
<property>
<name>yarn.scheduler.minimum-allocation-mb</name>
<value>512</value>
</property>






Start ResourceManager daemon and NodeManager daemon:

$ sbin/start-yarn.sh
ResourceManager
NodeManager

localhost:8088 yarn-console
localhost:8020 hdfs-console

Browse the web interface for the ResourceManager; by default it is available at:

ResourceManager - http://localhost:8088/
Run a MapReduce job.

When you’re done, stop the daemons with:
$ sbin/stop-yarn.sh

--------------------------------------------------------------------------------------------------------------------------------------------
官方例子
/opt/hadoop/hadoop-2.6.0-cdh5.15.1/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0-cdh5.15.1.jar

example:
$ hadoop jar hadoop-mapreduce-examples-2.6.0-cdh5.15.1.jar pi 2 3


fs -mkdir -p /a/b  创建递归目录


























