import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lifengshuang on 10/15/15.
 */
public class _220_Contains_Duplicate_III {

    public static void main(String[] args) {
        _220_Contains_Duplicate_III test = new _220_Contains_Duplicate_III();
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 2, 1));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long[] longnums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longnums[i] = nums[i];
        }
        if (k < t) {
            for (int i = 0; i < longnums.length; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i + j < longnums.length) {
                        if (Math.abs(longnums[i] - longnums[i + j]) <= t) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else {
            class Entry {
                int index;
                long value;

                public Entry(int index, long value) {
                    this.value = value;
                    this.index = index;
                }
            }
            Entry[] entries = new Entry[longnums.length];
            for (int i = 0; i < longnums.length; i++) {
                entries[i] = new Entry(i, longnums[i]);
            }
            Arrays.sort(entries, new Comparator<Entry>() {
                @Override
                public int compare(Entry o1, Entry o2) {
                    return (int) (o1.value - o2.value);
                }
            });
            for (int i = 0; i < longnums.length; i++) {
                for (int j = 1; j < longnums.length; j++) {
                    if (i + j >= longnums.length) {
                        break;
                    }
                    long diff = Math.abs(entries[i].value - entries[i + j].value);
                    if (diff > t) {
                        break;
                    } else {
                        if (Math.abs(entries[i].index - entries[i + j].index) <= k) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }


//
//    class SortedTreeQueue {
//        int capability;
//        int diff;
//        Node root;
//        ArrayList<Node> list = new ArrayList<>();
//
//        public SortedTreeQueue(int capability, int diff) {
//            this.capability = capability;
//            this.diff = diff;
//        }
//
//        boolean add(int value) {
//            Node node = new Node(value);
//            list.add(node);
//            if (root == null) {
//                root = node;
//                return false;
//            }
//
//            if (list.size() == capability) {
//                //check and remove first-in element
//            }
//            else {
//                //insert and check
//                insert(root, node);
//            }
//
//            return false;
//        }
//
//        boolean check(Node node) {
//            if (node.parent != null) {
//                if (withinT(node.value, node.parent.value)) {
//                    return true;
//                }
//            }
//            if (node.left)
//            return false;
//        }
//
//        boolean withinT(int a, int b) {
//            return Math.abs(a - b) <= diff;
//        }
//
//        void remove(Node node) {
//            Node replace = node.right;
//            if (replace == null) {
//                if ()
//            }
//
//        }
//
//        void insert(Node parent, Node child) {
//            if (parent.value <= child.value) {
//                if (parent.right == null) {
//                    parent.right = child;
//                    child.parent = parent;
//                } else {
//                    insert(parent.right, child);
//                }
//            } else {
//                if (parent.left == null) {
//                    parent.left = child;
//                    child.parent = parent;
//                } else {
//                    insert(parent.left, child);
//                }
//            }
//        }
//
//    }
//
//    class Node {
//        Node parent;
//        Node left;
//        Node right;
//        int value;
//
//        public Node(int value) {
//            this.value = value;
//        }
//    }

}
