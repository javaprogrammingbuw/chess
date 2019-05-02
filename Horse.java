
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Horse{
	
	private Gui gui;
	public Horse(Gui gui){
		this.gui = gui;
	}

	public void moveKnight(int i, int j){
		int k = gui.getXis();
		int l = gui.getYxis();
		System.out.println(k+" and "+l);
		if((i==k-1&&j==l-2)||(i==k+1&&j==l-2)||(i==k-2&&j==l-1)||(i==k+2&&j==l-1)||
				   (i==k-2&&j==l+1)||(i==k+2&&j==l+1)||(i==k-1&&j==l+2)||(i==k+1&&j==l+2)){    // this is for the horse movements
	        	
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
							if(gui.isBlack(i,j)==false&&gui.squares[i][j].piece=="knight1-white"){
								gui.setXknight1_white(i);
								gui.setYknight1_white(j);
							}else if(gui.isBlack(i,j)==false&&gui.squares[i][j].piece=="knight2-white"){
								gui.setXknight2_white(i);
								gui.setYknight2_white(j);
							}else if(gui.isBlack(i,j)==true&&gui.squares[i][j].piece=="knight1-black"){
								gui.setXknight1_black(i);
								gui.setYknight1_black(j);
							}else {
								gui.setXknight2_black(i);
								gui.setYknight2_black(j);
							}
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
						if(gui.isBlack(i,j)==false&&gui.squares[i][j].piece=="knight1-white"){
								gui.setXknight1_white(i);
								gui.setYknight1_white(j);
							}else if(gui.isBlack(i,j)==false&&gui.squares[i][j].piece=="knight2-white"){
								gui.setXknight2_white(i);
								gui.setYknight2_white(j);
							}else if(gui.isBlack(i,j)==true&&gui.squares[i][j].piece=="knight1-black"){
								gui.setXknight1_black(i);
								gui.setYknight1_black(j);
							}else {
								gui.setXknight2_black(i);
								gui.setYknight2_black(j);
							}
						gui.check();
						
	        		}
	        		
					
				}
	}
}