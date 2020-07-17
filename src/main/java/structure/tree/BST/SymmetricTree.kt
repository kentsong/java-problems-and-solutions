package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */

class SymmetricTree {

    class Solution {
        fun isSymmetric(root: TreeNode?): Boolean {

            if (root == null) {
                return true
            }

            if (root.left?.`val` != root.right?.`val`) {
                return false
            }

            return isSymmetric(root.left, root.right)
        }

        fun isSymmetric(node1: TreeNode?, node2: TreeNode?): Boolean {

            if(node1 == null && node2 == null){
                return true
            }

            if(node1?.left?.`val` != node2?.right?.`val`){
                return false
            }

            if(node1?.right?.`val` !=node2?.left?.`val` ){
                return false
            }

            return true && isSymmetric(node1?.left, node2?.right) && isSymmetric(node1?.right, node2?.left)
        }


    }
}