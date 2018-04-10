import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lifengshuang on 10/17/15.
 */
public class _126_Word_Ladder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        HashSet<String> allWords = new HashSet<>();
        HashSet<Node> upperLevel = new HashSet<>();
        HashSet<Node> currentLevel = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        Node beginNode = new Node(beginWord, null);
        allWords.add(beginWord);
        upperLevel.add(beginNode);

        while (true) {
            for (Node node : upperLevel) {
                for (int i = 0; i < node.word.length(); i++) {
                    if (i != node.nonCheckIndex) {
                        for (int j = 0; j < 26; j++) {
                            char[] charArray = node.word.toCharArray();
                            charArray[i] = (char) (j + 'a');
                            String newString = new String(charArray);
                            if (wordList.contains(newString) && !allWords.contains(newString)) {
                                Node newNode = new Node(newString, i, node);
                                currentLevel.add(newNode);

                                if (newString.equals(endWord)) {
                                    List<String> route = new ArrayList<>();
                                    for (; newNode != null; newNode = newNode.parent) {
                                        route.add(0, newNode.word);
                                    }
                                    result.add(route);
                                }
                            }
                        }
                    }
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
            if (currentLevel.isEmpty()) {
                return result;
            }

            allWords.addAll(currentLevel.stream().map(node -> node.word).collect(Collectors.toList()));
            upperLevel = currentLevel;
            currentLevel = new HashSet<>();

        }

    }

    class Node {
        String word;
        int nonCheckIndex = -1;
        Node parent;

        public Node(String word, int nonCheckIndex, Node parent) {
            this.word = word;
            this.nonCheckIndex = nonCheckIndex;
            this.parent = parent;
        }

        public Node(String word, Node parent) {

            this.word = word;
            this.parent = parent;
        }
    }

}
