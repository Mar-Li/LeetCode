/**
 * Created by lifengshuang on 10/13/15.
 */
public class _91_Decode_Ways {

    public static void main(String[] args) {
        _91_Decode_Ways test = new _91_Decode_Ways();
        String s = "27";
        System.out.println(test.numDecodings(s));
        System.out.println(test.goThrough(s, 0));
    }

    public int numDecodings(String s) {
//        return goThrough(s, 0);
        int length = s.length();
        if (length == 0) return 0;
        int count[][] = new int[length][length];

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != '0') {
                count[i][i] = 1;
            }
        }

        for (int gap = 1; gap < length; gap++) {
            for (int i = 0; i < length - gap; i++) {
                if (s.charAt(i + gap) != '0') {
                    count[i][i + gap] += count[i][i + gap - 1];
                }
                if (valid(s, i, i + gap - 2)) {
                    if (gap == 1) {
                        count[i][i + gap]++;
                    } else {
                        count[i][i + gap] += count[i][i + gap - 2];
                    }
                }
            }
        }

        return count[0][length - 1];
    }

    public boolean valid(String s, int i, int j) {
        int value = Integer.parseInt(s.substring(j + 1, j + 3));
        if (i > j) {
            return value >= 10 && value <= 26;
        }
        return value > 0 && value <= 26;
    }


    public int goThrough(String s, int pos) {
        if (s.length() <= pos + 1) {
            return 1;
        }
        int twoDigit = Integer.parseInt(s.substring(pos, pos + 2));
        if (twoDigit >= 1 && twoDigit <= 26) {
            return goThrough(s, pos + 1) + goThrough(s, pos + 2);
        } else {
            return goThrough(s, pos + 1);
        }
    }

}
