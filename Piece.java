//Alex Li and Philip Jacobson (CS404 E block)

//Abstract class for pieces

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.ArrayList;

public abstract class Piece
{
    private Integer xloc;
    private Integer yloc;
    private Integer pieceColor;
    private String pieceType;
    private ArrayList setOfMoves;
    public int[][] moveBoard; //9 x 10 representation of board indicating possible moves;
                              //a "1" indicates possible and "0" indicates not possible
    
    //Class constructor
    public Piece(Integer _pieceColor, int _xloc, int _yloc)
    {
        pieceColor = _pieceColor;
        xloc = _xloc;
        yloc = _yloc;
        moveBoard = new int[9][10];
    }
    
    //Methods to get piece properties
    public int getX()
    {
        return (int) xloc;   
    }
    public int getY()
    {
        return (int) yloc;
    }
    public Integer getColor()
    {
        return pieceColor;
    }
    public Integer getPieceColor()
    {
        return pieceColor;
    }
    
    //Make a move
    public void move(int _xloc, int _yloc)
    {
        if(moveBoard[_xloc][_yloc] == 1)
        {
            xloc = _xloc;
            yloc = _yloc;
            this.resetMoves();
        }
        
    }
    //Undo a move
    public void undo(int oldX, int oldY)
    {
        xloc = oldX;
        yloc = oldY;
    }
    //Disappear upon capture
    public void getCaptured()
    {
        xloc = null;
        yloc = null;
    }
    
    //Draw (specific to each piece type)
    public void draw(Graphics g,int xloc,int yloc)
    {
        
    }
    
    //Update moveBoard (specific to each piece type)
    public void setMoveSet(ChessBoard b)
    {
        
    }
    
    //Return piece type (overriden in General class)
    public String getType()
    {
        return "Not a general";
    }
    
    //Zero the moveBoard (called after move is made)
    public void resetMoves()
    {
        for(int i = 0; i < 10; i++)
            {
                for(int j = 0; j < 9; j++)
                {
                    moveBoard[j][i] = 0;
                }
            }
    }
}