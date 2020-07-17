package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 814. 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
class BinaryTreePruning {

    class Solution {
        fun pruneTree(root: TreeNode?): TreeNode? {
            if (root == null) return root

            cutTree(root)
            return root
        }

        fun cutTree(root: TreeNode?): Boolean {

            if(root == null) return true

            if(root?.left == null && root?.right == null){
                return true
            }

            val isCutLeft = cutTree(root?.left)
            val isCutRight = cutTree(root?.right)

            if(isCutLeft && root?.left?.`val` == 0){
                root?.left = null
            }

            if(isCutRight && root?.right?.`val` == 0){
                root?.right = null
            }

            if(!isCutLeft || !isCutRight){
                //下层其中有1不裁剪
                return false
            }

            if(root?.left?.`val` == 1 || root?.right?.`val` == 1){
                return false
            }
            return true
        }

    }


}