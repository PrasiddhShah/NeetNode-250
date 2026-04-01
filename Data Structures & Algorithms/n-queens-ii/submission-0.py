class Solution:
    def totalNQueens(self, n: int) -> int:
        board = [[False for _ in range(n)] for _ in range(n)]
        self.count=0
        self.backtrack(board,0)
        return self.count

    def backtrack(self,board,r):
        if r == len(board):
            self.count +=1
            return
        
        for i in range(len(board)):
            if self.isSafe(board,r,i):
                board[r][i] = True
                self.backtrack(board,r+1)
                board[r][i] = False

    def isSafe(self,board,r,c):
        #col check
        row,col = r,c
        for i in range(row-1,-1,-1):
            if board[i][col]:
                return False

        #left diag check
        row,col = r-1,c-1
        while row >=0 and col >= 0:
            if board[row][col]:
                return False
            row-=1
            col-=1
        #right diag check
        row, col = r-1, c+1
        while row >=0 and col < len(board):
            if board[row][col]:
                return False
            row-=1
            col+=1
        return True