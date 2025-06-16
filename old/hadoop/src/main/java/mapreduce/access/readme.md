自定义复杂类型

access.log
第二个字段：手机号
倒数第三字段：上行流量
倒数第二字段：下行流量

需求：统计每个手机号上行流量和、下行流量和、总的流量和

Access.java
    手机号、上行流量、下行流量、总流量
    
既然要求和：根据手机号进行分组，然后把该手机流量求和

Mapper：把手机号、上行流量、下行流量分开
以手机号作为key，把Access做为value

Reducer：（13690908080,<Access,Access>）


Partitioner类
HashPartitioner类
numReduceTasks


numReduceTasks：你的作业所制定的reducer的个数，决定了reduce作业输出文件的个数
HashPartitioner：是MapReduce默认的分区规则

需求：将统计结果按照手机号的前缀进行区分，并输出到不同的输出文件中去

13* >> .. 
15* >> .. 
other >> ..

Partitioner决定maptask输出的数据交由哪个reducetask处理
默认实现：分发的key的hash值与reduce task个数取模