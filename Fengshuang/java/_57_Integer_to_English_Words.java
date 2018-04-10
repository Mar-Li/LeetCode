/**
 * Created by lifengshuang on 10/13/15.
 */
public class _57_Integer_to_English_Words {

    public static void main(String[] args) {
        _57_Integer_to_English_Words test = new _57_Integer_to_English_Words();
        for (int i = 1; i < 100; i++) {
//            System.out.println(test.numberToWords(i));
//            System.out.println(test.numberToWord(String.valueOf(i)));
        }

        System.out.println(test.numberToWord("00"));
    }

    public String numberToWords(int num) {
        String number = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10 - number.length(); i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(number);

        String result = "";

        String billion = stringBuilder.substring(0, 1);
        String hundred_million = stringBuilder.substring(1, 2);
        String million = stringBuilder.substring(2, 4);
        String hundred_thousand = stringBuilder.substring(4, 5);
        String thousand = stringBuilder.substring(5, 7);
        String hundred = stringBuilder.substring(7, 8);
        String one = stringBuilder.substring(8, 10);

        if (!isZero(billion)) {
            result += numberToWord(billion);
        }
        if (result.length() != 0) {
            result += " Billion";
        }

        if (!isZero(hundred_million)) {
            result += " " + numberToWord(hundred_million);
            if (result.length() != 0) {
                result += " Hundred";
            }
        }

        if (!isZero(million)) {
            result += " " + numberToWord(million);
        }
        if (!isZero(hundred_million) || !isZero(million)) {
            result += " Million";
        }

        if (!isZero(hundred_thousand)) {
            result += " " + numberToWord(hundred_thousand);
            if (result.length() != 0) {
                result += " Hundred";
            }
        }
        if (!isZero(thousand)) {
            result += " " + numberToWord(thousand);
        }
        if (!isZero(hundred_thousand) || !isZero(thousand)) {
            result += " Thousand";
        }
        if (!isZero(hundred)) {
            result += " " + numberToWord(hundred);
            if (result.length() != 0) {
                result += " Hundred";
            }
        }
        if (!isZero(one)) {
            result += " " + numberToWord(one);
        }

        if (result.length() == 0) {
            return "Zero";
        }

        return result.trim();
    }

    public String numberToWord(String s) {
        String word = "";
        String[] belowTen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tenToTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] aboveTwenty = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        if (s.length() == 2) {

            if (s.charAt(0) == '0') {
                return belowTen[s.charAt(1) - '0'];
            }

            if (s.charAt(0) == '1') {
                return tenToTwenty[s.charAt(1) - '0'];
            }

            if (s.charAt(0) != '0') {
                word += aboveTwenty[s.charAt(0) - '2'];
            }

            if (s.charAt(1) != '0') {
                word += " ";
                word += belowTen[s.charAt(1) - '0'];
            }
        }
        else if (s.length() == 1) {
            return belowTen[s.charAt(0) - '0'];
        }
        return word;
    }

    private boolean isZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}
