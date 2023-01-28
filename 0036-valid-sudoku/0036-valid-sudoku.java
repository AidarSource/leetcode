class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        //check for rows
        for (int i = 0; i < rows; i++) {
            rowSet = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }

        //check for cols
        for (int i = 0; i < cols; i++) {
            colSet = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    return false;
                }

                colSet.add(board[j][i]);
            }
        }

        //block
        for (int i = 0; i < rows; i = i + 3) {
            for (int j = 0; j < cols; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBlock(int idX, int idJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idX + 3;
        int cols = idJ + 3;
        for(int i = idX; i < rows; i++) {
            for(int j = idJ; j < cols; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(blockSet.contains(board[i][j])) {
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
}