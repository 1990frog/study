MapReduce概述：
源自google的MapReduce论文
Hadoop MapReduce是Google MapReduce的克隆版
MapReduce优点：海量数据离线处理&易开发&易运行
MapReduce缺点：实时流式计算

mapping 
shuffling
reducing

MapReduce是一种编程模型，用于大规模数据集（大于1TB）的并行运算。概念"Map（映射）"和"Reduce（归约）"，是它们的主要思想，都是从函数式编程语言里借来的，
还有从矢量编程语言里借来的特性。它极大地方便了编程人员在不会分布式并行编程的情况下，将自己的程序运行在分布式系统上。 当前的软件实现是指定一个Map（映射）函数，
用来把一组键值对映射成一组新的键值对，指定并发的Reduce（归约）函数，用来保证所有映射的键值对中的每一个共享相同的键组。

MapReduce编程模型之执行步骤：
准备map处理的输入数据
Mapper处理
Shuffle
Reduce处理

MapReduce编程模型之核心概念
Split
InputFormat
OutputFormat
Combiner
Partitioner