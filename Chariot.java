//Alex Li and Philip Jacobson (CS404 E block)

//Class for the chariot piece

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Font;
public class Chariot extends Piece
{
    public Chariot(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Sets moveSet by looking in all four directions and adding squares; stops when an occupied square is reached
    //Also, if the occupied square contains an opposing piece, include that square too (but still stop)
    public void setMoveSet(ChessBoard b)
    {
        for(int i = 1; i <= 8 - this.getX(); i++)
        {
           if(b.getSquares()[this.getX() + i][this.getY()] == 0)
           {
               moveBoard[this.getX() + i][this.getY()] = 1;
           }
           else if(b.getSquares()[this.getX() + i][this.getY()] == getColor()*-1)
           {
               moveBoard[this.getX() + i][this.getY()] = 1;
               i = 10;
           }
           else
           {
               i = 10;
           }
        }
        for(int i = 1; i <= this.getX(); i++)
        {
            if(b.getSquares()[this.getX() - i][this.getY()] == 0)
            {
                moveBoard[this.getX() - i][this.getY()] = 1;  
            }
            else if(b.getSquares()[this.getX() - i][this.getY()] == getColor()*-1)
            {
                moveBoard[this.getX() - i][this.getY()] = 1;
                i = 10;
            }
            else
            {
                i = 10;
            }
        }
        for(int i = 1; i <= 9 - this.getY(); i++)
        {
            if(b.getSquares()[this.getX()][this.getY() + i] == 0)
            {
                moveBoard[this.getX()][this.getY() + i] = 1;
            }
            else if(b.getSquares()[this.getX()][this.getY() + i] == getColor()*(-1))
            {
                moveBoard[this.getX()][this.getY() + i] = 1;
                i = 10;
            }
            else
            {
                i = 10;
            }
        }
        for(int i = 1; i <= this.getY(); i++)
        {
            if(b.getSquares()[this.getX()][this.getY() - i] == 0)
            {
                moveBoard[this.getX()][this.getY() - i] = 1;
            }
            else if(b.getSquares()[this.getX()][this.getY() - i] == getColor()*(-1))
            {
                moveBoard[this.getX()][this.getY() - i] = 1;
                i = 10;
            }
            else
            {
                i = 10;
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
            g.drawString(Character.toString((char)20453),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)36554),xloc+10,yloc+25);
        }
    }
}      