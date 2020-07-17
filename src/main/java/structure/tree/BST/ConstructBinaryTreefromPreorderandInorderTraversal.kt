package structure.tree.BST

import structure.tree.BST.model.TreeNode

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * ttps://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class ConstructBinaryTreefromPreorderandInorderTraversal {

    class Solution {
        var map = HashMap<Int, Int>()
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            //将前序列索引放置到map中
            for ((index, value) in inorder.withIndex()) {
                map.put(value, index)
            }
            return myBuildTree(preorder, inorder, 0, preorder.size -1, 0, preorder.size -1)
        }

        fun myBuildTree(preorder: IntArray, inorder: IntArray,
                        preorder_left: Int, preorder_right: Int, inorder_left: Int, inorder_right: Int): TreeNode? {

            if(preorder_left > preorder_right){
                return null
            }

            // 前序遍历中的第一个节点就是根节点
            val preorder_root = preorder_left
            // 在中序遍历中定位根节点
            val inorder_root = map.get(preorder[preorder_root])

            // 先把根节点建立出来
            val root = TreeNode(preorder[preorder_root])
            // 得到左子树中的节点数目
            val size_left_subtree = inorder_root!! - inorder_left
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root - 1 )
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root + 1, inorder_right)
            return root
        }
    }

}