package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */

class BinaryTreeMaximumPathSum {

    class Solution {
        var ans : Int = Int.MIN_VALUE
        fun maxPathSum(root: TreeNode?): Int {
            calculate(root)
            return ans
        }

        fun calculate(root: TreeNode?): Int {
            if(root == null) return 0
            val leftNum = Math.max(0, calculate(root.left))
            val rightNum =  Math.max(0, calculate(root.right))
            var nodeNum = root.`val` + leftNum + rightNum
            ans = Math.max(ans, nodeNum)
            return root.`val` + Math.max(leftNum , rightNum)
        }
    }


}