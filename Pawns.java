import java.awt.image.BufferedImage;
import javax.swing.*;

public class Pawns{
	
	public Gui gui;
	public Pawns(Gui gui){
		this.gui = gui;
	}

	public void movePawn(int i, int j){
		int k = gui.getXis();
		int l = gui.getYxis();

		if((i==k+1 && j==l&&k<8)||(i==k-1&&j==l&&k>=0)||(k==6&&i==k-2||k==1&&i==k+2)){       // this is for the pawns movements
	                
	        if(gui.isIconThere(i,j)==false && gui.noBackStep(i,j)==true){
				
        		Square second = gui.squares[i][j];
				second.setPiece(gui.first.getPiece());
				second.setIcon(gui.pieces.get(second.getPiece()));
				gui.first.setPiece(null);
				gui.first.setIcon(new ImageIcon(
	                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				gui.first = null;
				gui.setPreX(i);
				gui.setPreY(j);
				gui.setXturn(i);
				gui.setYturn(j);
				gui.check();
			}else{
				gui.first = null;
			}
        }else if((i==k+1&&j==l-1||i==k+1&&j==l+1)||(i==k-1&&j==l-1||i==k-1&&j==l+1)){
			if(gui.isIconThere(i,j)==true){
				if((gui.isBlack(k,l)==true&&gui.isBlack(i,j)==false)||(gui.isBlack(k,l)==false&&gui.isBlack(i,j)==true)){
	        		Square second = gui.squares[i][j];
					second.setPiece(gui.first.getPiece());
					second.setIcon(gui.pieces.get(second.getPiece()));
					gui.first.setPiece(null);
					gui.first.setIcon(new ImageIcon(
		                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					gui.first = null;
					gui.setPreX(i);
					gui.setPreY(j);
					gui.setXturn(i);
					gui.setYturn(j);
					gui.check();
				}else{
					gui.first = null;
				}
			}else{
				gui.first = null;
			}
		}else{
			gui.first = null;
		}
	
	}
}