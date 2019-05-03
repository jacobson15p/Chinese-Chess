//Alex Li and Philip Jacobson (CS404 E block)

//Class for the Advisor piece

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Advisor extends Piece
{
    public Advisor(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Look in up to four directions diagonally (depending on whether on edge) and determine which places
    //are not occupied by piece of same color; also cannot leave palace
    public void setMoveSet(ChessBoard b)
    {
        if((getX() == 3 && getY() == 0) || (getX() == 5 && getY() == 0) && !(b.getSquares()[4][1] == 1))
        {
            moveBoard[4][1] = 1;
        }
        if(getX() == 4 && getY() == 1) 
        {
            if(b.getSquares()[3][0] != 1)
            {
                moveBoard[3][0] = 1;
            }
            if(b.getSquares()[5][0] != 1)
            {
                moveBoard[5][0] = 1;   
            }
            if(b.getSquares()[3][2] != 1)
            {
                moveBoard[3][2] = 1;
            }
            if(b.getSquares()[5][2] != 1)
            {
                moveBoard[5][2] = 1;   
            }
        }
        if((getX() == 3 && getY() == 2) || (getX() == 5 && getY() == 2) && !(b.getSquares()[4][1] == 1))
        {
            moveBoard[4][1] = 1;
        }
        if((getX() == 3 && getY() == 9) || (getX() == 5 && getY() == 9) && !(b.getSquares()[4][8] == -1))
        {
            moveBoard[4][8] = 1;
        }
        if(getX() == 4 && getY() == 8) 
        {
            if(b.getSquares()[3][9] != -1)
            {
                moveBoard[3][9] = 1;
            }
            if(b.getSquares()[5][9] != -1)
            {
                moveBoard[5][9] = 1;   
            }
            if(b.getSquares()[3][7] != -1)
            {
                moveBoard[3][7] = 1;
            }
            if(b.getSquares()[5][7] != -1)
            {
                moveBoard[5][7] = 1;   
            }
        }
        if((getX() == 3 && getY() == 7) || (getX() == 5 && getY() == 7) && !(b.getSquares()[4][8] == -1))
        {
            moveBoard[4][8] = 1;
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
            g.drawString(Character.toString((char)20181),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)22763),xloc+10,yloc+25);
        }
    }
}