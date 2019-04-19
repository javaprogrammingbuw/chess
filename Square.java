import javax.swing.*;

public class Square extends JButton{
	public String piece;               // here visibility is private but for our use i made it as public, donot forget to change later.

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