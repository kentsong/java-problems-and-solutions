package structure.tree.BST

import structure.tree.BST.model.TreeNode


/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
class InvertBinaryTree {

    class Solution {
        fun invertTree(root: TreeNode?): TreeNode? {
            if(root == null){
                return root
            }

            var tempNode :TreeNode?
            tempNode = root.left
            root.left = root.right
            root.right = tempNode
            invertTree(root.left)
            invertTree(root.right)
            return root
        }



    }
}