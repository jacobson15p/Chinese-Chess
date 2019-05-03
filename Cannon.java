//Alex Li and Philip Jacobson (CS404 E block)

//Class for the Cannon piece

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Cannon extends Piece
{
    public Cannon(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Similar method to chariot, but captures differently (after reaching an occupied square, looks for pieces
    //past that square in the same direction)
    public void setMoveSet(ChessBoard b)
    {
        for(int i = 1; i <= 8 - this.getX(); i++)
        {
           if(b.getSquares()[this.getX() + i][this.getY()] == 0)
           {
               moveBoard[this.getX() + i][this.getY()] = 1;
           }
           else
           {
               for(int j = 1; j <= 8 - (this.getX() + i); j++)
               {
                   if(b.getSquares()[this.getX() + i + j][this.getY()] == getPieceColor()*-1)
                   {
                       moveBoard[this.getX() + i + j][this.getY()] = 1;
                       j = 10;
                   }
               }
               i = 10;
           }
        }
        for(int i = 1; i <= this.getX(); i++)
        {
            if(b.getSquares()[this.getX() - i][this.getY()] == 0)
            {
                moveBoard[this.getX() - i][this.getY()] = 1;  
            }
            else
           {
               for(int j = 1; j <= this.getX() - i; j++)
               {
                   if(b.getSquares()[this.getX() - i - j][this.getY()] == getPieceColor()*-1)
                   {
                       moveBoard[this.getX() - i - j][this.getY()] = 1;
                       j = 10;
                   }
               }
               i = 10;
           }
        }
        for(int i = 1; i <= 9 - this.getY(); i++)
        {
            if(b.getSquares()[this.getX()][this.getY() + i] == 0)
            {
                moveBoard[this.getX()][this.getY() + i] = 1;
            }
            else
           {
               for(int j = 1; j <= 9 - (this.getY() + i); j++)
               {
                   if(b.getSquares()[this.getX()][this.getY() + i + j] ==  getPieceColor()*-1)
                   {
                       moveBoard[this.getX()][this.getY() + i + j] = 1;
                       j = 10;
                   }
               }
               i = 10;
           }
        }
        for(int i = 1; i <= this.getY(); i++)
        {
            if(b.getSquares()[this.getX()][this.getY() - i] == 0)
            {
                moveBoard[this.getX()][this.getY() - i] = 1;
            }
            else
            {
               for(int j = 1; j <= this.getY() - i; j++)
               {
                   if(b.getSquares()[this.getX()][this.getY() - i - j] == getPieceColor()*-1)
                   {
                       moveBoard[this.getX()][this.getY() - i - j] = 1;
                       j = 10;
                   }
               }
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
            g.drawString(Character.toString((char)28846),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)30770),xloc+10,yloc+25);
        }
    }
}   