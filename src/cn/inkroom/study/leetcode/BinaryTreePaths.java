package cn.inkroom.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 墨盒
 * @date 19-4-23
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null)
            value(root, new StringBuilder(), list);

        return list;
    }

    public void value(TreeNode node, StringBuilder builder, List<String> list) {
        builder.append(node.val);
        if (node.left == null && node.right == null) {//叶子节点才算结束一条链
            list.add(builder.toString());
            return;
        }
        if (node.left != null) {
            value(node.left, new StringBuilder(builder).append("->"), list);
        }
        if (node.right != null) {
            value(node.right, new StringBuilder(builder).append("->"), list);
        }
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);

        System.out.println(new BinaryTreePaths().binaryTreePaths(node));

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}