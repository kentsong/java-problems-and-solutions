package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 563. 二叉树的坡度
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */

class BinaryTreeTilt {
    class Solution {

        var tilt :Int =0
        fun findTilt(root: TreeNode?): Int {
            if (root == null) return 0
            sumTilt(root)
            return tilt
        }

        fun sumTilt(root: TreeNode?) : Int{
            if (root == null) return 0
            val leftNum = sumTilt(root?.left)
            val rightNum = sumTilt(root?.right)
            tilt += Math.abs(leftNum - rightNum)
            return root.`val` + leftNum + rightNum
        }
    }
}