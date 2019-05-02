import java.awt.image.BufferedImage;
import javax.swing.*;

public class King{

	private Gui gui;
	public King(Gui gui){
		this.gui = gui;
	}
	public void moveKing(int i, int j){
		int k = gui.getXis();
		int l = gui.getYxis();
	
		if((i==k+1 && j==l) || (i==k-1 && j==l) || (i==k && j==l+1) || (i==k && j==l-1) || 
	   		(i==k+1 && j==l+1) || (i==k+1 && j==l-1) || (i==k-1 && j==l-1) || (i==k-1 && j==l+1) ){		
        	if(gui.isIconThere(i,j)==true){
        		if((gui.isBlack(k,l)==true&&gui.isBlack(i,j)==false)||(gui.isBlack(k,l)==false&&gui.isBlack(i,j)==true)){		
	        		Square second = gui.squares[i][j];
					second.setPiece(gui.first.getPiece());
					second.setIcon(gui.pieces.get(second.getPiece()));
					gui.first.setPiece(null);
					gui.first.setIcon(new ImageIcon(
		                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					gui.first = null;
					gui.setXturn(i);
					gui.setYturn(j);
					if(gui.isBlack(i,j)==false){
						gui.setXking_white(i);
						gui.setYking_white(j);

					}else{
						gui.setXking_black(i);
						gui.setYking_black(j);
					}
					gui.checkingSquareForKing(i,j);
				}else{
					gui.first = null;
				}
			}else{
				Square second = gui.squares[i][j];
				second.setPiece(gui.first.getPiece());
				second.setIcon(gui.pieces.get(second.getPiece()));
				gui.first.setPiece(null);
				gui.first.setIcon(new ImageIcon(
	                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				gui.first = null;
				gui.setXturn(i);
				gui.setYturn(j);
				if(gui.isBlack(i,j)==false){
					gui.setXking_white(i);
					gui.setYking_white(j);
				}else{
					gui.setXking_black(i);
					gui.setYking_black(j);
				}
				gui.checkingSquareForKing(i,j);
			}

        }else{
        	gui.first = null;
        }
    
    }

}