## 剑指Offer第二版题解

#### [面试题03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**示例 1：**

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200510114942790.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //如果当前值不是当前索引对应的值
            if(i!=nums[i]){
                //当前值对应的索引是否已经存有了当前值，如果是说明重复
                int cur=nums[i];
                if(cur==nums[cur])
                    return cur;
                else{//如果不是，就将当前值放到自己对应的索引，将自己对应索引的值放过来
                    nums[i]=nums[cur];
                    nums[cur]=cur;
                }
            }
        }
        //没找到，返回0（随便返回一个数即可）
        return 0;
    }
}
```

---

#### [面试题04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**示例:**

现有矩阵 matrix 如下：

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

给定 target = `5`，返回 `true`。

给定 target = `20`，返回 `false`。

**思路和代码：**

我们分析该二维数组的特点，左到右递增，上到下递增，因此可以从右上角开始寻找。

如果比目标值大，就往左边找，如果比目标值小，就往下边找。

```java
class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int r=0;//起始行为第一行
        int c=matrix[0].length-1;//起始列为最后一列
        while(r<matrix.length&&c>=0){//边界条件
            if(matrix[r][c]<target)
                r++;
            else if(matrix[r][c]>target)
                c--;
            else
                return true;
        }
        return false;
    }
    
}
```

---

#### [面试题05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。

**示例 1：**

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

**思路和代码：**

这道题很简单没什么好说的，利用StringBuilder拼接字符串即可，如果遇到空格就替换。

```java
class Solution {

    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                sb.append("%20");
            else   
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```

---

#### [面试题06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1：**

```
输入：head = [1,3,2]
输出：[2,3,1]
```

**思路和代码：**

利用ArrayList顺序保存链表，然后逆序保存到结果数组中返回即可。

```java
class Solution {

    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(list.size()-i-1);
        return res;
    }

}
```

---

#### [面试题07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200510115023406.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    //key是中序遍历的值，value是中序遍历的结果
    HashMap<Integer,Integer> indexMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //保存中序遍历的信息
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder,0,inorder.length-1);
    }

    //preIndex是前序遍历的索引，inStart和inEnd是中序遍历的索引范围
    private TreeNode createTree(int[] preorder,int preIndex,int[] inorder,int inStart,int inEnd){
        if(inStart>inEnd)
            return null;
        //获取前序遍历的值
        int val=preorder[preIndex];
        //获取前序遍历值在中序遍历的位置
        int inIndex=indexMap.get(val);
        //以该值作为根节点的值创建根节点
        TreeNode root=new TreeNode(val);
        //根节点的左子树节点数目
        int leftNum=inIndex-inStart;
        //根节点以左创建左子树，根节点以右创建右子树
        root.left=createTree(preorder,preIndex+1,inorder,inStart,inIndex-1);
        root.right=createTree(preorder,preIndex+1+leftNum,inorder,inIndex+1,inEnd);
        return root;
    }
}
```

---

#### [面试题09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead` ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 -1 )

**示例 1：**

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2：**

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200510114856100.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom: 67%;" />

```java
class CQueue {

    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        s1.add(value);
    }
    
    public int deleteHead() {
        if(s1.empty())
            return -1;
        while(s1.size()!=1){
            s2.add(s1.pop());
        }
        int temp=s1.pop();
        while(!s2.empty()){
            s1.add(s2.pop());
        }
        return temp;
    }
}
```

---

#### [面试题10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 `n` 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：2
```

**示例 2：**

```
输入：n = 7
输出：21
```

**提示：**

- `0 <= n <= 100`

**思路和代码：**

简单的动态规划，跳到0或1级有1种方法，之后跳到i的方法数量=跳到i-1的方法数量+跳到i-2的方法数量（因为每次可以跳1或2级）。

由于每次结果要取模所以要mod1000000007。

```java
    public int numWays(int n) {
        if(n==0||n==1)
            return 1;
        int mod=1000000007;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        return dp[n];
    }
```

---

#### [面试题10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项。斐波那契数列的定义如下：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：1
```

**示例 2：**

```
输入：n = 5
输出：5
```

**思路和代码：**

和上一题类似，几乎没有变化，只需要修改n的初始值为0。

```java
class Solution {
    public int fib(int n) {
        if(n==0||n==1)
            return n;
        int mod=1000000007;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        return dp[n];
    }
}
```

---

#### [面试题11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 `[3,4,5,1,2]` 为 `[1,2,3,4,5]` 的一个旋转，该数组的最小值为1。 

**示例 1：**

```
输入：[3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：[2,2,2,0,1]
输出：0
```

**思路和代码：**

比较简单，我们从头遍历，如果一个数字大于它的下一个，就返回它的下一个。

例如示例1中，5>1，返回1，示例2中，2>0，返回0。

如果没找到就返回第一个，例如12345返回1。

```java
class Solution {
    public int minArray(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1])
                return numbers[i+1];
        }
        return numbers[0];
    }
}
```

---

#### [面试题12. 矩阵中的路径](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","**b**","c","e"],
["s","**f**","**c**","s"],
["a","d","**e**","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

**示例 1：**

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

**示例 2：**

```
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
```

**思路和代码：**

使用深度优先搜索回溯，从全部字符以头开始遍历，如果寻找到了就直接返回true，否则继续以下一个字符为头重新开始。

k代表已经成功匹配的字符数量，初始为0，每匹配一个加1，当达到目标长度时返回true。

每次进行下一层搜索时将当前字符设为一个非字母值，这样可以防止重复遍历。

```java
class Solution {

    
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }


    private boolean dfs(char[][] board,char[] words,int i,int j,int k){
        if(i<0||j<0||i==board.length||j==board[0].length)//边界判断防止越界
            return false;
        if(board[i][j]!=words[k])//如果遍历字符和目标字符不符，返回false
            return false;
        //如果全部匹配成功，k已达到目标数组长度，返回true
        if(k==words.length-1)
            return true;
        char temp=board[i][j];//保存当前字符
        board[i][j]='*';//当前字符遍历后，防止在dfs中重复遍历，设为任意非字母字符
        //保存当前结果
        boolean res=dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)
                  ||dfs(board,words,i,j+1,k+1)||dfs(board,words,i,j-1,k+1);
        board[i][j]=temp;//还原字符，下次遍历正常
        //还原字符后返回结果
        return res;
    }
}
```

---

#### [面试题13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

地上有一个m行n列的方格，从坐标 `[0,0]` 到坐标 `[m-1,n-1]` 。一个机器人从坐标 `[0, 0] `的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

**示例 1：**

```
输入：m = 2, n = 3, k = 1
输出：3
```

**示例 2：**

```
输入：m = 3, n = 1, k = 0
输出：1
```

**提示：**

- `1 <= n,m <= 100`
- `0 <= k <= 20`

**思路和代码：**

设置一个boolean类型的二维数组，用来标志是否访问过该位置。

由于最多100行，100列，因此索引从0~99。用/和%计算各位的数字之和，例如35和37，35/10+35%10+37/10+37%10=18。

```java
class Solution {

    int M;//保存行
    int N;//保存列
    int K;//保存阈值
    boolean[][] visited;//访问数组

    public int movingCount(int m, int n, int k) {
        M=m;
        N=n;
        K=k;
        visited=new boolean[m][n];
        return count(0,0);
    }

    public int count(int i,int j){
        //如果越界或已访问过或各位加起来大于阈值，返回0
        if(i<0||i==M||j<0||j==N||visited[i][j]||(i/10+i%10+j/10+j%10)>K)
            return 0;
        //更新访问标记
        visited[i][j]=true;
        //在上下左右四个方法继续寻找
        return 1+count(i-1,j)+count(i+1,j)+count(i,j-1)+count(i,j+1);
    }
}
```

---

#### [面试题14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

给你一根长度为 `n` 的绳子，请把绳子剪成整数长度的 `m` 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 `k[0],k[1]...k[m]` 。请问 `k[0]*k[1]*...*k[m]` 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

**示例 1：**

```
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
```

**示例 2:**

```
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```

**提示：**

- `2 <= n <= 58`

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200510131840682.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;
        int a=n/3;
        int b=n%3;
        if(b==0)//情况1，是3的倍数
            return (int)Math.pow(3,a);
        if(b==1)//情况2，余1，拆出一个4
            return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;//情况3，余2，拆出一个2
    }
}
```

也可以写成这样

```java
    public int cuttingRope(int n) {
        if(n==2||n==3) 
            return n-1;        
        long res = 1;
        //在剩下的绳子中，优先拆分出3，如果剩下0相当于情况1，剩下4相当于情况2，剩下2相当于情况3
        while(n>4){
            res*=3;
            n-=3;
        }
        return (int)(res*n);
    }
