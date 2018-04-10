public class FileChunkMerge {

    private Node root;
    private int length;

    class Node {
        Node left;
        Node right;
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public FileChunkMerge(int length) {
        this.length = length;
    }

    public void insertChunk(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return;
        }
        insert(root, start, end);
        balanceTree();
    }

    private void insert(Node node, int start, int end) {
        if (end < node.start) {
            if (node.left == null) {
                node.left = new Node(start, end);
            } else {
                insert(node.left, start, end);
            }
        } else if (start > node.end) {
            if (node.right == null) {
                node.right = new Node(start, end);
            } else {
                insert(node.right, start, end);
            }
        } else if (end >= node.end) {
            Node result = mergeRightFromLeft(node, end);
            if (result != null) {
                node.end = Math.max(result.end, end);
            } else {
                node.end = end;
            }
        } else if (start <= node.start) {
            Node left = node.left;
            if (left != null) {
//                while (left.left != null && left.end >= start) {
//                    left = left.left;
//                }
//                node.start = Math.min(start, left.start);
//                node.left = left;
            } else {
                node.start = start;
            }
        }
    }

    // Conditions: 1) end >= node.end 2) start <= node.end
    private Node mergeRightFromLeft(Node node, int end) {
        if (node.right == null) {
            return node;
        } else {
            if (node.right.end < end) {
                Node right = node.right;
                node.right = node.right.right;
                Node temp = mergeRightFromLeft(node, end);
                if (temp == null) {
                    return right;
                } else {
                    return temp;
                }
            } else {
                if (node.right.start > end) {
                    return mergeRightFromRight(node.right, end);
                } else {
                    Node temp = node.right;
                    node.right = node.right.right;
                    return temp;
                }
            }
        }
    }

    // var node is verified not going to be merged
    // return value is the right most node to be merged
    private Node mergeRightFromRight(Node node, int end) {
        if (node.left == null) {
            return null;
        } else {
            if (node.left.start <= end) {
                Node temp = mergeRightFromLeft(node.left, end);
                if (temp == null) {
                    Node result = node.left;
                    node.left = node.left.right;
                    return result;
                } else {
                    node.left = node.left.right;
                    return temp;
                }
            } else {
                return mergeRightFromRight(node.left, end);
            }
        }
    }

    private void balanceTree() {
        return;
    }

    public boolean isCompleted() {
        return root != null && root.start == 0 && root.end == this.length - 1;
    }

    public static void main(String[] args) {
        FileChunkMerge merge = new FileChunkMerge(100);
        merge.insertChunk(0, 3);
        merge.insertChunk(50, 53);
        merge.insertChunk(20, 23);
        merge.insertChunk(44, 46);
        merge.insertChunk(15, 16);
        merge.insertChunk(3, 45);
        System.out.println();
    }
}
