/**
 * Created by lifengshuang on 9/30/15.
 */
public class _29_Divide_Two_Integers {
    public static void main(String[] args) {
        _29_Divide_Two_Integers test = new _29_Divide_Two_Integers();

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + ": " + test.getDigits(i));
//        }

        System.out.println(test.divide(-2147483648, -1));
        int a = -2147483648 / -1;
        System.out.println(a);
        System.out.println(test.divide(9, 3));

    }

    public int divide(int dividend, int divisor) {

        boolean sign = (dividend < 0) ^ (divisor < 0);
        long a = dividend, b = divisor;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        if (b == 0) {
            return 0;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == -dividend && divisor == -1) {
            return ~dividend;
        }

        int result = 0;
        int aDigits = getDigits(a);
        int bDigits = getDigits(b);

        if (bDigits > aDigits) {
            return 0;
        }
        for (int i = aDigits - bDigits; i >= 0; i--) {
            long shift = b << i;
            if (shift <= a) {
                a -= shift;
                result |= 1 << i;
            }
        }
        if (sign) {
            result = -result;
        }
        return result;
    }

    public int getDigits(long num) {
        int digits = 1;
        while ((num >> digits) > 0) {
            digits++;
        }
        return digits;
    }
}
