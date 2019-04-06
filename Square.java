import javax.swing.*;

public class Square extends JButton{
	private String piece;

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