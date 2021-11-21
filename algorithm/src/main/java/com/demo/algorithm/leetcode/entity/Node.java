package com.demo.algorithm.leetcode.entity;

import java.util.List;

/**
 * Created by chl on 2021/11/21.
 * description : N叉树的结构
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
