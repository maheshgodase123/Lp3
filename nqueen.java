package practice;

public class nqueen {

    public static void main(String[] args) {

        final int size = 4;

        int [][] board = new int[size][size];

        if(nQueen(board,0))
        {
            printBoard(board);
        }
        else
        {
            System.out.println("Cant Place Queens");
        }
    }

    private static void printBoard(int[][] board) {

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j]);
            }

            System.out.println();
        }
    }

    private static boolean nQueen(int[][] board, int col) {

        if(col >= board.length)
        {
            return true;
        }
        for(int row = 0; row < board.length; row++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col] = 1;

                if(nQueen(board,col+1))
                {
                    return true;
                }

                board[row][col] = 0;
            }

        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i = 0;
        int j = 0;

        for(j = col; j >= 0; j--)
        {
            if(board[row][j] == 1)
            {
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--,j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }

        for(i = row, j = col; i < board.length && j >= 0; i++,j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }

        return true;
    }
}