```

---

#### [面试题14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/)

给你一根长度为 `n` 的绳子，请把绳子剪成整数长度的 `m` 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 `k[0],k[1]...k[m]` 。请问 `k[0]*k[1]*...*k[m]` 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**思路和代码：**

和上一题几乎一样，只需要多一个取模，套用第二个方法模板。

```java
class Solution {
    public int cuttingRope(int n) {
        if(n==2||n==3) 
            return n-1;        
        int mod = 1000000007;
        long res = 1;
        while(n>4){
            res*=3;
            res%=mod;
            n-=3;
        }
        return (int)(res*n%mod);
    }
}
```

---

#### [面试题15. 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

**示例 1：**

```
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
```

**示例 2：**

```
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
```

**思路和代码：**

我们可以将n和1做与运算，与运算相同为1不同为0，因此如果n的最后1位是1，和1与的结果肯定是1，此时计数器加1；如果与的结果是0，代表最后1位是0，此时计数器加0。

比较完最后一位之后，将n无符号右移一位，这样倒数第二位就成了最后一位，然后继续比较。

当n包含1时肯定是大于0的，不包含1时也就比较完了，此时n=0。

```java
    public int hammingWeight(int n) {
        int count=0;//1计数器
        while(n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }
```

---

#### [面试题16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

**示例 1:**

```
输入: 2.00000, 10
输出: 1024.00000
```

**示例 2:**

```
输入: 2.10000, 3
输出: 9.26100
```

**示例 3:**

```
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```

**思路和代码：**

0次方的时候返回1，1次方返回自己，-1次方返回自己的倒数。

为了加快速度，如果n是偶数，直接计算n/2的结果再做平方即可，例如计算2的10次方，只需要计算2的5次方，再将结果做平方运算。

如果是奇数，也计算n/2的结果，然后如果n>0就乘上x，小于0就乘上1/x。

例如计算2的9次方，将2的4次方做平方运算再乘2。

计算2的-11次方，将2的-5次方做平方运算再乘1/2。

```java
class Solution {

    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n==-1)
            return 1/x;
        double res=myPow(x,n/2);
        if(n%2==0){
            return res*res;
        }
        return n<0?res*res*1/x:res*res*x;
    }
}
```

---

#### [面试题17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

输入数字 `n`，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

**示例 1:**

```
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

说明：

- 用返回一个整数列表来代替打印
- n 为正整数

**思路和代码：**

先计算出最大的n位数，也就是n个9，做n次（x10+9）的运算即可。

即9，99，999...

```java
class Solution {

    public int[] printNumbers(int n) {
        //计算最大的n位数，999...9（n个9）
        int res=0;
        while(n!=0){
            res=res*10+9;
            n--;
        }
        int[] arr=new int[res];
        for(int i=0;i<arr.length;i++)
            arr[i]=i+1;
        return arr;
    }
}
```

---

#### [面试题18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

**注意：**此题对比原题有改动

**示例 1:**

```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

**示例 2:**

```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

**思路和代码：**

因为第一个节点也有可能要删除，所以我们要创建一个新的头节点，将它与头节点连接，然后从新的头节点开始遍历，这里需要一个新的指针，因pre不能移动。如果当前节点A的下一个节点B不为空就判断B的值是否等于要删除的值，如果是就将当前节点A指向B的下一个节点C，然后break。

最后返回新头节点的下一个节点即可。

<img src="https://img-blog.csdnimg.cn/20200510142625322.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode cur=pre;
        while(cur!=null&&cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
                break;
            }
            cur=cur.next;
        }
        return pre.next;
    }
}
```

---

#### [面试题19. 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

请实现一个函数用来匹配包含`'. '`和`'*'`的正则表达式。模式中的字符`'.'`表示任意一个字符，而`'*'`表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串`"aaa"`与模式`"a.a"`和`"ab*ac*a"`匹配，但与`"aa.a"`和`"ab*a"`均不匹配。

**示例 1:**

```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```

**示例 2:**

```
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```

**示例 3:**

```
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```

**示例 4:**

```
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
```

**示例 5:**

```
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```

**思路和代码：**

![](https://img-blog.csdnimg.cn/20200511154006269.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

```java
class Solution {
    public boolean isMatch(String s, String p) {
        //任意一个为空，则匹配失败
        if(s==null||p==null)
            return false;
        return match(s.toCharArray(),0,p.toCharArray(),0);
    }

