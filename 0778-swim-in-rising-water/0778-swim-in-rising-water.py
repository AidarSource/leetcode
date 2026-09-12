class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        visit = set()
        minHeap = [[grid[0][0], 0, 0]]

        directions = [[0, -1], [0, 1], [-1, 0], [1, 0]]

        visit.add((0, 0))
        while minHeap:
            maxHeight, x, y = heapq.heappop(minHeap)
            if x == n - 1 and y == n - 1:
                return maxHeight
            for i in directions:
                neiR, neiC = x + i[0], y + i[1]
                if neiR < 0 or neiC < 0 or neiR == n or neiC == n or (neiR, neiC) in visit:
                    continue
                visit.add((neiR, neiC))
                heapq.heappush(minHeap, [max(maxHeight, grid[neiR][neiC]), neiR, neiC])


        