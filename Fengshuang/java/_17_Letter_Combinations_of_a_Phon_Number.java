import java.util.LinkedList;
import java.util.List;

public class _17_Letter_Combinations_of_a_Phon_Number {
    public static void main(String[] args) {
        _17_Letter_Combinations_of_a_Phon_Number test = new _17_Letter_Combinations_of_a_Phon_Number();
        test.letterCombinations("7");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        int length = digits.length();
        List<String> temp1 = new LinkedList<>();
        temp1.add("");
        for (int i = 0; i < length; i++) {
            result = new LinkedList<>();
            int num = (int) digits.charAt(i) - '0';
            if (num < 2 || num > 9) {
                return null;
            }
            for (String s : temp1) {
                int size = 3;
                if (num == 7 || num == 9) {
                    size++;
                }
                for (int j = 0; j < size; j++) {
                    char c = (char) ((int) 'a' + (num - 2) * 3 + j);
                    if (num > 7) {
                        c = (char) (c + 1);
                    }
                    result.add(s + c);
                }
            }
            temp1 = result;
        }
        return result;
    }
}
