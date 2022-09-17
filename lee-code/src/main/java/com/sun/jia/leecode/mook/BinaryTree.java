/*
package com.sun.jia.leecode.mook;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    */
/*
     *二叉树最大深度
     *
     * *//*


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    */
/*最小深度*//*

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    */
/**
     * 反转二叉树
     *
     * @param root
     *//*

    public void revertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        revertBinaryTree(root.left);
        revertBinaryTree(root.right);
        swap(root.left, root.right);
    }

    public void swap(TreeNode nodeA, TreeNode nodeB) {

    }


    */
/**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
     *//*

    List<List<Integer>> pathSumRes = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        */
/**//*

        if (root == null) {
            return null;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, temp);
        return pathSumRes;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> rootList) {
        List<Integer> temp = new ArrayList<>(rootList);
        temp.add(root.val);
        */
/*如果是页节点并且满足则添加,添加到列表*//*

        if (root.left == null && root.right == null && targetSum == root.val) {
            pathSumRes.add(temp);
            return;
        }
        if (root.left != null)
            dfs(root.left, targetSum - root.val, temp);
        if (root.right != null)
            dfs(root.right, targetSum - root.val, temp);
    }


    */
/*给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。*//*


    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left ==right){
          return  1<<left+countNodes(root.right)    ;
        }else {
            return 1<<right+countNodes(root.left);
        }

    }
    public int countLevel(TreeNode root){
        int level = 0;
        while (root!=null){
            level++;
            root =root.left;
        }
        return level;
    }

    */
/*给定一个二叉树，判断它是否是高度平衡的二叉树。*//*

    public boolean isBalanced(TreeNode root) {

       if (root!=null&&root.left == null&&root.right == null){
           return true;
       }
       if (root==null){
           return false;
       }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }


    public int height(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    public int countLevelOther(TreeNode root){
        int level = 0;
        while (root!=null){
            level++;
            root = root.left!=null?root.left:root.right;
        }
        return level;
    }


}
*/
