import java.awt.image.BufferedImage;
import javax.swing.*;

public class Rook{
	private Gui gui;
	public Rook(Gui gui){
		this.gui = gui;
	}
	public void moveRook(int i, int j){
		int k = gui.getXis();
		int l = gui.getYxis();
		if((i<=7 && i>=0 && j==l) || (i==k && j<=7 && j>=0)){
        	if(gui.isIconInWay(i,j, k, l) == false){
            	if(gui.isIconThere(i,j) == true){
            		if((gui.isBlack(k,l) == true&& gui.isBlack(i,j) == false)||(gui.isBlack(k,l) == false && gui.isBlack(i,j) == true)){	
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