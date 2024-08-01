## 1.二分查找



<img src="assets/image-20240726211839879.png" alt="image-20240726211839879" style="zoom:67%;" />



## 2.分治算法



<img src="assets/image-20240726230531836.png" alt="image-20240726230531836" style="zoom:67%;" />

<img src="assets/image-20240727085313280.png" alt="image-20240727085313280" style="zoom:67%;" />

<img src="assets/image-20240727085345530.png" alt="image-20240727085345530" style="zoom:67%;" />

**应用案例**

### 汉诺塔

<img align=left src="assets/image-20240727085704561.png" alt="image-20240727085704561" style="zoom:50%;" />



## 3.动态规划

**基本结束**

<img src="assets/image-20240727094436436.png" alt="image-20240727094436436" style="zoom:67%;" />



**实践案例**

### 背包问题

<img src="assets/image-20240727111632583.png" alt="image-20240727111632583" style="zoom:67%;" />

<img src="assets/image-20240727111726861.png" alt="image-20240727111726861" style="zoom:67%;" />

![image-20240727125853634](assets/image-20240727125853634.png)

![image-20240727130044283](assets/image-20240727130044283.png)

![image-20240727130624582](assets/image-20240727130624582.png)



## 4.KMP算法(que)



**案例**

### 字符串匹配

>str1 = "java java 学习java java学习 学习好java java好学习"
>
>str2 = " 学习java java学习";
>
>返回 str2第一次出现的位置， 没有返回-1；

![image-20240727152240621](assets/image-20240727152240621.png)



![image-20240727154159639](assets/image-20240727154159639.png)

[KMP算法参考资料](https://www.cnblogs.com/zzuuoo666/p/9028287.html " kmp")





## 5.贪心算法

**基本介绍**

<img src="assets/image-20240727212814272.png" alt="image-20240727212814272" style="zoom:67%;" />



### 集合覆盖问题

<img src="assets/image-20240727211700946.png" alt="image-20240727211700946" style="zoom:67%;" />

<img src="assets/image-20240727213254730.png" alt="image-20240727213254730" style="zoom:67%;" />

<img align=left src="assets/image-20240727220322834.png" alt="image-20240727220322834" style="zoom: 50%;" />



## 6.Prim算法

**基本介绍**

>普利姆算法，也被称为Prim算法，是图论中的一种算法，主要用于在**加权连通图中搜索最小生成树**。该算法由捷克数学家沃伊捷赫·亚尔尼克在1930年首次发现，随后在1957年由美国计算机科学家罗伯特·普里姆独立发现，因此也被称为普里姆算法或普里姆－亚尔尼克算法。在某些场合，它还被称为DJP算法。该算法的核心思想是通过贪心策略逐步构建最小生成树。

**应用案例**

### 最小生成树(修路)问题

<img align=left src="assets/image-20240727230639625.png" alt="image-20240727230639625" style="zoom:50%;" />

<img src="assets/image-20240727230846740.png" alt="image-20240727230846740" style="zoom:67%;" />

<img src="assets/image-20240727231514086.png" alt="image-20240727231514086" style="zoom:67%;" />

<img src="assets/image-20240727233020948.png" alt="image-20240727233020948" style="zoom:67%;" />



## 7.Kruskal 算法

**基本介绍**

>克鲁斯卡尔算法（Kruskal algorithm）是求连通网的最小生成树的一种经典算法，尤其在处理边稀疏的网时表现出色。
>
>克鲁斯卡尔算法的基本思想是从一个只包含所有顶点但不包含任何边的非连通图开始，按照边的权值从小到大的顺序选择边，并添加到图中，但保证不形成回路，直到所有顶点都连通为止。这样形成的图就是原连通网的最小生成树。	

<img src="assets/image-20240728164008356.png" alt="image-20240728164008356" style="zoom:67%;" />

### 最小生成树(公交站)问题

![image-20240728115234207](assets/image-20240728115234207.png)


<div style="display: flex; justify-content: space-between;">  
  <img src="assets/image-20240729081427105.png" alt="Image 1" style="width:48%;">  
  <img src="assets/image-20240729081616768.png" alt="Image 2" style="width:48%;">  
</div>


根据前面介绍的克鲁斯卡尔算法的基本思想和做法,我们能够了解到,克鲁斯卡尔算法重点需要解决的以下两个问题：

问题一 对图的所有边按照权值大小进行排序。
问题二 将边添加到最小生成树中时,**怎么样判断是否形成了回路**。

问题一很好解决,采用排序算法进行排序即可。
问题二,处理方式是:记录顶点在"最小生成树"中的终点,顶点的终点是"在最小生成树中与它连通的最大顶点"。
然后每次需要将一条边添加到最小生存树时,判断该边的两个顶点的终点是否重合,重合的话则会构成回路。

 <img src="assets/image-20240729083413397.png" alt="image-20240729083413397" style="zoom:67%;" />



**并查集（Union-Find）** 了解一下



## 8.Dijkstra(迪杰斯特拉)算法

**基本介绍**

>迪杰斯特拉(Dijkstra)算法是典型最短路径算法,用于计算一个结点到其他结点的最短路径。
>它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想),直到扩展到终点为止。



<img src="assets/image-20240801080459339.png" alt="image-20240801080459339" style="zoom:67%;" />



应用场景

### 最短路径问题

<img src="assets/image-20240801075354611.png" alt="image-20240801075354611" style="zoom:67%;" />
