# Tree

## 遍历

前序遍历 PreOrderTraversal  
    - 根左右
中序遍历 InorderTraversal
    - 左根右
后序遍历 postOrderTraversal  
    - 左右根
层次遍历  
    - 层级遍历

## 二叉搜索树

- 任意一个节点的值都大于左子树所有结点的值
- 任意一个节点的值都小于右子树所有节点的值
- 他的左右子树也是一颗二叉搜索树
- 二叉搜索树可以大大提高搜索数据的效率
- 元素必须剧有可比较性

### 接口设计

int size() //元素的数量  
boolean isEmpty() //是否为空  
void clear() //清空所有元素  
void add(E element) //添加元素  
void remove(E element) //删除元素  
boolean contains(E element )//是否包含元素  

- 元素没有索引的概念

## AVL 树

- 平衡因子(Balance Factor)：某节点的左右子树高度
- AVL树的特点
    - 每个节点的平衡因子只可能是1、0、-1(绝对值<=1，如果超过1，称之为 "失衡")
    - 每个节点的左右子树高度差不超过1
    - 搜索添加删除的时间复杂度是O(Logn)
    