    public boolean match(char[] str, int s,char[] pattern,int p){
        //如果字符串和匹配字符串都到达了末尾，则说明匹配成功
        if(s==str.length&&p==pattern.length)
            return true;
        //如果字符串未遍历结束，但匹配字符串已结束，匹配失败
        if(s<str.length&&p==pattern.length)
            return false;
        //如果匹配字符串的下一个字符是*
        if(p<pattern.length-1&&pattern[p+1]=='*'){
            //如果当前字符串字符和匹配字符串字符相同或者匹配字符为.
            if(s<str.length&&(str[s]==pattern[p]||pattern[p]=='.'))
                return match(str, s+1, pattern, p)//.*可以匹配多个字符 如aa匹配a*
                     ||match(str, s, pattern, p+2);//字符串已匹配完，放弃匹配字符串的两个位置，例如a匹配ab*
            else
                return match(str, s, pattern, p+2);//忽略当前匹配字符串的2个字符 如a不匹配b*，可跳过b*这两个位置
        }
        //匹配字符串没有下一个位置或下一个位置不为*，那么当前位置必须相等或为.，否则匹配失败
        if(s<str.length&&(str[s]==pattern[p]||pattern[p]=='.')){
            return match(str,s+1,pattern,p+1);//各自匹配一个位置
        }
        return false;
    }
}
```

---

#### [面试题20. 表示数值的字符串](https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/)

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

思路和代码：

[abc]表示匹配a、b、c任意一个即可。[0-9]表示匹配数字0-9 

`\\.`表示小数点，？表示0或1次，+表示1或多次，*表示任意次，|表示或。

首先判断开头，[+-]？表示可以以加号或减号开头，也可以不以加减号开头。

数字部分是`[0-9]+\\.?`表示0-9必须出现一次，小数点可以不出现，例如`111`，`11.`

或者是`[0-9]*\\.[0-9]+`，表示小数点前任意次，小数点必须有，小数点后必须有，例如`.5`，`1.5`

最后指数`[e][+-]?[0-9]+`匹配时表示必须有e，正负号可有可无，有e时后面必须有数字，？表示也可以没指数。

```JAVA
class Solution {
    public boolean isNumber(String s) {
        return s.trim()
                .matches("^[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))([e][+-]?[0-9]+)?$");
    }
}
```

---

#### [面试题21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

**示例：**

```
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```

**思路和代码：**

类似于快速排序的思想，使用双指针，从头找偶数，从尾找奇数，然后交换它们的位置。

```java
class Solution {

    public int[] exchange(int[] nums) {
        int p=0;
        int q=nums.length-1;
        while(p<q){
            //从前面找到第一个偶数
            while(p<=q&&nums[p]%2!=0)
                p++;
            //从后面找到第一个奇数
            while(p<=q&&nums[q]%2==0)
                q--;
            if(p<q){//交换数字
                int temp=nums[p];
                nums[p]=nums[q];
                nums[q]=temp;
            }
        }
        return nums;
    }
}
```

---

#### [面试题22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```

**思路和代码：**

可以使用双指针，让快指针先走k个，这样当快指针为null时慢指针就是答案。

<img src="https://img-blog.csdnimg.cn/2020051014371136.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode slow=pre;
        ListNode fast=pre;
        for(int i=0;i<k;i++)
            fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
```

---

#### [面试题24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**思路和代码：**

利用三个指针，pre指针保存前一个节点，cur指针用于遍历链表，last指针总是指向cur的下一个，这样在cur指向pre之后，cur还是可以跳到之前的下一个位置。

<img src="https://img-blog.csdnimg.cn/20200510144638760.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode last=null;
        ListNode cur=head;
        while(cur!=null){
            last=cur.next;
            cur.next=pre;
            pre=cur;
            cur=last;
        }
        return pre;
    }
}
```

---

#### [面试题25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

**示例1：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

**思路和代码：**

比较简单，由于是有序链表，所以分别从头开始遍历，如果l1更小，将节点的下一个指向l1，否则就指向l2。如果有一个为空，就将另一个剩下的链表直接拼接。

```java
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1);
        ListNode cur=pre;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return pre.next;
    }
}
```

---

#### [面试题26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

**示例 1：**

```
输入：A = [1,2,3], B = [3,1]
输出：false
```

**示例 2：**

```
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```

思路和代码：

简单递归

```java
class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)
            return false;
        //以当前节点为根匹配，或者以左右节点为根匹配
        return isSub(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    //将A作为根节点匹配B
    public boolean isSub(TreeNode A,TreeNode B){
        if(B==null)//B为空代表匹配完毕
            return true;
        if(A==null)//B非空但A空，匹配失败
            return false;
        //两个节点值不同，匹配失败
        if(A.val!=B.val)
            return false;
        //根节点相同，匹配左右节点
        return isSub(A.left,B.left)&&isSub(A.right,B.right);
    }
}
```

---

#### [面试题27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

**思路和代码：**

简单递归即可

```java
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root!=null){
            //将右子树翻转作为新的左子树
            TreeNode newLeft=mirrorTree(root.right);
            //将左子树翻转作为新的右子树
            TreeNode newRight=mirrorTree(root.left);
            root.left=newLeft;
            root.right=newRight;
        }
        return root;
    }
}
```

---

#### [面试题28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:

```
    1
   / \
  2   2
   \   \
   3    3
```

**思路和代码：**

如果根节点为空，那么空节点是对称的。

否则比较它的左右子树是否对称，如果都为空那对称，如果只有一个为空肯定不对称。

如果都不为空那么比较值，值不同肯定不对称，如果值相同，再比较左节点的右子树和右节点的左子树是否对称（最里面那一层），比较左节点的左子树和右节点的右子树是否对称（最外面那一层）。

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode p,TreeNode q){
        if(p==null&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSymmetric(p.left,q.right)&&isSymmetric(p.right,q.left);
    }
}
```

---

#### [面试题29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

**示例 1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例 2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

**思路和代码：**

在一个死循环中按照右下左上的顺序循环，每次改变方向前先判断是否越界。

```java
class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int[] nums=new int[matrix.length*matrix[0].length];
        int index=0;
        int up=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(true){
            //从左向右移动
            for(int i=left;i<=right;i++)
                nums[index++]=matrix[up][i];
            if(++up>down) break;
            //从上向下移动
            for(int i=up;i<=down;i++)
                nums[index++]=matrix[i][right];
            if(--right<left) break;
            //从右向左移动
            for(int i=right;i>=left;i--)
                nums[index++]=matrix[down][i];
            if(--down<up) break;
            //从下向上移动
            for(int i=down;i>=up;i--)
                nums[index++]=matrix[i][left];
            if(++left>right) break;
        }
        return nums;
    }
}
```

---

#### [面试题30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

**示例:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

**思路和代码：**

使用一个辅助栈s2作为最小栈，进栈出栈s1都没有限制，对于最小栈s2只有s2为空或入栈节点值小于等于s2栈顶时才可入栈，出栈时，只有s1和s2栈顶相同s2才出栈。

<img src="https://img-blog.csdnimg.cn/20200510174418419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class MinStack {

    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();

    public MinStack() {

    }
    
    public void push(int x) {
        if(s2.empty()||x<=s2.peek())
            s2.add(x);
        s1.add(x);
    }
    
    public void pop() {
        if(s1.pop().equals(s2.peek()))
            s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
}
```

---

#### [面试题31. 栈的压入、弹出序列](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

**示例 1：**

```
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```

**示例 2：**

```
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
```

思路和代码：

