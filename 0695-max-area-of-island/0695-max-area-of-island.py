class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        area = 0
        rows, cols = len(grid), len(grid[0])

        def bfs(r, c):
            q = deque()
            grid[r][c] = 0
            q.append((r, c))
            res = 1

            while q:
                row, col = q.popleft()
                for dr, dc in directions:
                    nr, nc = dr + row, dc + col
                    if nr < 0 or nc < 0 or nr >= rows or nc >= cols or grid[nr][nc] == 0:
                        continue
                    q.append((nr, nc))
                    grid[nr][nc] = 0
                    res = res + 1
            
            return res

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    area = max(area, bfs(r, c))
        
        return area
                            
        