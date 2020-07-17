package structure.tree.BST.model

import structure.tree.BST.BalancedBinaryTree

class TreeNode internal constructor(internal var `val`: Int) {
    internal var left: TreeNode? = null
    internal var right: TreeNode? = null
}