利用一个辅助栈来模拟，停止条件是压栈序列全部入栈，然后入栈时如果栈顶和出栈序列的当前元素相同就出栈一个，直到栈空或栈顶不等于出栈序列当前元素。

最后判断栈是否空，如果空代表入栈出栈有效。

<img src="https://img-blog.csdnimg.cn/20200510235932419.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int pushIndex=0;
        int popIndex=0;
        while(pushIndex!=pushed.length){
            stack.push(pushed[pushIndex]);
            while(!stack.empty()&&stack.peek()==popped[popIndex]){
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return stack.empty();
    }
}
```

---

#### [面试题32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回：

```
[3,9,20,15,7]
```

**思路和代码：**

利用一个ArrayList作为队列，存储树节点，当队列不为空就就将其从头移除，并将值加入结果集。然后按照先左后右的顺序，再把它的非空子节点入队。

```java
class Solution {

	public int[] levelOrder(TreeNode root) {
        //保存树节点的队列
        List<TreeNode> treeList=new ArrayList<>();
        //保存结果集
        List<Integer> list=new ArrayList<>();
        //空树返回空数组
        if(root==null)
            return new int[0];
        treeList.add(root);
        while(treeList.size()!=0){
            TreeNode temp=treeList.get(0);
            list.add(temp.val);
            treeList.remove(0);
            if(temp.left!=null){//左节点非空进队
                treeList.add(temp.left);
            }
            if(temp.right!=null){//右节点非空进队
                treeList.add(temp.right);
            }
        }
        //返回结果
        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
    }

}
```

---

#### [面试题32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

**思路和代码：**

和上一题类似，只是要将每一行的数值保存到同一个list中。每次出队之前先计算当前队列的大小，这个大小就是这一层的节点数量，然后按这个数量依次从队头移除。

注意这个数量必须提前计算，而不能使用list.size()，因为size一直在改变。

```java
class Solution {
    
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> treeList=new ArrayList<>();//树节点队列
        List<Integer> temp;//每一层的临时列表
        List<List<Integer>> resultList=new ArrayList<>();//结果集
        if(root!=null){
            treeList.add(root);
            while(treeList.size()!=0){
                int n=treeList.size();//计算该层节点数
                temp=new ArrayList<>();//每一层都创建一个list保存结果
                for(int i=0;i<n;i++){//按数量出队
                    TreeNode node=treeList.remove(0);
                    temp.add(node.val);
                    if(node.left!=null)
                        treeList.add(node.left);
                    if(node.right!=null)
                        treeList.add(node.right);
                }
                resultList.add(temp);//将这一层的结果添加到结果集
            }
        }
        return resultList;
    }

}
```

---

#### [面试题32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [20,9],
  [15,7]
]
```

**思路和代码：**

和上一题几乎一样，我们只需要增加一个方向变量，每一层都改变它即可。

```java
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> treeList=new ArrayList<>();//树节点队列
        List<Integer> temp;//每一层的临时列表
        List<List<Integer>> resultList=new ArrayList<>();//结果集
        boolean leftToRight=true;//控制方向，初始从左往右
        if(root!=null){
            treeList.add(root);
            while(treeList.size()!=0){
                int n=treeList.size();//计算该层节点数
                temp=new ArrayList<>();//每一层都创建一个list保存结果
                for(int i=0;i<n;i++){//按数量出队
                    TreeNode node=treeList.remove(0);
                    temp.add(node.val);
                    if(node.left!=null)
                        treeList.add(node.left);
                    if(node.right!=null)
                        treeList.add(node.right);
                }
                if(!leftToRight){//如果是逆序，就把该层结果逆序
                    Collections.reverse(temp);
                }
                resultList.add(temp);//将这一层的结果添加到结果集
                leftToRight=!leftToRight;//每一层完了都改变方向
            }
        }
        return resultList;
    }
}
```

---

#### [面试题33. 二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 `true`，否则返回 `false`。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

```
     5
    / \
   2   6
  / \
 1   3
```

**示例 1：**

```
输入: [1,6,3,2,5]
输出: false
```

**示例 2：**

```
输入: [1,3,2,6,5]
输出: true
```

**思路和代码：**

根据后序遍历左-右-根的特点，从左边找到第一个大于根节点的值划分左右子树，左子树的值必须都比该值小（由于找到的是第一个大于根节点的值，这点肯定满足），接下来由于右子树都比根节点值大，再找到第一个不大于根节点的值，此时索引肯定等于根节点，如果不等于就是false。

```java
class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    //j是根节点
    public boolean verify(int[] postorder,int i,int j){
        if(i>=j)
            return true;
        int mid=i;
        //左-右-根，因此mid相当于找到了第一个右节点
        //例如1，3，2，6，9，7，5，root从1开始遍历到6停止，mid=6,132就是左子树
        while(postorder[mid]<postorder[j])
            mid++;
        int root=mid;
        //左-右-根，由于已经开始遍历右子树，如果找到第一个不大于j的值只能是j本身
        //例如1，3，2，6，9，7，5，root从6开始遍历到5停止，root=j
        while(postorder[root]>postorder[j])
            root++;
        //例如1，3，2，6，9，2，5，root从6开始遍历到2停止，root!=j,5的右子树有2，肯定不对
        if(root!=j)
            return false;
        //继续判断左右子树，i到mid-1就是1到2，mid到j-1就是6到7
        return verify(postorder,i,mid-1)&&verify(postorder,mid,j-1);
    }

}
```

---

#### [面试题34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

**示例:**
给定如下二叉树，以及目标和 `sum = 22`，

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
```

返回:

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

**思路和代码：**

![](https://img-blog.csdnimg.cn/20200511001940926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

```java
class Solution {

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        help(root,sum);
        return res;
    }

    public void help(TreeNode root,int sum){
        if(root==null)
            return;
        temp.add(root.val);
        //只有在路径末尾是叶子节点时才添加结果
        if(root.val==sum&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(temp));
        }
        help(root.left,sum-root.val);
        help(root.right,sum-root.val);
        //回溯减去末尾值
        temp.remove(temp.size()-1);
    }
}
```

---

#### [面试题35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

请实现 `copyRandomList` 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 `next` 指针指向下一个节点，还有一个 `random` 指针指向链表中的任意节点或者 `null`。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png)

```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png)

```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```

**示例 3：**

**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png)**

```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```

**示例 4：**

```
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
```

**提示：**

- `-10000 <= Node.val <= 10000`
- `Node.random` 为空（null）或指向链表中的节点。
- 节点数目不超过 1000 。

思路和答案：

