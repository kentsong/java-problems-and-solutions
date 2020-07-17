package structure.tree.BST

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
class BinaryTreeDeep {

    internal inner class SolutionA {
        fun maxDepth(root: TreeNode?): Int {
            if(root == null) return 0

            var leftMaxDeep = maxDepth(root.left)
            var rightMaxDeep = maxDepth(root.right)

            return 1 + Math.max(leftMaxDeep, rightMaxDeep)
        }
    }


    inner class TreeNode internal constructor(internal var `val`: Int) {
        internal var left: TreeNode? = null
        internal var right: TreeNode? = null
    }
}