class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS, COLS = len(board), len(board[0])

        def dfs(row, col):
            if(row < 0 or col < 0 or row == ROWS or col == COLS
                or board[row][col] != 'O'
            ):
                return
            
            board[row][col] = 'T'
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)
        
        for r in range(ROWS):
            if board[r][0] == 'O':
                dfs(r, 0)
            if board[r][COLS - 1]:
                dfs(r, COLS - 1)
        
        for c in range(COLS):
            if board[0][c] == 'O':
                dfs(0, c)
            if board[ROWS - 1][c] == 'O':
                dfs(ROWS - 1, c)

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 'O':
                    board[r][c] = 'X'
                if board[r][c] == 'T':
                    board[r][c] = 'O'

        