<img src="https://img-blog.csdnimg.cn/20200511171715522.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node newHead=head;
        //在每一个节点后都复制一个节点
        while(head!=null){
            Node copy=new Node(head.val);
            copy.next=head.next;
            head.next=copy;
            head=copy.next;
        }
        head=newHead;
        //每一个复制节点的随机节点都是前一个节点的随机节点的next
        while(head!=null){
            Node copy=head.next;
            copy.random=head.random==null?null:head.random.next; 
            head=copy.next;      
        }
        head=newHead;
        Node res=newHead.next;
        //拆分链表
        while(head!=null){
            Node copy=head.next;
            head.next=copy.next;     
            head=copy.next;      
            copy.next=head!=null?head.next:null;
        }
        return res;
    }
}
```

---

#### [面试题36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

 

<img src="https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png" alt="img" style="zoom:67%;" />

 

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 

<img src="https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png" alt="img" style="zoom:67%;" />

 

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

**思路和代码：**

这道题其实不难，由于是二叉搜索树所以使用中序遍历从小到大遍历即可，每次遍历的时候把当前节点的left指向前一个节点，把前一个节点的right指向当前节点即可。

遍历到的第一个节点就是最小节点，此时head就是它，从第二个节点开始操作，每次更新pre。

遍历完之后pre就是最后一个节点，再把它和head连起来就行。

```java
class Solution {

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        dfs(root);
        pre.right=head;
        head.left=pre;
        return head;
    }

    public void dfs(Node root){
        if(root!=null){
            treeToDoublyList(root.left);
            if(pre==null){//第一次操作的节点就是头节点
                head=root;
            }else{
                root.left=pre;
                pre.right=root;               
            }
            pre=root;
            treeToDoublyList(root.right);
        }
    }
}
```

---

#### [面试题38. 字符串的排列](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)

输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

**示例:**

```
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
```

**思路和代码：**

回溯法

![](https://img-blog.csdnimg.cn/20200511134127645.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

```java
class Solution {

    List<String> list=new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return list.toArray(new String[0]);
    }

    public void dfs(int n){
        if(n==c.length-1){
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for(int i=n;i<c.length;i++){
            if(set.contains(c[i]))
                continue;
            set.add(c[i]);
            swap(n,i);
            dfs(n+1);
            swap(n,i);//还原字符
        }

    }

    //交换两个位置的字符
    public void swap(int a,int b){
        char temp=c[a];
        c[a]=c[b];
        c[b]=temp;
    }
}
```



---

#### [面试题39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1:**

```
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

**思路和代码：**

![](https://img-blog.csdnimg.cn/2020051020050436.png)

使用投票算法，当票数为0就改变leader，由于这个数字超过了一半，所以最后leader结果一定是它。

```java
class Solution {

    public int majorityElement(int[] nums) {
        int leader=0;
        int count=0;
        for(int num:nums){
            if(count==0)//如果票数为0，证明没有leader，让当前数字当leader
                leader=num;
            count+=num==leader?1:-1;//当前数字和leader一样，票数加1，否则减1
        }
        return leader;
    }
}
```

---

#### [面试题40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

**示例 1：**

```
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
```

**示例 2：**

```
输入：arr = [0,1,2,1], k = 1
输出：[0]
```

**思路和代码：**

利用快速排序的思想，返回的索引`index`的左边0~index-1对应的数字共index个都比index对应的值小，右边都比index对应的值大，所以只要让返回的索引index=k即可。

如果返回的索引index小于k，那么以index+1对应的值为基准值继续排序，如果index大于k，则以index-1对应的值继续排序。

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==k)
            return arr;
        help(arr,0,arr.length-1,k);
        //复制前k个数作为结果
        return Arrays.copyOf(arr,k);
    }

    //当index=k时，索引0~k-1都比k对应的值小，此时前k个数肯定是最小的
    public void help(int[] arr,int low,int high,int k){
        int index=getPivotIndex(arr,low,high);
        if(index!=k){
            if(index<k)//前index个已经排好，还要从index+1开始继续排
                help(arr,index+1,high,k);
            else//超过了k个，index左边的都小于index，所以排除掉index，从index-1继续排
                help(arr,low,index-1,k);
        }
    }

    private int getPivotIndex(int[] arr, int start, int end) {
        //默认选择第一个作为基准
        int pivot=arr[start];
        int i=start;
        int j=end;
        while(i<j){//循环条件
            //从左起找到第一个大于pivot的元素
            while (i<=j&&arr[i]<=pivot)
                i++;
            //从右起找到第一个小于等于pivot的元素
            while (i<=j&&arr[j]>pivot)
                j--;
            //如果左边元素大于右边则交换
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,start,j);
        return j;
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
```

**简单做法：**

```java
    public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
        //复制前k个数作为结果
        return Arrays.copyOf(arr,k);
    }
```

---

#### [面试题42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

**示例1:**

```
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

**提示：**

- `1 <= arr.length <= 10^5`
- `-100 <= arr[i] <= 100`

**思路和代码：**

使用一个变量保存最大值，一个变量保存临时和。

![](https://img-blog.csdnimg.cn/20200510204554712.png)

```java
class Solution {

    public int maxSubArray(int[] nums) {
        int max=nums[0];//保存最大和
        int temp=nums[0];//保存临时和
        for(int i=1;i<nums.length;i++){
            if(temp<0)
                temp=nums[i];
            else
                temp+=nums[i];
            if(temp>max)
                max=temp;
        }
        return max;
    }
}
```

---

#### [面试题43. 1～n整数中1出现的次数](https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/)

难度中等29

输入一个整数 `n` ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

 

**示例 1：**

```
输入：n = 12
输出：5
```

**示例 2：**

```
输入：n = 13
输出：6
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200511142811729.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom: 80%;" />

```java
class Solution {
    public int countDigitOne(int n) {
        return hasOne(n);
    }

    public int hasOne(int n){
        if(n==0)
            return 0;
        //将数字转为字符串
        String number=String.valueOf(n);
        //获取最高位
        int high=number.charAt(0)-'0';
        //获取最接近的100..00
        int pow=(int)(Math.pow(10,number.length()-1));
        //获取剩余数字
        int left=n-high*pow;
        if(high==1)
            return hasOne(pow-1)+left+1+hasOne(left);
        else
            return pow+high*hasOne(pow-1)+hasOne(left);
    }
}
```

---

#### [面试题45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

**示例 1:**

```
输入: [10,2]
输出: "102"
```

**示例 2:**

```
输入: [3,30,34,5,9]
输出: "3033459"
```

**思路和代码：**

String数组的排序规则是对x插入y，如果x+y<y+x，就排成xy否则排成yx。比较时是从左至右比较不同的第一位。

例如10，插入2，102肯定小于210，因此排成102。

例如3，30，34，5，9，首先插入3，30+3小于3+30，因此此时为303，插入34，303的第二位是0，因此此时是30334，插入5，此时第一位3<5，因此排成303345，接着排成303349。

```java
class Solution {

	public String minNumber(int[] nums) {
        //先将int数组转为String数组
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i]= String.valueOf(nums[i]);
        //对String数组排序
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for(String str:strs)
            sb.append(str);
        return sb.toString();
    }

}
```

---

#### [面试题46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

**示例 1:**

```
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```

**思路和代码：**

动态规划，首先将int转为String字符串，再转为char数组。

由于递推关系涉及到前两个，防止越界，所以dp数组要比char数组长度大1。

dp[0]是初始化条件，dp[1]代表的是char[0]的翻译方法数，一个字符当然只有一种。

从dp[2]开始动态规划，也就是从字符串第二位开始。

由于每一位都可以单独组成一个字符，所以dp[i]=dp[i-1]，例如123的方法数肯定等于12的方法数，因为3单独组成一个。

之后判断能否和前一位组成1~25的数字，如果可以就要加上前2位的方法数，例如123的方法数要加上1的方法数，因为23可以组合成一个。

所以dp(i)的初始值就是dp(i-1)，然后判断和前一位能否组成2位数，可以再加上dp(i-2)。

注意dp比chars长度大一，所以dp[i]对应的是chars[i-1]。

```java
class Solution {

