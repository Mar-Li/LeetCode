import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by lifengshuang on 8/6/15.
 */
//https://leetcode.com/problems/sliding-window-maximum/
public class _239_Sliding_Window_Maximum {
    public static void main(String[] args) {
        _239_Sliding_Window_Maximum test = new _239_Sliding_Window_Maximum();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a.length < k || a.length == 0) {
            return new int[0];
        }
        if (k <= 0) {
            return null;
        }
        int[] result = new int[a.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
                deque.removeLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = a[deque.peekFirst()];
            }

        }

        return result;
    }
}
