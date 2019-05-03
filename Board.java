//Alex Li and Philip Jacobson (CS404 E block)


//Class that runs the game and houses the GUI

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Board extends JFrame implements Runnable
{
    public ChessSquare[][] arrayOfSquares; //2-D array that stores chess squares (indexed by location on board)
    public Piece[][] listOfPieces; //2-D array that stores pieces (indexed by location on board)
    private int activeX; //x-coordinate of square that has been clicked
    private int activeY; //y-coordinate of square that has been clicked
    private boolean inCheck; //does the move put you in check?
    private boolean redTurn; //is it the red player's turn?
    private int isActive; //has a piece been selected yet this turn?
    public ChessBoard b; //class that holds and updates states of squares
    
    //Constructor
    public Board()
    {
        super("Chinese Chess");
        inCheck = false;
        redTurn = true;
        b = new ChessBoard();
        listOfPieces = new Piece[9][10];
        
        //Set up the board
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(i == 0 && (j == 0 || j == 8))
                {
                    listOfPieces[j][i] = new Chariot(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 0 && (j == 1 || j == 7))
                {
                    listOfPieces[j][i] = new Horse(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 0 && (j == 2 || j == 6))
                {
                    listOfPieces[j][i] = new Elephant(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 0 && (j == 3 || j == 5))
                {
                    listOfPieces[j][i] = new Advisor(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 0 && j == 4)
                {
                    listOfPieces[j][i] = new General(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 2 && (j == 1 || j == 7))
                {
                    listOfPieces[j][i] = new Cannon(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 3 && (j == 0 || j == 2 ||j == 4 || j == 6 || j == 8))
                {
                    listOfPieces[j][i] = new Soldier(1,j,i);
                    b.squares[j][i] = 1;
                }
                else if(i == 6 &&(j == 0 || j == 2 ||j == 4 || j == 6 || j == 8))
                {
                    listOfPieces[j][i] = new Soldier(-1,j,i);
                    b.squares[j][i] = -1;                    
                }
                else if(i == 7 && (j == 1 || j == 7))
                {
                    listOfPieces[j][i] = new Cannon(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else if(i == 9 && j == 4)
                {
                    listOfPieces[j][i] = new General(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else if(i == 9 && (j == 0 || j == 8))
                {
                    listOfPieces[j][i] = new Chariot(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else if(i == 9 && (j == 1 || j == 7))
                {
                    listOfPieces[j][i] = new Horse(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else if(i == 9 && (j == 2 || j == 6))
                {
                    listOfPieces[j][i] = new Elephant(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else if(i == 9 && (j == 3 || j == 5))
                {
                    listOfPieces[j][i] = new Advisor(-1,j,i);
                    b.squares[j][i] = -1;
                }
                else
                {
                    listOfPieces[j][i] = new NullPiece(0,j,i);
                }
                
            }
        }
        
        //Get the possible moves for each piece
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                listOfPieces[j][i].setMoveSet(b);
            }
        }
        
        //Indicate to the mouse listener that no piece has been already selected
        isActive = 0;
    }
    
    //Run method
    public void run()
    {
        setSize(600,600);
        getContentPane().add(new ChessPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);   
    }
    
    //Main method
    public static void main(String[] args)
    {
        Board cb = new Board();
        javax.swing.SwingUtilities.invokeLater(cb);
    }
    
    //Alien that holds all the squares
    public class ChessPanel extends JPanel
    {
        
        public ChessPanel()
        {
            super(new GridLayout(10,9));
            arrayOfSquares = new ChessSquare[9][10];
            for(int j = 0; j < 10; j++)
            {
                for(int k = 0; k < 9; k++)
                {
                    arrayOfSquares[k][j] = new ChessSquare(listOfPieces[k][j],k,j); 
                    add(arrayOfSquares[k][j]);
                }
            }
        }
    }
    
    //Alien that represents a square; listens for clicks and contains a piece
    class ChessSquare extends JPanel implements MouseListener
    {
        final int x;
        final int y;
        Piece squarePiece;
        
        //Constructor
        public ChessSquare(Piece _squarePiece, int _x, int _y)
        {
            x = _x;
            y = _y;
            squarePiece = _squarePiece;
            addMouseListener(this);
        }
        
        //Method to see if in check
        private void checkForCheck()
        {
            for(int i = 0; i < 10; i++)
                    {
                        for(int j = 0; j < 9; j++)
                        {
                            for(int k = 0; k <= 8; k++)
                            {
                                for(int l = 0; l <= 9; l++)
                                {
                                    if(listOfPieces[j][i].moveBoard[k][l] == 1
                                           && listOfPieces[k][l].getType() == "General"
                                           && listOfPieces[k][l].getColor() != listOfPieces[j][i].getColor()
                                           && redTurn != (listOfPieces[j][i].getColor() == 1))
                                    {
                                        inCheck = true;
                                    }
                                }
                            }
                        }
                    }
        }
        
        //Helper methods for mouse listener
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseClicked(MouseEvent e)
        {
            //Suppose a piece is clicked first (i.e. nothing has already been clicked this turn)
            if((squarePiece.getColor() == 1 && redTurn == true) || (squarePiece.getColor() == -1 && redTurn == false))
            {
                setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
                arrayOfSquares[activeX][activeY].setBorder(BorderFactory.createEmptyBorder());
                activeX = x;
                activeY = y;
                isActive = 1;
            }
            
            //Suppose a destination square is clicked (i.e. a piece has been clicked this turn)
            else if(isActive == 1)
            {
                inCheck = false; //Reset inCheck each turn (checks/updates at end)
                listOfPieces[activeX][activeY].move(x,y);
                
                //Make a move after checking that you are not capturing a general
                if(listOfPieces[activeX][activeY].getX() == x && listOfPieces[activeX][activeY].getY() == y &&
                listOfPieces[x][y].getType() != "General")
                {
                    listOfPieces[x][y] = listOfPieces[activeX][activeY];
                    listOfPieces[activeX][activeY] = new NullPiece(0,activeX,activeY);
                    changePiece(listOfPieces[x][y]);
                    arrayOfSquares[activeX][activeY].changePiece(listOfPieces[activeX][activeY]);
                    b.refreshSquares(activeX,activeY,x,y);
                    for(int i = 0; i < 10; i++)
                    {
                        for(int j = 0; j < 9; j++)
                        {
                            listOfPieces[j][i].resetMoves();
                            listOfPieces[j][i].setMoveSet(b);
                        }
                    }
                    checkForCheck();
                    arrayOfSquares[activeX][activeY].setBorder(BorderFactory.createEmptyBorder());
                    isActive = 0;
                    redTurn = !redTurn;
                }
               
                //Undo move and make player go again if in check
                if(inCheck == true)
                {
                    listOfPieces[x][y].undo(activeX, activeY);
                    arrayOfSquares[activeX][activeY].changePiece(squarePiece);
                    squarePiece = new NullPiece(0, x, y);
                    b.refreshSquares(x, y, activeX, activeY);  
                    for(int i = 0; i < 10; i++)
                    {
                        for(int j = 0; j < 9; j++)
                        {
                            listOfPieces[j][i].resetMoves();
                            listOfPieces[j][i].setMoveSet(b);
                        }
                    }
                    redTurn = !redTurn;
                    checkForCheck();
                    isActive = 0;
                    inCheck = false;
                    JOptionPane.showMessageDialog(null, 
                                                  "Your move either puts you into check or fails to get you out of check. Please make a different move.",
                                                  "Check",
                                                   JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        public void mouseReleased(MouseEvent e){}
        
        //Update the piece held by a square
        public void changePiece(Piece p)
        {
            squarePiece = p;
            repaint();
        }
        

        @Override
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.BLACK);
            if(y != 4 && y != 5)
            {
                g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
            }
            if(y == 4)
            {
                g.drawLine(getWidth()/2,0,getWidth()/2,getHeight()/2);
            }
            if(y == 5)
            {
                g.drawLine(getWidth()/2,getHeight(),getWidth()/2,getHeight()/2);
            }
            g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
            if(x == 3 && y == 0 || x == 4 && y == 1 || x == 4 && y == 8 || x == 3 && y == 7)
            {
                g.drawLine(getWidth()/2,getHeight()/2,getWidth(),getHeight());
            }
            if(x == 4 && y == 1 || x == 5 && y == 2 || x == 4 && y == 8 || x == 5 && y == 9)
            {
                g.drawLine(0,0,getWidth()/2,getHeight()/2);
            }
            if(x == 4 && y == 1 || x == 4 && y == 8)
            {
                g.drawLine(getWidth(),0,0,getHeight());
            }
            if(x == 5 && y == 0 || x == 5 && y == 7)
            {
                g.drawLine(getWidth()/2,getHeight()/2,0,getHeight());
            }
            if(x == 3 && y == 2 || x == 3 && y == 9)
            {
                g.drawLine(getWidth(),0,getWidth()/2,getHeight()/2);
            }
            squarePiece.draw(g,getWidth()/2-20,getHeight()/2-20);
        }
    }
}