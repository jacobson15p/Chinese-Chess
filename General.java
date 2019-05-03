//Alex Li and Philip Jacobson (CS404 E block)

//Class for the general piece

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
public class General extends Piece
{
    public General(Integer _pieceColor,  int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Determine where to go based on which squares in orthogonal directions are not
    //occupied by piece of same color; also cannot leave palace
    public void setMoveSet(ChessBoard b)
    {
        if(getX() == 4 && getY() == 0)
        {
            if(b.getSquares()[3][0] != 1)
            {
                moveBoard[3][0] = 1;
            }
            if(b.getSquares()[5][0] != 1)
            {
                moveBoard[5][0] = 1;   
            }
            if(b.getSquares()[4][1] != 1)
            {
                moveBoard[4][1] = 1;
            }
        }
        if(getX() == 4 && getY() == 1)
        {
            if(b.getSquares()[3][1] != 1)
            {
                moveBoard[3][1] = 1;
            }
            if(b.getSquares()[5][1] != 1)
            {
                moveBoard[5][1] = 1;   
            }
            if(b.getSquares()[4][0] != 1)
            {
                moveBoard[4][0] = 1;
            }
            if(b.getSquares()[4][2] != 1)
            {
                moveBoard[4][2] = 1;   
            }
        }
        if(getX() == 4 && getY() == 2)
        {
            if(b.getSquares()[3][2] != 1)
            {
                moveBoard[3][2] = 1;
            }
            if(b.getSquares()[5][2] != 1)
            {
                moveBoard[5][2] = 1;   
            }
            if(b.getSquares()[4][1] != 1)
            {
                moveBoard[4][1] = 1;
            }
        }
        if(getX() == 3 && getY() == 0)
        {
            if(b.getSquares()[4][0] != 1)
            {
                moveBoard[4][0] = 1;
            }
            if(b.getSquares()[3][1] != 1)
            {
                moveBoard[3][1] = 1;   
            }
        }
        if(getX() == 5 && getY() == 0)
        {
            if(b.getSquares()[4][0] != 1)
            {
                moveBoard[4][0] = 1;
            }
            if(b.getSquares()[5][1] != 1)
            {
                moveBoard[5][1] = 1;   
            }
        }
        if(getX() == 3 && getY() == 1)
        {
            if(b.getSquares()[3][2] != 1)
            {
                moveBoard[3][2] = 1;
            }
            if(b.getSquares()[4][1] != 1)
            {
                moveBoard[4][1] = 1;   
            }
            if(b.getSquares()[3][0] != 1)
            {
                moveBoard[3][0] = 1;   
            }
        }
        if(getX() == 5 && getY() == 1)
        {
            if(b.getSquares()[4][1] != 1)
            {
                moveBoard[4][1] = 1;
            }
            if(b.getSquares()[5][2] != 1)
            {
                moveBoard[5][2] = 1;   
            }
            if(b.getSquares()[5][0] != 1)
            {
                moveBoard[5][0] = 1;   
            }
        }
        if(getX() == 3 && getY() == 2)
        {
            if(b.getSquares()[4][2] != 1)
            {
                moveBoard[4][2] = 1;
            }
            if(b.getSquares()[3][1] != 1)
            {
                moveBoard[3][1] = 1;   
            }
        }
        if(getX() == 5 && getY() == 2)
        {
            if(b.getSquares()[4][2] != 1)
            {
                moveBoard[4][2] = 1;
            }
            if(b.getSquares()[5][1] != 1)
            {
                moveBoard[5][1] = 1;   
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        if(getX() == 4 && getY() == 9)
        {
            if(b.getSquares()[3][9] != -1)
            {
                moveBoard[3][9] = 1;
            }
            if(b.getSquares()[5][9] != -1)
            {
                moveBoard[5][9] = 1;   
            }
            if(b.getSquares()[4][8] != -1)
            {
                moveBoard[4][8] = 1;
            }
        }
        if(getX() == 4 && getY() == 8)
        {
            if(b.getSquares()[3][8] != -1)
            {
                moveBoard[3][8] = 1;
            }
            if(b.getSquares()[5][8] != -1)
            {
                moveBoard[5][8] = 1;   
            }
            if(b.getSquares()[4][9] != -1)
            {
                moveBoard[4][9] = 1;
            }
            if(b.getSquares()[4][7] != -1)
            {
                moveBoard[4][7] = 1;   
            }
        }
        if(getX() == 4 && getY() == 7)
        {
            if(b.getSquares()[3][7] != -1)
            {
                moveBoard[3][7] = 1;
            }
            if(b.getSquares()[5][7] != -1)
            {
                moveBoard[5][7] = 1;   
            }
            if(b.getSquares()[4][8] != -1)
            {
                moveBoard[4][8] = 1;
            }
        }
        if(getX() == 3 && getY() == 9)
        {
            if(b.getSquares()[4][9] != -1)
            {
                moveBoard[4][9] = 1;
            }
            if(b.getSquares()[3][8] != -1)
            {
                moveBoard[3][8] = 1;   
            }
        }
        if(getX() == 5 && getY() == 9)
        {
            if(b.getSquares()[4][9] != -1)
            {
                moveBoard[4][9] = 1;
            }
            if(b.getSquares()[5][8] != -1)
            {
                moveBoard[5][8] = 1;   
            }
        }
        if(getX() == 3 && getY() == 8)
        {
            if(b.getSquares()[3][8] != -1)
            {
                moveBoard[3][8] = 1;
            }
            if(b.getSquares()[4][8] != -1)
            {
                moveBoard[4][8] = 1;   
            }
            if(b.getSquares()[3][9] != -1)
            {
                moveBoard[3][9] = 1;   
            }
        }
        if(getX() == 5 && getY() == 8)
        {
            if(b.getSquares()[4][8] != -1)
            {
                moveBoard[4][8] = 1;
            }
            if(b.getSquares()[5][7] != -1)
            {
                moveBoard[5][7] = 1;   
            }
            if(b.getSquares()[5][9] != -1)
            {
                moveBoard[5][9] = 1;   
            }
        }
        if(getX() == 3 && getY() == 7)
        {
            if(b.getSquares()[4][7] != -1)
            {
                moveBoard[4][7] = 1;
            }
            if(b.getSquares()[3][8] != -1)
            {
                moveBoard[3][8] = 1;   
            }
        }
        if(getX() == 5 && getY() == 7)
        {
            if(b.getSquares()[4][7] != -1)
            {
                moveBoard[4][7] = 1;
            }
            if(b.getSquares()[5][8] != -1)
            {
                moveBoard[5][8] = 1;   
            }
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
            g.drawString(Character.toString((char)24101),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)23559),xloc+10,yloc+25);
        }
    }
    public String getType()
    {
        return "General";
    }
}
