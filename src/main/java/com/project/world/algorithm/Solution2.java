package com.project.world.algorithm;

import java.util.LinkedList;

public class Solution2 {

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int res = 0, sum = 0, floor = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            floor++;//层号
            int size = queue.size();
            int now = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                now += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (now > sum) {
                sum = now;//更新最大层元素和
                res = floor;//更新层号
            }
        }
        return res;
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
