package leetcode145;

/**
 * 此处整理Morris遍历相关知识
 * Morris遍历是一种遍历二叉树的方式，并且时间复杂度为O(N)，额外空间复杂度O(1）
 * 通过利用树中叶子节点大量空闲指针的方式，以达到节省空间的目的
 * Morris遍历有另外一个学名叫做：线索二叉树
 */

//Morris遍历流程
//        1.开始时cur来到根节点位置：
//
//        2.如果cur有左孩子，找到左子树上最右的节点mostRight
//
//              如果mostRight的右指针指向null，让其指向cur，然后cur向左移动（cur = cur.left）
//              如果mostRight的右指针指向cur，让其指向null，然后cur向右移动（cur = cur.right）
//
//        3.如果cur没有左孩子，cur向右移动（cur = cur.right）
//        4.cur为空时遍历停止


public class Morris {

    //Morris先序遍历
    public static void preMorrisTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode cur = root;
        // 当前节点为空时遍历停止
        while (cur != null) {
            // 如果当前节点有左孩子
            if (cur.left != null) {
                // 找到左子树上最右的节点
                TreeNode mostRight = cur.left;
                // mostRight的right可能还没被改（第一次访问）也可能已经被改了（第二次访问）
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                // 如果mostRight的right指向null（第一次访问cur）
                if (mostRight.right == null) {
                    // 访问第一次时打印
                    System.out.println(cur.val);

                    mostRight.right = cur;
                    cur = cur.left;
                }
                // 如果mostRight的right指向cur（第二次访问cur）
                else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
            // 如果当前节点没有左孩子
            else {
                // 访问时打印
                System.out.println(cur.val);

                cur = cur.right;
            }
        }
    }

    //Morris中序遍历
    public static void inMorrisTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode cur = root;
        // 当前节点为空时遍历停止
        while (cur != null) {

            // 如果当前节点有左孩子
            if (cur.left != null) {
                // 找到左子树上最右的节点
                TreeNode mostRight = cur.left;
                // mostRight的right可能还没被改（第一次访问）也可能已经被改了（第二次访问）
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                // 如果mostRight的right指向null（第一次访问cur）
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                }
                // 如果mostRight的right指向cur（第二次访问cur）
                else {
                    // 访问第二次时打印
                    System.out.println(cur.val);

                    mostRight.right = null;
                    cur = cur.right;
                }
            }
            // 如果当前节点没有左孩子
            else {
                // 访问时打印
                System.out.println(cur.val);

                cur = cur.right;
            }
        }
    }
    public static void postMorrisTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }

        TreeNode cur = root;
        // 当前节点为空时遍历停止
        while (cur != null) {

            // 如果当前节点有左孩子
            if (cur.left != null) {
                // 找到左子树上最右的节点
                TreeNode mostRight = cur.left;
                // mostRight的right可能还没被改（第一次访问）也可能已经被改了（第二次访问）
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                // 如果mostRight的right指向null（第一次访问cur）
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                }
                // 如果mostRight的right指向cur（第二次访问cur）
                else {
                    mostRight.right = null;

                    // 访问第二次时逆序打印左子树的右边界
                    printRightEdge(cur.left);

                    cur = cur.right;
                }
            }
            // 如果当前节点没有左孩子
            else {
                cur = cur.right;
            }
        }

        // 当所有节点遍历完后，逆序打印整棵树的右边界
        printRightEdge(root);
    }

    // 自底向上打印以root为根的树的右边界
    public static void printRightEdge(TreeNode root) {
        // 反转右边界并获取右边界最底部节点
        TreeNode tail = reverseRightEdge(root);

        TreeNode cur = tail;
        while (cur != null) {
            // 打印
            System.out.println(cur.val);

            cur = cur.right;
        }

        // 将右边界反转回去
        reverseRightEdge(tail);
    }

    // 反转以root为根的树的右边界
    public static TreeNode reverseRightEdge(TreeNode root) {
        TreeNode pre = null;
        TreeNode next = null;

        while (root != null) {
            next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }

        return pre;
    }
    
    
    
}
