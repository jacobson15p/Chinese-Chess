//Alex Li and Philip Jacobson (CS404 E block)

//Class for the horse piece

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Horse extends Piece
{
    public Horse(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
    
    //Looks in up to eight directions (depending on whether on edge) and determine which places
    //are not occupied by piece of same color; also checks to see if blocked
    public void setMoveSet(ChessBoard b)
    {
        for(int i = 0; i <= 8; i++)
        {
            for(int j = 0; j <= 9; j++)
            {
                if((i + 2 == this.getX() && j + 1 == this.getY())
                    || (i + 2 == this.getX() && j - 1 == this.getY())
                    || (i - 2 == this.getX() && j + 1 == this.getY())
                    || (i - 2 == this.getX() && j - 1 == this.getY())
                    || (i + 1 == this.getX() && j + 2 == this.getY())
                    || (i + 1 == this.getX() && j - 2 == this.getY())
                    || (i - 1 == this.getX() && j + 2 == this.getY())
                    || (i - 1 == this.getX() && j - 2 == this.getY()))
                {
                    moveBoard[i][j] = 1;
                    if((i - this.getX() == 2 && (j - this.getY() == 1 || j - this.getY() == -1) && this.getX() < 7
                      && b.getSquares()[this.getX() + 1][this.getY()] != 0)
                           
                    || (i - this.getX() == -2 && (j - this.getY() == 1 || j - this.getY() == -1) && this.getX() > 1
                      && b.getSquares()[this.getX() - 1][this.getY()] != 0)
                           
                    || ((i - this.getX() == 1 || i - this.getX() == -1) && j - this.getY() == 2 && this.getY() < 7
                      && b.getSquares()[this.getX()][this.getY() + 1] != 0)
                    
                    || ((i - this.getX() == 1 || i - this.getX() == -1) && j - this.getY() == -2 && this.getY() > 1
                      && b.getSquares()[this.getX()][this.getY() - 1] != 0))
                    {
                        moveBoard[i][j] = 0;
                    }
                }
                else
                {
                    moveBoard[i][j] = 0;
                }
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
            g.drawString(Character.toString((char)20620),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)39340),xloc+10,yloc+25);
        }
    }
}      