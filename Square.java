import javax.swing.*;

public class Square extends JButton{
	public String piece;

	public Square(){
		super();
	}

	public String getPiece(){
		return piece;
	}

	public void setPiece(String piece){
		this.piece = piece;
	}
}