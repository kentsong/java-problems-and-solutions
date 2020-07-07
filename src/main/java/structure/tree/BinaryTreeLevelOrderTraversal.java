package structure.tree;

import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * <p>
     * DFS 遍历使用递归：
     * void dfs(TreeNode root) {
     * if (root == null) {
     * return;
     * }
     * dfs(root.left);
     * dfs(root.right);
     * }
     * <p>
     * BFS 遍历使用队列数据结构：
     * void bfs(TreeNode root) {
     * Queue<TreeNode> queue = new ArrayDeque<>();
     * queue.add(root);
     * while (!queue.isEmpty()) {
     * TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
     * if (node.left != null) {
     * queue.add(node.left);
     * }
     * if (node.right != null) {
     * queue.add(node.right);
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        DFS_Solution(); // 深度优先
//        BFS_Solution(); // 广度优先
    }

    public static List<List<Integer>> DFS_Solution() {
        TreeNode root = genInput();
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        System.out.println(new Gson().toJson(res));
        return res;
    }

    static void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }

    private static void BFS_Solution(){
        TreeNode root = genInput();
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        System.out.println(new Gson().toJson(res));
    }


    private static TreeNode genInput() {
        TreeNode rootNode = new TreeNode(3);

        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        node1.left = new TreeNode(1);

        node2.left = new TreeNode(15);
        node2.right = new TreeNode(7);

        rootNode.left = node1;
        rootNode.right = node2;
        return rootNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
