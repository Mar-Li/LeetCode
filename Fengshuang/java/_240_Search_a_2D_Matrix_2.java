/**
 * Created by lifengshuang on 8/4/15.
 */
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class _240_Search_a_2D_Matrix_2 {

    public static void main(String[] args) {
        _240_Search_a_2D_Matrix_2 test = new _240_Search_a_2D_Matrix_2();
        int[][] matrix = {{1, 4, 12}, {3, 8, 37}, {5, 9, 46}, {7, 24, 55}};
        System.out.println(test.searchMatrix(matrix, 1));
        System.out.println(test.searchMatrix(matrix, 5));
        System.out.println(test.searchMatrix(matrix, 9));
        System.out.println(test.searchMatrix(matrix, 32));
        System.out.println(test.searchMatrix(matrix, 11));
        System.out.println(test.searchMatrix(matrix, 55));
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix[0].length;
        int n = matrix.length;

        int left = 0, right = m;

        for (int i = 0; i < (n + 1) / 2; i++) {
            try {
                right = binSearchRight(matrix[i], target, left, right);
                left = binSearchRight(matrix[n - i - 1], target, left, right);
            } catch (NumberFoundException e) {
                return true;
            }
        }

        return false;
    }

    public int binSearchLeft(int line[], int target, int left, int right) throws NumberFoundException {
        int gap = right - left;
        //binary search
        while (gap > 8) {
            int mid = (left + right) / 2;
            if (line[mid] > target) {
                right = mid;
            } else if (line[mid] < target) {
                left = mid;
            } else {
                throw new NumberFoundException();
            }
            gap = right - left;
        }
        //linear search
        for (int i = left; i < right; i++) {
            if (line[i] > target) {
                return Math.max(i - 1, left);
            }
            else if (line[i] == target) {
                throw new NumberFoundException();
            }
        }
        return left;
    }

    public int binSearchRight(int line[], int target, int left, int right) throws NumberFoundException {
        int gap = right - left;
        //binary search
        while (gap > 8) {
            int mid = (left + right) / 2;
            if (line[mid] > target) {
                right = mid;
            } else if (line[mid] < target) {
                left = mid;
            } else {
                throw new NumberFoundException();
            }
            gap = right - left;
        }
        //linear search
        for (int i = right - 1; i >= left; i--) {
            if (line[i] < target) {
                return i + 1;
            }
            else if (line[i] == target) {
                throw new NumberFoundException();
            }
        }
        return left;
    }

    private class NumberFoundException extends Exception {
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        int m = matrix[0].length;
//        int n = matrix.length;
//
//        //find y
//        int mLeft = 0;
//        int mRight = m;
//        int mGap = m;
//        //binary search
//        while (mGap > 8) {
//            int mid = (mLeft + mRight) / 2;
//            if (matrix[0][mid] > target) {
//                mRight = mid;
//            } else {
//                mLeft = mid;
//            }
//            mGap = mRight - mLeft;
//        }
//        //linear search
//        int y = mLeft;
//        for (int i = mLeft + 1; i < mRight; i++) {
//            if (matrix[0][i] > target) {
//                break;
//            }
//            y = i;
//        }
//        System.out.println(y);
//
//        //find x
//        int nLeft = 0;
//        int nRight = n;
//        int nGap = n;
//        //binary search
//        while (nGap > 8) {
//            int mid = (nLeft + mRight) / 2;
//            if (matrix[mid][y] > target) {
//                nRight = mid;
//            } else {
//                nLeft = mid;
//            }
//            nGap = nRight - nLeft;
//        }
//        //linear search
//        int x = nLeft;
//        for (int i = nLeft + 1; i < nRight; i++) {
//            if (matrix[i][y] > target) {
//                break;
//            }
//            x = i;
//        }
//        System.out.println(x);
//
//        return matrix[x][y] == target;
//    }

}
