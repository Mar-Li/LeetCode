/**
 * Created by lifengshuang on 8/4/15.
 */
//https://leetcode.com/problems/valid-anagram/
public class _240_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        int[] set_s = new int[26];
        int[] set_t = new int[26];
        for (int i = 0; i < s.length(); i++){
            set_s[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            set_t[t.charAt(j) - 'a']++;
        }
        for (int k = 0; k < 26; k++) {
            if (set_s[k] != set_t[k]) return false;
        }
        return true;
    }
}
