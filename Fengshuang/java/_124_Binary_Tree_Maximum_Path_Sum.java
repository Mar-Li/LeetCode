/**
 * Created by lifengshuang on 8/15/15.
 */
public class _124_Binary_Tree_Maximum_Path_Sum {

    //Definition for a binary tree node.


    private int max;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        recursive(root);
        return max;
    }

    public int recursive(TreeNode root) {
        int left = root.left == null ? 0 : recursive(root.left);
        int right = root.right == null ? 0 : recursive(root.right);
        max = Math.max(max, root.val + left);
        max = Math.max(max, root.val + right);
        max = Math.max(max, root.val + right + left);
        System.out.println(root.val + " " + left + " " + right + "|" + max);
        if (left < 0 && right < 0) {
            return root.val;
        }
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        _124_Binary_Tree_Maximum_Path_Sum test = new _124_Binary_Tree_Maximum_Path_Sum();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(-10);
//        root.left.left = new TreeNode(200);
//        root.left.right = new TreeNode(200);
//        root.right = new TreeNode(3);
//        test.maxPathSum(root);
//        System.out.println(test.max);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
