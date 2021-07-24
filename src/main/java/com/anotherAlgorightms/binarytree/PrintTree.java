package com.anotherAlgorightms.binarytree;

import com.learning.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ZHANG
 * @Date: 2021/7/24
 * @Description:
 */
public class PrintTree {
    public void printBTS(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode last = treeNode, nLast = null;

        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            System.out.print(curNode.val + "\t");
            if (curNode.left != null) {
                queue.add(curNode.left);
                nLast = curNode.left;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nLast = curNode.right;
            }

            if (curNode == last) {
                last = nLast;
                System.out.println();
            }
        }
    }
    /*
            1
          2   3
        7    4  5
                  6
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode().build();

        PrintTree printTree = new PrintTree();
        printTree.printBTS(root);

    }
}
