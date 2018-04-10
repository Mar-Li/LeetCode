import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lifengshuang on 10/15/15.
 */
public class _179_Largest_Number {

    public static void main(String[] args) {
        _179_Largest_Number test = new _179_Largest_Number();
        System.out.println(test.largestNumber(new int[]{883, 8}));
//        System.out.println(test.largestNumber(new int[]{120, 12}));
//        System.out.println(test.largestNumber(new int[]{125, 12}));
    }

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (!compare(nums[j], nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        if (result.length() != 0 && result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }

    public boolean compare(int a, int b) {
        String ab = a + "" + b;
        String ba = b + "" + a;
        for (int i = 0; i < (ab.length() - 1) / 8 + 1; i++) {
            int partOfAB = Integer.parseInt(ab.substring(i * 8, Math.min(i * 8 + 8, ab.length())));
            int partOfBA = Integer.parseInt(ba.substring(i * 8, Math.min(i * 8 + 8, ab.length())));
            if (partOfAB > partOfBA) {
                return true;
            } else if (partOfAB < partOfBA){
                return false;
            }
        }
        return true;
//        String x = String.valueOf(a);
//        String y = String.valueOf(b);
//        for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
//            if (x.charAt(i) < y.charAt(i)) {
//                return false;
//            }
//            if (x.charAt(i) > y.charAt(i)) {
//                return true;
//            }
//        }
//        if (x.length() > y.length()) {
//            for (int i = 0; i < y.length(); i++) {
//                if (x.charAt(y.length()) > y.charAt(i)) {
//                    return true;
//                }
//                if (x.charAt(y.length()) < y.charAt(i)) {
//                    return false;
//                }
//            }
//        }
//        if (x.length() < y.length()) {
//            for (int i = 0; i < x.length(); i++) {
//                if (y.charAt(x.length()) < x.charAt(i)) {
//                    return true;
//                }
//                if (y.charAt(x.length()) > x.charAt(i)) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

}
