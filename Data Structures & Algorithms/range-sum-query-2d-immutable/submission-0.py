class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.pre = [[0 for _ in range(len(matrix[0])+1)] for _ in range(len(matrix)+1)]

        for i in range(len(matrix)):
            prevsum = 0
            for j in range(len(matrix[0])):
                prevsum += matrix[i][j]
                above = self.pre[i][j+1]
                self.pre[i+1][j+1] = prevsum+above

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        r1,r2,c1,c2 = row1+1,row2+1,col1+1,col2+1

        bottomright = self.pre[r2][c2]
        left = self.pre[r2][c1-1]
        above = self.pre[r1-1][c2]
        topleft = self.pre[r1-1][c1-1]
        return bottomright-left-above+topleft


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)