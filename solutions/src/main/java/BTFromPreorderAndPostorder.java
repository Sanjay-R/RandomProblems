import java.util.Arrays;

public class BTFromPreorderAndPostorder {

    // LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // https://www.javatpoint.com/discrete-mathematics-traversing-binary-trees

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder.length == 1) {
                return new TreeNode(inorder[0]);
            }

            return divide(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode divide(int[] pre, int[] in) {
            switch (pre.length) {
                case 0:
                    return null; //NULL WAS IMPORTANT HERE!!!
                case 1:
                    return new TreeNode(pre[0]);
                case 2:
                    TreeNode root2 = new TreeNode(pre[0]);
                    //only a root and a right side
                    if (pre[0] == in[0]) {
                        root2.right = new TreeNode(in[1]);
                    } else {
                        root2.left = new TreeNode(in[0]);
                    }
                    return root2;
                default:
                    //create root
                    TreeNode root = new TreeNode(pre[0]);

                    int pointer = root.val; // == pre[0]
                    int iter = 0;
                    while(pointer != in[iter] && iter <= in.length) {
                        iter++;
                    }

                    //create arrays for left side
                    int[] pre2 = Arrays.copyOfRange(pre, 1, (iter + 1));
                    int[] in2 = Arrays.copyOfRange(in, 0, iter);
                    assert (pre2.length == in2.length);
                    root.left = divide(pre2, in2);

                    //create arrays for right side
                    int[] pre3 = Arrays.copyOfRange(pre, (iter + 1), pre.length);
                    int[] in3 = Arrays.copyOfRange(in, (iter + 1), in.length);
                    root.right = divide(pre3, in3);
                    return root;
            }
        }

        // This one does not work
        public TreeNode divide(int[] pre, int[] in, int l, int r, int l_in, int r_in) {
            if (l > r) {
                //case of no nodes left
                return null;
            } else if (l == r && l > 0) {
                //case of a single node left
                return new TreeNode(pre[l]);
            } else if (l + 1 == r) {
                //case of two nodes left
                TreeNode root = new TreeNode(pre[l]);
                //check if there is only a root and a right side
                if(pre[l] == in[l_in]) {
                    root.right = new TreeNode(in[r_in]);
                } else {
                    root.left = new TreeNode(in[l_in]);
                }
                return root;
            } else {
                //default case
                //create root
                TreeNode root = new TreeNode(pre[l]);

                int pointerVal = root.val; // == pre[l]
                int iter = l_in;
                while(pointerVal != in[iter] && iter <= r_in) {
                    iter++;
                }

                //conquer on each side
                root.left = divide(pre, in, (l + 1), iter, l_in, (iter - 1));
                root.right = divide(pre, in, (iter + 1), r, (iter + 1), r_in);
                return root;
            }
        }
    }
}

//[3,9,20,15,7]
//[9,3,15,20,7]