/**
 * Created by lifengshuang on 8/6/15.
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        _236_Lowest_Common_Ancestor_of_a_Binary_Tree test = new _236_Lowest_Common_Ancestor_of_a_Binary_Tree();
        TreeNode root = test.testData();
        System.out.println(test.lowestCommonAncestor(root, root.left, root.left.right.right).val);

    }

    public TreeNode testData() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        return root;
    }

    class SearchResult {
        boolean hasP;
        boolean hasQ;
        TreeNode result;
    }

    public SearchResult mergeResult(SearchResult a, SearchResult b) {
        if (a.result != null) {
            return a;
        }
        if (b.result != null) {
            return b;
        }
        a.hasP |= b.hasP;
        a.hasQ |= b.hasQ;
        return a;
    }

    public SearchResult search(TreeNode root, TreeNode p, TreeNode q) {
        SearchResult left = new SearchResult();
        SearchResult right = new SearchResult();
        if (root.left != null) {
            left = search(root.left, p, q);
        }
        if (root.right != null) {
            right = search(root.right, p, q);
        }
        SearchResult result = mergeResult(left, right);
        if (result.result != null) {
            return result;
        }
        if (result.hasP && result.hasQ) {
            result.result = root;
            return result;
        }
        if (root == p) {
            result.hasP = true;
            if (result.hasQ) {
                result.result = root;
            }
        }
        if (root == q) {
            result.hasQ = true;
            if (result.hasP) {
                result.result = root;
            }
        }
        return result;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q).result;
    }
}
