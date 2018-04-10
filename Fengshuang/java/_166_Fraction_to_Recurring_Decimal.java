import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lifengshuang on 9/27/15.
 */
public class _166_Fraction_to_Recurring_Decimal {

    public static void main(String[] args) {
        _166_Fraction_to_Recurring_Decimal test = new _166_Fraction_to_Recurring_Decimal();
        System.out.println(test.fractionToDecimal(2, 7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        boolean sign = false;
        long n = numerator;
        if (n < 0) {
            n = -n;
            sign = !sign;
        }
        long d = denominator;
        if (d < 0) {
            d = -d;
            sign = !sign;
        }
        long beforeDot = n / d;
        long remainder = n % d;
        if (remainder == 0) {
            if (sign && beforeDot != 0) {
                return "-" + String.valueOf(beforeDot);
            }
            return String.valueOf(beforeDot);
        }
        String result = String.valueOf(beforeDot) + ".";

        String afterDot = "";
        int count = 0;
        while (remainder != 0 && !remainderMap.containsKey(remainder)) {
            remainderMap.put(remainder, count);
            afterDot += (remainder * 10) / d;
            remainder = (remainder * 10) % d;
            count++;
        }
        if (remainder != 0) {
            afterDot = afterDot.substring(0, remainderMap.get(remainder)) + "(" + afterDot.substring(remainderMap.get(remainder), count) + ")";
        }
        result += afterDot;
        if (sign) {
            result = "-" + result;
        }
        return result;
    }

}
