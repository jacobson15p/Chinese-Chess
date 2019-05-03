//Alex Li and Philip Jacobson (CS404 E block)

//Class for the soldier piece

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Font;
public class Soldier extends Piece
{
     public Soldier(Integer _pieceColor, int _xloc, int _yloc)
    {
        super(_pieceColor, _xloc,_yloc);
    }
     
     //Based on whether crossed river, looks at vertical and possible horizontal
     //squares can be visited (i.e. not occupied by piece of same color)
     public void setMoveSet(ChessBoard b)
     {
         if(!(getY() == 9 || getY() == 0))
         {    
             if(b.getSquares()[getX()][getY() + 1] != 1 && getColor() == 1)
             {
                 moveBoard[getX()][getY() + 1] = 1;
             }
             else if(b.getSquares()[getX()][getY() - 1] != -1 && getColor() == -1)
             {
                 moveBoard[getX()][getY() - 1] = 1;
             }
         }
         if(!(getX() == 0 || getX() == 8)) 
         {
             if(getPieceColor() == 1 && this.getY() >= 5)
             {
                 if(b.getSquares()[getX() + 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() + 1][getY()] = 1;
                 }
                 if(b.getSquares()[getX() - 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() - 1][getY()] = 1;
                 }
             }
             else if(getPieceColor() == -1 && this.getY() < 5)
             {
                 if(b.getSquares()[getX() + 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() + 1][getY()] = 1;
                 }
                 if(b.getSquares()[getX() - 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() - 1][getY()] = 1;
                 }
             }
         }
         if(getX() == 0)
         {
             if(getPieceColor() == 1 && this.getY() >= 5)
             {
                 if(b.getSquares()[getX() + 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() + 1][getY()] = 1;
                 }
             }
             else if(getPieceColor() == -1 && this.getY() < 5)
             {
                 if(b.getSquares()[getX() + 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() + 1][getY()] = 1;
                 }
             }
         }
         if(getX() == 8)
         {
             if(getPieceColor() == 1 && this.getY() >= 5)
             {
                 if(b.getSquares()[getX() - 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() - 1][getY()] = 1;
                 }
             }
             else if(getPieceColor() == -1 && this.getY() < 5)
             {
                 if(b.getSquares()[getX() - 1][getY()] != getPieceColor())
                 {
                     moveBoard[getX() - 1][getY()] = 1;
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
            g.drawString(Character.toString((char)20853),xloc+10,yloc+25);
        }
        if(getColor() == -1)
        {
            g.setColor(Color.WHITE);
            g.fillOval(xloc,yloc,40,40);
            g.setFont(new Font("TimesRoman",Font.PLAIN,20));
            g.setColor(Color.BLACK);
            g.drawOval(xloc,yloc,40,40);
            g.drawString(Character.toString((char)21330),xloc+10,yloc+25);
        }
    }
}