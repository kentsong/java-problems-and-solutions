package structure.tree.BST

import structure.tree.BST.model.TreeNode
import java.util.*

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */

class BinaryTreeLevelOrderTraversal {

    class Solution {
        fun levelOrder(root: TreeNode?): List<List<Int>> {
            val deepSum = maxDepth(root);
            val list = ArrayList<ArrayList<Int>>()
            for (i in 1..deepSum) {
                list.add(ArrayList())
            }

            traversal(root, list, 0)
            return list
        }

        fun traversal(root: TreeNode?, list: ArrayList<ArrayList<Int>>, deep: Int) {
            if (root == null) {
                return
            }
            list.get(deep).add(root.`val`)
            traversal(root.left, list, deep +1)
            traversal(root.right, list, deep +1)
        }


        fun maxDepth(root: TreeNode?): Int {
            if (root == null) return 0

            var leftMaxDeep = maxDepth(root.left)
            var rightMaxDeep = maxDepth(root.right)

            return 1 + Math.max(leftMaxDeep, rightMaxDeep)
        }
    }
}