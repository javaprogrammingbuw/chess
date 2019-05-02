import java.awt.image.BufferedImage;
import javax.swing.*;

public class Queen{
	
	private Gui gui;
	public Queen(Gui gui){
		this.gui = gui;
	}

	public void moveQueen(int i, int j){
		int k = gui.getXis();
		int l = gui.getYxis();

		if((i<=k-1&&j<=l-1&&i-k==j-l)||(i>=k+1&&j<=l-1&&k-i==j-l)||(i<=k-1&&j>=l+1&&i-k==l-j)||
           (i>=k+1&&j>=l+1&&k-i==l-j)||(i>=0&&i<=7&&j==l)||(i==k&&j>=0&&j<=7)){	
 	
			if(gui.isIconInWay(i,j,k,l)==false){
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
				}
		        		
			}else{
				gui.first = null;
			}

		}else{
			gui.first = null;
		}
	
	} 
}