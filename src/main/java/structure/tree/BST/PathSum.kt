package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */

class PathSum {

    class Solution {
        fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
            return traversal(root, sum, 0)
        }

        fun traversal(root: TreeNode?, targetNum:Int, currNum:Int):Boolean{

            if(root == null){
                return false
            }


            var num = root.`val` + currNum
            if(num == targetNum && root.left == null && root.right == null){
                return true
            }
            var leftHasPathSum = traversal(root.left, targetNum, num )
            var rightHasPathSum = traversal(root.right, targetNum, num )

            return leftHasPathSum || rightHasPathSum
        }
    }
}