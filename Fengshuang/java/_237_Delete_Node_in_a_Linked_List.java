/**
 * Created by lifengshuang on 8/6/15.
 */



public class _237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        while (true) {
            if (node.next.next == null) {
                node.val = node.next.val;
                node.next = null;
                return;
            }
            node.val = node.next.val;
            node = node.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
