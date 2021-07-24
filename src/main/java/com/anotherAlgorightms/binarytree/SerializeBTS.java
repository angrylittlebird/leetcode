package com.anotherAlgorightms.binarytree;

import com.learning.TreeNode;

/**
 * @Author: ZHANG
 * @Date: 2021/7/24
 * @Description: 序列化二叉树：对象->字符串
 * 反序列化二叉树： 字符串 -> 对象
 */
public class SerializeBTS {
    private static StringBuilder sb = new StringBuilder();
    private int index = -1;

    public void serializeBTS(TreeNode root) {
        // using pre-order travel

        sb.append(root == null ? "#" : root.val).append("!");
        if (root == null) return;

        serializeBTS(root.left);
        serializeBTS(root.right);
    }

    public TreeNode deserialize(String string) {
        String[] arr = string.split("!");

        return deserializeHelper(arr);
    }

    private TreeNode deserializeHelper(String[] arr) {
        index++;
        if ("#".equals(arr[index])) {
            return null;
        }

        TreeNode curNode = new TreeNode(Integer.valueOf(arr[index]));
        curNode.left = deserializeHelper(arr);
        curNode.right = deserializeHelper(arr);

        return curNode;
    }

    public static void main(String[] args) {
        SerializeBTS serializeBTS = new SerializeBTS();

    /*
               1
            2      3
          7      4    5
                     6
     */
        serializeBTS.serializeBTS(new TreeNode(1).build());
        System.out.println(sb.toString());

        TreeNode deserialize = serializeBTS.deserialize(sb.toString());
        System.out.println(deserialize);
    }


}
