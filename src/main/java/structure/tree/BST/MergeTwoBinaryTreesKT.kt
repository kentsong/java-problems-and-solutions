package structure.tree.BST

class MergeTwoBinaryTreesKT {

    internal inner class Solution {
        fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {

            val mergeNote : TreeNode = when {
                t1 == null && t2 == null -> return null
                t1 != null && t2 != null -> TreeNode(t1.`val` + t2.`val`)
                t1 == null -> TreeNode(t2!!.`val`)
                else -> TreeNode(t1.`val`)
            }

            mergeNote.left = mergeTrees(t1?.left, t2?.left)
            mergeNote.right = mergeTrees(t1?.right, t2?.right)
            return mergeNote
        }

    }

    inner class TreeNode internal constructor(internal var `val`: Int) {
        internal var left: TreeNode? = null
        internal var right: TreeNode? = null
    }

}