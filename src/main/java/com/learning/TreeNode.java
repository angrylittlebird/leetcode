package com.learning;

import java.util.List;

/**
 * @Author: ZHANG
 * @Date: 2020/7/19
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(List<Integer> list) {
        for (Integer integer : list) {

        }
    }

    /*
               1
            2      3
          7      4    5
                     6
     */

    public TreeNode build() {
        TreeNode root = this;
        root.val = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.left.left = new TreeNode(7);
        return this;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