    public int translateNum(int num) {
        char[] chars=String.valueOf(num).toCharArray();
        int[] dp=new int[chars.length+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1];
            if(chars[i-2]=='1'||(chars[i-2]=='2'&&chars[i-1]<='5'))
                dp[i]+=dp[i-2];
        }
        return dp[dp.length-1];
    }

}
```

---

#### [面试题47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

**示例 1:**

```
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200511102222972.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    public int maxValue(int[][] grid) {
        for(int i=1;i<grid.length;i++)
            grid[i][0]+=grid[i-1][0];
        for(int i=1;i<grid[0].length;i++)
            grid[0][i]+=grid[0][i-1];
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
```

---

#### [面试题48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200511103926805.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int start=0,end=0;end<s.length();end++){
            char c=s.charAt(end);
            if(map.containsKey(c))
                start=Math.max(start,map.get(c));
            len=Math.max(len,end-start+1);
            map.put(c,end+1);
        }
        return len;
    }
}
```

---

#### [面试题49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

**示例:**

```
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

**说明:** 

1. `1` 是丑数。
2. `n` **不超过**1690。

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200511003525221.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public int nthUglyNumber(int n) {
        int a=0;
        int b=0;
        int c=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int n1=dp[a]*2;
            int n2=dp[b]*3;
            int n3=dp[c]*5;
            int min=Math.min(n1,Math.min(n2,n3));
            dp[i]=min;
            if(n1==min)
                a++;
            if(n2==min)
                b++;
            if(n3==min)
                c++;
        }
        return dp[n-1];
    }
}
```

---

#### [面试题50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

**示例:**

```
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
```

思路和代码：

使用一个HashMap，如果是第一次出现，就将字符放入map，并设置值为true。如果不是第一次出现（已经存在于map）就把值改为false。

之后遍历字符串，找到第一个对应值为true的字符，表示是第一个出现一次的字符。

```java
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c))
                map.put(c,false);
            else
                map.put(c,true);
        }
        for(char c:s.toCharArray()){
            if(map.get(c))
                return c;
        }
        return ' ';
    }
}
```

---

#### [面试题52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

输入两个链表，找出它们的第一个公共节点。

如下面的两个链表**：**

[<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" alt="img" style="zoom:67%;" />](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

 

**示例 1：**

[<img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png" alt="img" style="zoom:67%;" />](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

**思路和代码：**

相交前的距离设为S1和S2，S1和S2可能相等也可能不等，相交后直到null的距离设为x，让p和q分别从A和B开始走，如果遍历到空就分别指向B和A，这样p和q相遇时走的距离都是S1+x+S2，p走了S1+x相当于走完了链表A，又走了S2就是相交距离，同理q走了S2+x就相当于走完了链表B，又走了S1就是相交距离。

<img src="https://img-blog.csdnimg.cn/20200510153830277.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA;
        ListNode q=headB;
        while(p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }
        return p;
    }
}
```

---

#### [面试题53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

统计一个数字在排序数组中出现的次数。

**示例 1:**

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```

**示例 2:**

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```

**限制：**

```
0 <= 数组长度 <= 50000
```

**思路和代码：**

利用二分查找找到等于目标值的元素索引，找到左边第一个不为该元素的索引，找到右边第一个不为该元素的索引，然后右索引-左索引-1即为长度。

```java
class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<target)
                start=mid+1;
            else if(nums[mid]>target)
                end=mid-1;
            else{
                //找到了该数字
                int left=mid;
                int right=mid;              
                while(left>=0&&nums[left]==target)//从该位置向左查找
                    left--;              
                while(right<nums.length&&nums[right]==target)//从该位置向右查找
                    right++;
                return right-left-1;
            }
        }
        return 0;
    }
}
```

---

#### [面试题53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

**示例 1:**

```
输入: [0,1,3]
输出: 2
```

**示例 2:**

```
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```

思路和代码：

由于长度为n-1并且数字范围也是0~n-1，对数组进行排序，如果索引对应的值不等于索引，那么说明该数字缺失了。如果全部都对应，那么说明n-1缺失了。

```java
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)
                return i;
        }
        return nums.length;
    }
}
```

---

#### [面试题54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

给定一棵二叉搜索树，请找出其中第k大的节点。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

**示例 2:**

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
```

思路和代码：

由于是二叉搜索树，可以按照中序遍历保存其升序结果。然后倒数第k个就是第k大的。

```java
class Solution {

    List<Integer> list=new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size()-k);
    }

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
```

----

#### [面试题55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 `[3,9,20,null,null,15,7]`，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。

**思路和代码：**

比较简单，利用后序遍历先计算左右子树的高度，取大值返回。

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int hL=maxDepth(root.left);
        int hR=maxDepth(root.right);
        return Math.max(hL,hR)+1;
    }
}
```

---

#### [面试题55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

**示例 1:**

给定二叉树 `[3,9,20,null,null,15,7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

**示例 2:**

给定二叉树 `[1,2,2,3,3,null,null,4,4]`

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

返回 `false` 。

**思路和代码：**

可以利用上一题计算二叉树深度的方法作为辅助方法，求出左右子树的高度，如果相差大于1则不是平衡二叉树，否则判断左右子树，如果左右子树都是平衡二叉树则平衡。

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)//空树是平衡二叉树
            return true;
        int dL=maxDepth(root.left);
        int dR=maxDepth(root.right);
        if(Math.abs(dL-dR)>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int hL=maxDepth(root.left);
        int hR=maxDepth(root.right);
        return Math.max(hL,hR)+1;
    }
}
```

---

#### [面试题56 - I. 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

一个整型数组 `nums` 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

**示例 1：**

```
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
```

**示例 2：**

```
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
```

**思路和代码：**

![](https://img-blog.csdnimg.cn/20200511122537218.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70)

```java
class Solution {

