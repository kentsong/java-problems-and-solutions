package structure.tree.BST

import com.sun.tools.javac.tree.TreeInfo

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

    本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */

class BalancedBinaryTree {

    //自顶向下
    internal inner class SolutionA {
        fun isBalanced(root: TreeNode?): Boolean {
            if(root == null) return true
            return Math.abs(height(root.left) - height(root.right)) < 2
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }

        fun height(node:TreeNode?):Int{
            if (node == null ) return -1 //对冲先给予的1 如果 node 是 null，对冲后变0
            return 1 + Math.max(height(node.left), height(node.right))
        }
    }

    inner class TreeNode internal constructor(internal var `val`: Int) {
        internal var left: TreeNode? = null
        internal var right: TreeNode? = null
    }

    //自底向上，性能较佳
    inner class SolutionB {
        fun isBalanced(root: TreeNode?): Boolean {
            var result:TreeInfo = isBalancedTreeHelper(root)
            return result.balanced
        }

        fun isBalancedTreeHelper(root:TreeNode?): TreeInfo {
            // An empty tree is balanced and has height = -1
            if (root == null) {
                return TreeInfo(-1, true);
            }
            // Check subtrees to see if they are balanced.
            var left = isBalancedTreeHelper(root.left);
            if (!left.balanced) {
                return TreeInfo(-1, false);
            }
            var right = isBalancedTreeHelper(root.right);
            if (!right.balanced) {
                return TreeInfo(-1, false);
            }
            // Use the height obtained from the recursive calls to
            // determine if the current node is also balanced.
            if (Math.abs(left.height - right.height) < 2) {
                return TreeInfo(Math.max(left.height, right.height) + 1, true);
            }
            return TreeInfo(-1, false);
        }
    }

    inner class TreeInfo constructor(height :Int, balanced:Boolean) {
        val balanced: Boolean = balanced
        val height:Int = height
    }
}