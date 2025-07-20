// Time Complexity: O(1) since we have a finite array size of 9x9
// Space Complexity: O(1) since we do everything in a finite set of max size 9

// We run a loop for each index, 0-8 and validate if each row # and col # is valid using a set. We also run a loop for each box 3x3 00, 01, 02, 20, 21... and so on. Run the same validation.

class Solution {
    public boolean flag = true;
    public boolean isValidSudoku(char[][] board) {
    
        for (int i=0; i<9; i++) {
            validateRow(board, i);
            validateCol(board, i);
        }
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3;j ++) {
                validateBox(board, i, j);
            }
        }
        return flag;
    }

    public void validateRow(char[][] board, int i) {
        if (!flag) return;
        Set<Character> set = new HashSet<>();
        for (int j=0; j < 9; j++) {
            if (board[i][j] != '.' && !set.add(board[i][j])) {
                flag = false;
                return;
            }
        }
    }

    public void validateCol(char[][] board, int j) {
        if (!flag) return;
        Set<Character> set = new HashSet<>();
        for (int i=0; i < 9; i++) {
            if (board[i][j] != '.' && !set.add(board[i][j])) {
                flag = false;
                return;
            }
        }
    }

    public void validateBox(char[][] board, int iBox, int jBox) {
        if (!flag) return;
        Set<Character> set = new HashSet<>();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int row = iBox*3 + i;
                int col = jBox*3 + j;
                if (board[row][col] != '.' && !set.add(board[row][col])) {
                    flag = false;
                    return;
                }
            }
        }
    }
}
