import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by lifengshuang on 10/20/15.
 */
public class _126_Word_Ladder_IITest {

    @Test
    public void testFindLadders() throws Exception {
        _126_Word_Ladder_II test = new _126_Word_Ladder_II();
        Set<String> wordList = new HashSet<>();
//        wordList.add("cat");
//        wordList.add("cut");
//        wordList.add("cot");
//        wordList.add("cet");
//        wordList.add("hat");

        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("hit");
        wordList.add("hog");
        wordList.add("cog");
        System.out.println(test.findLadders("hot", "dog", wordList));

    }
}