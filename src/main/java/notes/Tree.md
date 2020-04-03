# Tree

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