    public int[] singleNumbers(int[] nums) {
        int x=nums[0];
        for(int i=1;i<nums.length;i++)
            x=x^nums[i];
        int p=x&(-x);//最低1位那个分界数字
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            if((nums[i]&p)==1)
                arr[0]^=nums[i];
            else
                arr[1]^=nums[i];
        }
        return arr;
    }
}
```

---

#### [面试题56 - II. 数组中数字出现的次数 II](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

在一个数组 `nums` 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

**示例 1：**

```
输入：nums = [3,4,3,3]
输出：4
```

**示例 2：**

```
输入：nums = [9,1,7,9,7,9,7]
输出：1
```

**思路和代码：**

使用一个HashMap，键是每个数字，value是一个boolean值，如果是第一次放入就设为true，否则就设为false。

```java
class Solution {
	public int singleNumber(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n))
                map.put(n,false);
            else
                map.put(n,true);
        }
        Set<Integer> integers = map.keySet();
        for(int i:integers){
            if(map.get(i))
                return i;
        }
        return -1;
    }

}
```

---

#### [面试题57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

**示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```

**示例 2：**

```
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

思路和代码：

根据数组有序的特点利用双指针，如果和比目标大，将尾指针前移，和比目标小将头指针后移，找到就返回。

```java
class Solution {

    public int[] twoSum(int[] nums, int target) {
        int p=0;
        int q=nums.length-1;
        while(p<q){
            int sum=nums[p]+nums[q];
            if(sum>target)
                q--;
            else if(sum<target)
                p++;
            else
                return new int[]{nums[p],nums[q]};
        }
        return new int[2];
    }
}
```

---

#### [面试题57 - II. 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

输入一个正整数 `target` ，输出所有和为 `target` 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

**示例 1：**

```
输入：target = 9
输出：[[2,3,4],[4,5]]
```

**示例 2：**

```
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
```

**思路和代码：**

利用求和公式来计算和，使用双指针，初始头指针1，尾指针2，如果和小于目标，将尾指针后移。

如果和大于目标，将头指针后移，如果头指针超过了尾指针就终止。

如果和等于目标创建一个数组，长度是尾指针-头指针+1，然后将start开始的数组长度个数赋值给数组。之后将数组添加到结果集。

最后将list转为int数组。

```java
class Solution {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int start=1;
        int end=2;
        while(start<end){
            int sum=(start+end)*(end-start+1)/2;
            if(sum<target)
                end++;
            else if(sum>target)
                start++;
            else{
                int[] temp=new int[end-start+1];
                int num=start;
                for(int i=0;i<temp.length;i++)
                    temp[i]=num++;
                res.add(temp);
                start++;
                end++;
            }
        }
        int[][] result=new int[res.size()][];
        for(int i=0;i<result.length;i++)
            result[i]=res.get(i);
        return result;
    }
}
```

---

#### [面试题58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

**示例 1：**

```
输入: "the sky is blue"
输出: "blue is sky the"
```

**示例 2：**

```
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

**示例 3：**

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

**思路和代码：**

利用双指针，首先去掉首尾空格。

让j总是指向单词的末尾，i指向单词的起始位置的前一个。

这样i就是空格，i+1~j就是单词，因此substring(i+1,+1)就是单词子串。

```java
class Solution {

    public String reverseWords(String s) {
        s=s.trim();
        int j=s.length()-1;
        int i=j;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            //从后向前找到第一个空格，此时i为空格，i+1为单词起始位置
            while(i>=0&&s.charAt(i)!=' ')
                i--;
            //将i+1~j子串添加到结果，substring第二个参数是不想复制的第一个位置
            sb.append(s.substring(i+1,j+1)+" ");
            //此时跳过空格找到下一个单词的末尾
            while(i>=0&&s.charAt(i)==' ')
                i--;
            j=i;//让j继续指向单词末尾
        }
        return sb.toString().trim();
    }


}
```

---

#### [面试题58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

**示例 1：**

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

**示例 2：**

```
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

**思路和代码：**

比较简单，就是把索引n开始的字符串作为头拼上索引0~n-1的字符串作为尾。

注意substring(n)表示截取n开始到末尾的字符串，substring(m,n)表示截取m到n-1的字符串。

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
```

---

#### [面试题59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)

请定义一个队列并实现函数 `max_value` 得到队列里的最大值，要求函数`max_value`、`push_back` 和 `pop_front` 的**均摊**时间复杂度都是O(1)。

若队列为空，`pop_front` 和 `max_value` 需要返回 -1

**示例 1：**

```
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
```

**示例 2：**

```
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
```

**思路和代码：**

使用两个双端队列。

```java
class MaxQueue {

    LinkedList<Integer> l1=new LinkedList<>();
    LinkedList<Integer> l2=new LinkedList<>();

    public MaxQueue() {

    }
    
    //l2不为空就返回队首，否则-1
    public int max_value() {
        return l2.isEmpty()?-1:l2.peekFirst();
    }
    //入队时l1正常操作，l2要把队尾小于value的移除掉，然后入队
    public void push_back(int value) {
        l1.add(value);
        while(!l2.isEmpty()&&l2.peekLast()<value)
            l2.pollLast();
        l2.add(value);
    }
    
    //出队时l1正常操作，l2的队首=l1的队首才出队
    public int pop_front() {
        int temp=l1.isEmpty()?-1:l1.pollFirst();
        if(!l2.isEmpty()&&temp==l2.peekFirst())
            l2.pollFirst();
        return temp;
    }
}
```

---

#### [面试题61. 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

**示例 1:**

```
输入: [1,2,3,4,5]
输出: True
```

**示例 2:**

```
输入: [0,0,1,2,5]
输出: True
```

**思路和代码：**

首先对数组进行排序，然后定义一个变量joker表示大小王的数量。

因为是顺子，必须5张全部不一样，除非一样的是大小王，否则无法凑成顺子。

例如12300可以凑成顺子，因为大小王可以当作45，但是12344就不行了。

因此如果一个数字不是0，即不是大小王，它又和后面的数字一样，肯定就不能凑成顺子。

有几个大小王，joker就是几，例如00125，joker=2，此时不为大小王的起始索引也是2，判断最大元素减去不为大小王的元素，如果小于5，就可以凑成顺子。

例如00125中，5-1小于5，可以凑成顺子，因为125已经占据了3个，大小王占据了2个。

12345中也可以，5-1小于5，并且本来就是五个不同的。

01236就不可以，因为6-1等于5，无法凑成顺子。

```java
class Solution {
    public boolean isStraight(int[] nums) {
        int joker=0;
        Arrays.sort(nums);
        int i=0;
        for(i=0;i<4;i++){
            if(nums[i]==0)
                joker++;
            else if(nums[i]==nums[i+1])
                return false;
        }
        return nums[4]-nums[joker]<5;
    }
}
```

---

#### [面试题62. 圆圈中最后剩下的数字](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

**示例 1：**

```
输入: n = 5, m = 3
输出: 3
```

**示例 2：**

```
输入: n = 10, m = 17
输出: 2
```

**思路和代码：**

<img src="https://img-blog.csdnimg.cn/20200510215534483.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public int lastRemaining(int n, int m) {
        int res=0;
        for(int i=2;i<=n;i++)
            res=(res+m)%i;
        return res;
    }
}
```

---

#### [面试题63. 股票的最大利润](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/)

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
```

