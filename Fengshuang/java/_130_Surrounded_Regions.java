import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by lifengshuang on 9/29/15.
 */
public class _130_Surrounded_Regions {

    private boolean[][] searched;
    private char[][] board;
    private final int isX = 0;
    private final int isO = 1;
    private final int BORDER = 2;

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        _130_Surrounded_Regions test = new _130_Surrounded_Regions();
        test.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean isBorder(int x, int y) {
        if (x < 0 || x >= searched.length || y < 0 || y >= searched[0].length) {
            return true;
        }
        return false;
    }

    public int search(int x, int y) {

        if (isBorder(x, y)) {
            return BORDER;
        } else if (searched[x][y]) {
            return isX;
        }
        searched[x][y] = true;
        if (board[x][y] == 'X') {
            return isX;
        } else {
            int up = search(x, y - 1);
            int down = search(x, y + 1);
            int left = search(x - 1, y);
            int right = search(x + 1, y);
            if (up + down + left + right == 0) {
                board[x][y] = 'X';
                return isX;
            } else {
                return isO;
            }
        }
    }

    private void non_recursive_search(int x, int y) {

        searched[x][y] = true;
        if (board[x][y] == 'X') {
            return;
        }

        class Tuple {
            int x;
            int y;

            public Tuple(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(x, y));
        boolean surrounded = true;
        ArrayList<Tuple> list = new ArrayList<>();
        list.add(new Tuple(x, y));

        while (!stack.empty()) {
            Tuple tuple = stack.pop();
            int tx = tuple.x, ty = tuple.y;
            int left = test(tx - 1, ty) ;
            int right = test(tx + 1, ty);
            int up = test(tx, ty + 1);
            int down = test(tx, ty - 1);
            if (left == 0 || right == 0 || up == 0|| down == 0) {
                surrounded = false;
            }
            if (left == 2) {
                stack.push(new Tuple(tx - 1, ty));
                list.add(new Tuple(tx - 1, ty));
            }
            if (right == 2) {
                stack.push(new Tuple(tx + 1, ty));
                list.add(new Tuple(tx + 1, ty));
            }
            if (up == 2) {
                stack.push(new Tuple(tx, ty + 1));
                list.add(new Tuple(tx, ty + 1));
            }
            if (down == 2) {
                stack.push(new Tuple(tx, ty - 1));
                list.add(new Tuple(tx, ty - 1));
            }
        }

        if (surrounded) {
            for (Tuple tuple : list) {
                board[tuple.x][tuple.y] = 'X';
            }
        }

    }

    private int test(int x, int y) {
        if (isBorder(x, y)) {
            return 0;
        } else if (searched[x][y]) {
            return 1;
        }
        searched[x][y] = true;
        if (board[x][y] == 'X') {
            return 1;
        } else {
            return 2;
        }
    }

    public void solve(char[][] board) {
        this.board = board;
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        searched = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!searched[i][j]) {
                    non_recursive_search(i, j);
                }
            }
        }

    }

}
