//Alex Li and Philip Jacobson (CS404 E block)

//Class that holds and updates the states of squares (used by pieces to update their possible move sets)

public class ChessBoard 
{
    public int[][] squares; //2-D array that stores state of the squares (contains red piece, contains black piece, or empty)
    private boolean whoseTurn; //used to determine what state (true, red or false, black) with which to refresh the squares
    
    public ChessBoard()
    {
        whoseTurn = true;
        
        squares = new int[9][10];
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                squares[i][j] = 0;
            }
        }
    }
    
    public void refreshSquares(int oldX, int oldY, int newX, int newY)
    {
        squares[oldX][oldY] = 0;
        if (whoseTurn == true)
        {
            squares[newX][newY] = 1;
        }
        else
        {
            squares[newX][newY] = -1;
        }
        whoseTurn = !whoseTurn;
    }
    public int[][] getSquares()
    {
        return squares;
    }
}