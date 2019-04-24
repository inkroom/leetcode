package cn.inkroom.study.leetcode;

/**
 * @author 墨盒
 * @date 19-4-23
 */
public class SearchMatrix {

    /**
     * 先找行，再行内二分
     * 时间复杂度为Max(O(m),O(log(n)))
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixRowSplit(int[][] matrix, int target) {


        int row = matrix.length;
        if (row < 1) return false;

        int col = matrix[0].length - 1;
        if (col < 0) return false;
        int i = 0;
        for (i = 0; i < row; i++) {
            if (matrix[i][0] == target) return true;
            if (matrix[i][col] == target) return true;
            if (target > matrix[i][0] && target < matrix[i][col]) {
                //找到对应行
                break;
            }

        }
        if (i == row) return false;

        //二分查找，两侧已经比较了，所以只需要比较中间的内容
        int start = 1;
        int end = col - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (matrix[i][middle] < target) {
                start = middle + 1;
            } else if (matrix[i][middle] > target) {
                end = middle - 1;
            } else {
                return true;
            }

        }
        return false;

    }

    /**
     * 从左下角或右上角往中间二分
     * <p>
     * TODO 二分的问题在于没法确定退出条件，会出现来回判断的死循环
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixRowColSplit(int[][] matrix, int target) {

        int leftBottomRow = matrix.length - 1;
        int leftBottomCol = 0;

        if (leftBottomRow == -1) return false;
        int rightTopRow = 0;
        int rightTopCol = matrix[0].length - 1;

        while (rightTopRow <= leftBottomRow && leftBottomCol <= rightTopCol) {

            int rowMiddle = (leftBottomRow + rightTopRow) / 2;
            int colMiddle = (leftBottomCol + rightTopCol) / 2;

            if (matrix[rowMiddle][colMiddle] < target) {
                leftBottomRow = rowMiddle - 1;
                leftBottomCol = colMiddle - 1;
            } else if (matrix[rowMiddle][colMiddle] > target) {
                rightTopRow = rowMiddle + 1;
                rightTopCol = colMiddle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 从左下角或者右上角逐步遍历
     * //TODO 未校验
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        //定位左下角
        int row = matrix.length - 1;
        if (row == 0) return false;
        int col = 0;
        if (matrix[row].length == 0) return false;

        while (row < matrix.length && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;


    }

    public static void main(String[] args) {

//        System.out.println(new SearchMatrix().searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        }, 3));
//
//        System.out.println(new SearchMatrix().searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        }, 13));
//        System.out.println(new SearchMatrix().searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        }, 5));
//        System.out.println(new SearchMatrix().searchMatrix(new int[][]{
//                {1},
//        }, 1));

    }
}

