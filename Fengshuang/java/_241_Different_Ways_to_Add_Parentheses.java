import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lifengshuang on 8/4/15.
 */
//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class _241_Different_Ways_to_Add_Parentheses {
    public static void main(String[] args) {
        _241_Different_Ways_to_Add_Parentheses t = new _241_Different_Ways_to_Add_Parentheses();
        t.diffWaysToCompute("1+2-3*43-23+3");
        t.diffWaysToCompute("1+2-3*43");
        t.diffWaysToCompute("2*3-4*5");
    }

    public List<Integer> diffWaysToCompute(String input) {

        //
        ArrayList<Character> operators = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int iteratorIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                numbers.add(Integer.parseInt(input.substring(iteratorIndex, i)));
                iteratorIndex = i + 1;
            }
        }
        numbers.add(Integer.parseInt(input.substring(iteratorIndex, input.length())));
//        System.out.println(operators);
//        System.out.println(numbers);
//        System.out.println();

        if (operators.size() == 0 && numbers.size() == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(numbers.get(0));
            return list;
        }

        ArrayList<LinkedList<Integer>>[] lists = new ArrayList[operators.size() + 1];
        lists[0] = new ArrayList<>();
        lists[0].add(new LinkedList<>());
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (LinkedList<Integer> left : lists[j]) {
                    for (LinkedList<Integer> right : lists[i - j - 1]) {
                        LinkedList<Integer> join = new LinkedList<>();
                        join.add(j + 1);
                        join.addAll(left);
                        LinkedList<Integer> rightAddJ = new LinkedList<>();
                        for (Integer num : right) {
                            rightAddJ.add(num + j + 1);
                        }
                        join.addAll(rightAddJ);
                        lists[i].add(join);
                    }
                }
            }
            (lists[i]).forEach(System.out::println);
        }
//        System.out.println();
//        System.out.println();

//        ArrayList<Integer> result = new ArrayList<>();
//        for (LinkedList<Integer> order : lists[lists.length - 1]) {
//            result.add(calculateResult(operators, numbers, order));
//        }

        return (lists[lists.length - 1]).stream().map(order -> calculateResult(operators, numbers, order)).collect(Collectors.toList());
    }

    private int calculateResult(ArrayList<Character> operators, ArrayList<Integer> numbers, LinkedList<Integer> orders) {
        Node root = new Node();
        for (int order : orders) {
            insertOperator(root, order, operators.get(order - 1));
        }
        addNumber(root, numbers);
        return resultFromTree(root);
    }

    private void insertOperator(Node root, int number, char operator) {
        if (root.number == 0) {
            root.setOperatorNode(operator, number);
            return;
        }
        if (root.number < number) {
            if (root.right == null) {
                root.right = new Node();
            }
            insertOperator(root.right, number, operator);
        }
        else {
            if (root.left == null) {
                root.left = new Node();
            }
            insertOperator(root.left, number, operator);
        }
    }

    private void addNumber(Node root, ArrayList<Integer> numbers) {
        if (root.left == null) {
            root.left = new Node(numbers.get(root.number - 1));
        }
        else {
            addNumber(root.left, numbers);
        }
        if (root.right == null) {
            root.right = new Node(numbers.get(root.number));
        }
        else {
            addNumber(root.right, numbers);
        }
    }

    private int resultFromTree(Node root) {
        if (!root.isOperator) {
            return root.number;
        }
        else {
            switch (root.operator) {
                case '+':
                    return resultFromTree(root.left) + resultFromTree(root.right);
                case '-':
                    return resultFromTree(root.left) - resultFromTree(root.right);
                case '*':
                    return resultFromTree(root.left) * resultFromTree(root.right);
                default:
                    return 0;
            }
        }
    }

    private class Node{
        private Node left;
        private Node right;
        private char operator;
        private int number;
        private boolean isOperator;

        public Node(char operator, int number) {
            this.operator = operator;
            this.number = number;
            this.isOperator = true;
        }

        public Node(int number) {
            this.number = number;
            this.isOperator = false;
        }

        public Node() {
        }

        public void setOperatorNode(char operator, int number) {
            this.operator = operator;
            this.number = number;
            this.isOperator = true;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public char getOperator() {
            return operator;
        }

        public void setOperator(char operator) {
            this.operator = operator;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isOperator() {
            return isOperator;
        }

        public void setIsOperator(boolean isOperator) {
            this.isOperator = isOperator;
        }
    }

}