**示例 2:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

**思路和代码：**

实时更新最大利润和最小买入价格。

```java
class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int max=0;//第一天只能买，没有利润
        int minBuy=prices[0];//此时最低买入价就是第一天的买入价
        //第二天开始才可以卖股票
        for(int i=1;i<prices.length;i++){
            //如果此时卖出可以大于最大利润就更新最大利润
            if(prices[i]-minBuy>max)
                max=prices[i]-minBuy;
            //如果此时价格小于最小买入价格就更新买入价
            if(prices[i]<minBuy)
                minBuy=prices[i];
        }
        return max;
    }
}
```

---

#### [面试题64. 求1+2+…+n](https://leetcode-cn.com/problems/qiu-12n-lcof/)

难度中等64

求 `1+2+...+n` ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

**示例 1：**

```
输入: n = 3
输出: 6
```

**示例 2：**

```
输入: n = 9
输出: 45
```

**思路和代码：**

使用短路与（&&）的前半部分来进行循环判断，如果n==1了就不累加了，直接返回n。

如果n>1，就将n累加上n-1的值再返回，第二个布尔表达式的后半部分（”==0“）可以随便写，只要前面是对n累加即可。

```java
class Solution {

    public int sumNums(int n) {
        boolean b=(n>1)&&(n+=sumNums(n-1))==0;
        return n;
    }

}
```

---

#### [面试题65. 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

**示例:**

```
输入: a = 1, b = 1
输出: 2
```

**思路和代码：**

将a+b的和拆分为非进位和（异或运算）和进位（与运算）。

计算出进位要左移一位，例如0010和0010的与结果还是0010但进位是0100，要左移一位。

```java
class Solution {
    public int add(int a, int b) {
        while(b!=0){//进位不为0
            int c=(a&b)<<1;//计算进位
            a^=b;//计算无进位和
            b=c;//更新进位
        }
        return a;
    }
}
```

---

#### [面试题66. 构建乘积数组](https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/)

给定一个数组 `A[0,1,…,n-1]`，请构建一个数组 `B[0,1,…,n-1]`，其中 `B` 中的元素 `B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]`。不能使用除法。

**示例:**

```
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
```

**提示：**

- 所有元素乘积之和不会溢出 32 位整数
- `a.length <= 100000`

思路和代码：

先正着乘，保存自己以左的元素乘积，再反着乘一次，乘上自己以右的元素乘积。

<img src="https://img-blog.csdnimg.cn/20200510211807224.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxMTEyMjM4,size_16,color_FFFFFF,t_70" style="zoom:67%;" />

```java
class Solution {
    public int[] constructArr(int[] a) {
        int[] b=new int[a.length];
        for(int i=0,n=1;i<b.length;i++){
            b[i]=n;
            n*=a[i];
        }
        for(int i=b.length-1,n=1;i>=0;i--){
            b[i]*=n;
            n*=a[i];
        }
        return b;
    }
}
```

---

#### [面试题67. 把字符串转换成整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)

写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

**说明：**

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

**示例 1:**

```
输入: "42"
输出: 42
```

**示例 2:**

```
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
```

**示例 3:**

```
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
```

**示例 4:**

```
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
```

**示例 5:**

```
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
```

**思路和代码：**

首先去掉空格，转为字符数组，如果此时字符数组长度已为0，直接返回0。

然后使用boolean遍历标识正负值，如果是负号就设为false，如果不是正号就代表第一个字符不是正负号，从第一个字符开始计算。

使用long类型变量保存临时结果，一旦超过Int范围就返回int的最大值或最小值。

```java
class Solution {
    public int strToInt(String str) {
        //去掉空格
        char[] chars=str.trim().toCharArray();
        //去掉空格后长度0
        if(chars.length==0)
            return 0;
        //标识正负数
        boolean positive=true;
        int start=1;
        //第一个是减号，从第二个开始，如果第一个不是减号也不是加号，从第一个开始
        if(chars[0]=='-')
            positive=false;
        else if(chars[0]!='+')
            start=0;
        long res=0;//用long类型保存结果防止int越界
        for(int i=start;i<chars.length;i++){
            if(chars[i]<'0'||chars[i]>'9')//遇到非数字结束
                break;
            res=res*10+(chars[i]-'0');
            if(res>Integer.MAX_VALUE)//如果越界根据正负号返回结果
                return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return positive?(int)res:(int)-res;
    }
}
```

---

#### [面试题68 - I. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/最近公共祖先/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png)

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

**示例 2:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

**说明:**

- 所有节点的值都是唯一的。
- p、q 为不同节点且均存在于给定的二叉搜索树中。

**思路和代码：**

利用二叉搜索树的性质可以很简单地解决问题，在二叉搜索树中，所有左节点的值都比当前节点值小，所有右节点的值都比当前节点值大。

由于按照先序遍历（根-左-右）的顺序进行dfs（深度优先查找），而一个节点本身也是自己的祖先节点，如果当前节点就是p或q，那么直接返回。

如果p和q的值都比当前节点值小，说明它们都在左子树，所以递归在左子树继续寻找祖先节点。

如果p和q的值都比当前节点值大，说明它们都在右子树，所以递归在右子树继续寻找祖先节点。

如果p和q一个值比当前节点小，一个值比当前节点大，那么说明它们分别在当前节点的左右子树，那么它们的祖先节点只能是当前节点。

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        if(p.val<root.val&&q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
```

---

#### [面试题68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

[百度百科](https://baike.baidu.com/item/最近公共祖先/8918834?fr=aladdin)中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png)

**示例 1:**

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
```

**示例 2:**

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
```

**说明:**

- 所有节点的值都是唯一的。
- p、q 为不同节点且均存在于给定的二叉树中。

**思路和代码：**

利用一个辅助方法来判断当前节点是否是p或q其中一个的祖先节点，如果是则返回true，不是则返回false，方法中利用了一个局部变量sum来计算当前节点可以作为祖先节点的次数，如果sum为0表示当前节点既不是p也不是q的祖先节点，如果sum为1表示它是其中一个节点的祖先节点，如果sum为2表示它既是p也是q的祖先节点，此时将root的值赋给全局变量ancestor，即我们要求的节点。

```java
class Solution {
    TreeNode ancestor=null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isAncestor(root,p,q);
        return ancestor;    
    }

    public boolean isAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return false;
        int sum=0;
        //判断当前节点是否是p或q，因为自己也是自己的祖先节点
        sum+=(root==p||root==q)?1:0;
        //判断当前节点的左节点是否是p或q的祖先节点，左节点是自己肯定也是
        sum+=isAncestor(root.left,p,q)?1:0;
        //右节点同理
        sum+=isAncestor(root.right,p,q)?1:0;
        if(sum==2)
            ancestor=root;
        return sum>0;
    }
}
```

---

