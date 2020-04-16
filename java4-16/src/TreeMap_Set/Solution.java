package TreeMap_Set;


public class Solution {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root = null;

    //查找元素
    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key > cur.key) {
                cur = cur.right;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    //搜索二叉树插入元素
    public boolean insert(int key) {
        if (root == null) {
            // 当前如果为空树, 直接让 root 指向 key 对应的新节点即可.
            root = new Node(key);
            return true;
        }
        // 和查找类似, 需要先找到合适的位置. 再去插入元素
        Node cur = root;
        Node parent = null;  // parent 始终指向 cur 的父节点. 和链表插入类似. 链表插入元素也需要记录指定位置的前一个元素
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 如果当前树村的只是 key, 发现相同的 key 就认为插入失败.
                // 如果当前树存的是键值对, 发现相同的 key 就修改值即可.
                return false;
            }
        }
        // 循环结束的时候, cur 就指向 null, 当前元素就要插入到 parent 的子树位置上.
        // 具体是插到 parent 的左子树还是右子树呢? 就那 key 和 parent 再比较一次就知道了
        if (key < parent.key) {
            // 插入到 parent 的左侧
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    //删除元素
    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                //找到指定元素了
                removeHelp(parent, cur);
                return true;
            }
        }
        return false;
    }

    private void removeHelp(Node parent, Node cur) {
        //cur的左子树为空
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (parent.right == cur) {
                parent.right = cur.left;
            } else {
                parent.left = cur.left;
            }
        } else {
            Node goatParent = cur;
            Node goatchild = cur.right;
            while (goatchild.left != null) {
                goatParent = goatchild;
                goatchild = goatchild.left;
            }
            cur.key = goatchild.key;
            if (goatParent.left == goatchild) {
                goatParent.left = goatchild.right;
            } else {
                goatParent.right = goatchild.right;
            }
        }

    }

    //先序遍历
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] keys = {3, 9, 7, 4, 1, 6, 2, 8, 5};
        for (int x : keys) {
            s.insert(x);
        }
            s.preOrder(s.root);
            System.out.println("先序");
            s.inOrder(s.root);
            System.out.println("中序");
        //查找元素
        System.out.println(s.find(9).key);
        //增加元素
        System.out.println(s.insert(10));
        //删除元素
        System.out.println(s.remove(7));
    }
}
