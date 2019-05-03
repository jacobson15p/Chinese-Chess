//Alex Li and Philip Jacobson (CS404 E block)

//Class for the elephant piece

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Elephant extends Piece
{
    public Elephant(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Methods to check each diagonal direction and determine which squares are not occupied by pieces
    //of same color or blocked
    private void checkRightUp(ChessBoard b)
    {
        if (b.getSquares()[this.getX() + 1][this.getY() + 1] == 0 && b.getSquares()[this.getX() + 2][this.getY() + 2] != this.getPieceColor())
        {
            moveBoard[this.getX() + 2][this.getY() + 2] = 1;
        }
    }
    private void checkRightDown(ChessBoard b)
    {
        if (b.getSquares()[this.getX() + 1][this.getY() - 1] == 0 && b.getSquares()[this.getX() + 2][this.getY() - 2] != this.getPieceColor())
        {
            moveBoard[this.getX() + 2][this.getY() - 2] = 1;
        }
    }
    private void checkLeftUp(ChessBoard b)
    {
        if (b.getSquares()[this.getX() - 1][this.getY() + 1] == 0 && b.getSquares()[this.getX() - 2][this.getY() + 2] != this.getPieceColor())
        {
            moveBoard[this.getX() - 2][this.getY() + 2] = 1;
        }
    }
    private void checkLeftDown(ChessBoard b)
    {
        if (b.getSquares()[this.getX() - 1][this.getY() - 1] == 0 && b.getSquares()[this.getX() - 2][this.getY() - 2] != this.getPieceColor())
        {
            moveBoard[this.getX() - 2][this.getY() - 2] = 1;
        }
    }
 
    //Determine which directions to check based on whether piece is on the edge of the board
    public void setMoveSet(ChessBoard b)
    {
        if(this.getX() == 0 || this.getX() == 1)
        {
            if(this.getY() == 1 || this.getY() == 0)
            {
                checkRightUp(b);
            }
            else if(this.getY() == 8 || this.getY() == 9)
            {
                checkRightDown(b);
            }
            else
            {
                checkRightUp(b);
                checkRightDown(b);
            }
        }
        else if(this.getX() == 7 || this.getX() == 8)
        {
            if(this.getY() == 1 || this.getY() == 0)
            {
                checkLeftUp(b);
            }
            else if(this.getY() == 8 || this.getY() == 9)
            {
                checkLeftDown(b);
            }
            else
            {
                checkLeftUp(b);
                checkLeftDown(b);
            }
        }
        else
        {
            if(this.getY() == 1 || this.getY() == 0)
            {
                checkLeftUp(b);
                checkRightUp(b);
            }
            else if(this.getY() == 8 || this.getY() == 9)
            {
                checkLeftDown(b);
                checkRightDown(b);
            }
            else
            {
                checkLeftUp(b);
                checkLeftDown(b);
                checkRightUp(b);
                checkRightDown(b);
            }
        }

        if(this.getPieceColor() == 1)
        {
            moveBoard[0][6] = 0;
            moveBoard[4][6] = 0;
            moveBoard[8][6] = 0;
        }
        
        else if(this.getPieceColor() == -1)
        {
            moveBoard[0][3] = 0;
            moveBoard[4][3] = 0;
            moveBoard[8][3] = 0;
        }
    }
    public void draw(Graphics g,int xloc,int yloc)
    {
        if(getColor() == 1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.RED);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)30456),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)35937),xloc+10,yloc+25);
        }
    }
}      