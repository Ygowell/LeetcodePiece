package array;

public class Array {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };

//        int[][] matrix = {
//                {1}, {3}, {5}
//        };

//        int[][] matrix = {
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}
//        };
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println("Result: " + findNumberIn2DArray(matrix, 21));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int rIndex = 0;
        int cIndex = colLength - 1;

        while (rIndex < rowLength && cIndex >= 0) {
            if (matrix[rIndex][cIndex] == target) {
                return true;
            } else if (matrix[rIndex][cIndex] < target) {
                rIndex++;
            } else {
                cIndex--;
            }
        }

        return false;
    }

//    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
//        if (matrix.length == 0) return false;
//        int row = matrix.length;
//        int column = matrix[0].length;
//        int rowIndex = 0;
//        int columnIndex = 0;
//        boolean isRowSearch = true;
//
//        System.out.println("row:" + row);
//        System.out.println("column:" + column);
//
//        while (rowIndex < row && rowIndex >= 0
//                && columnIndex >= 0 && columnIndex < column) {
//            if (matrix[rowIndex][columnIndex] == target) {
//                return true;
//            } else if (matrix[rowIndex][columnIndex] < target) {
//                if (isRowSearch) {
//                    if (columnIndex == column - 1) {
//                        rowIndex++;
//                        isRowSearch = false;
//                    } else {
//                        columnIndex++;
//                    }
//                } else {
//                    rowIndex++;
//                }
//            } else {
//                columnIndex--;
//                isRowSearch = !isRowSearch;
//            }
//        }
//
//        return false;
//    }
}
