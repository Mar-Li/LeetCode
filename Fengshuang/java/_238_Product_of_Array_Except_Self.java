import java.util.Arrays;

/**
 * Created by lifengshuang on 8/6/15.
 */
public class _238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        _238_Product_of_Array_Except_Self test = new _238_Product_of_Array_Except_Self();
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

}
