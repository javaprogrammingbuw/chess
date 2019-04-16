import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

	public class Gui extends JFrame{
		
	private JPanel contentPane;
	private JPanel chessBoard;
	private Square[][] squares = new Square[8][8];
	private JTextField tf1;
	private JTextField tf2;
	private JButton calcBtn;
	private HashMap<String,ImageIcon> pieces = new LinkedHashMap<>();
	private Square first = null;
	public int xis;
	public int yxis;
	public int k,l;

	public int getXis(){
		return this.xis;
	}

    public int getYxis(){
    	return this.yxis;
    } 

    public void setXis(int x){
    	this.xis = x;
    }

    public void setYxis(int y){
    	this.yxis = y;
    }

	public Gui(){
		initUi();
		initPieces();
	}

	public void initUi(){
		contentPane = (JPanel) getContentPane();

		chessBoard = new JPanel(new GridLayout(8, 8));
		chessBoard.setPreferredSize(new Dimension(1200, 1200));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(chessBoard);

        // create the chess board squares according to:
        // https://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                Square b = new Square();
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                final int x = j;
                final int y = i;
                b.addActionListener((event) -> movePiece(x,y));
                if ((j % 2 == 1 && i % 2 == 1)|| (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                squares[j][i] = b;
                chessBoard.add(squares[j][i]);
            }
        }

		contentPane.setLayout(new FlowLayout());

        pack();

        //Position in screen center
        setLocationRelativeTo(null);
        //Close Application when window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void initPieces(){
		//create pieces and add them to LinkedHashMap
		try{

			//8 white pawns
			pieces.put("pawn1-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn2-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn3-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn4-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn5-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn6-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn7-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn8-white", new ImageIcon(ImageIO.read(new File("assets/pawn-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));

			//place white pawns on board
			for(int i = 0; i<squares.length; i++){
				String piece = "pawn"+(i+1)+"-white";
				squares[1][i].setIcon(pieces.get(piece));
				squares[1][i].setPiece(piece);
			}

			pieces.put("rook1-white", new ImageIcon(ImageIO.read(new File("assets/rook-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("rook2-white", new ImageIcon(ImageIO.read(new File("assets/rook-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[0][0].setIcon(pieces.get("rook1-white"));
			squares[0][0].setPiece("rook1-white");
			squares[0][7].setIcon(pieces.get("rook2-white"));
			squares[0][7].setPiece("rook2-white");

			pieces.put("knight1-white", new ImageIcon(ImageIO.read(new File("assets/knight-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("knight2-white", new ImageIcon(ImageIO.read(new File("assets/knight-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[0][1].setIcon(pieces.get("knight1-white"));
			squares[0][1].setPiece("knight1-white");
			squares[0][6].setIcon(pieces.get("knight2-white"));
			squares[0][6].setPiece("knight2-white");

			pieces.put("bishop1-white", new ImageIcon(ImageIO.read(new File("assets/bishop-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("bishop2-white", new ImageIcon(ImageIO.read(new File("assets/bishop-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[0][2].setIcon(pieces.get("bishop1-white"));
			squares[0][2].setPiece("bishop1-white");
			squares[0][5].setIcon(pieces.get("bishop2-white"));
			squares[0][5].setPiece("bishop2-white");

			pieces.put("queen-white", new ImageIcon(ImageIO.read(new File("assets/queen-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[0][3].setIcon(pieces.get("queen-white"));
			squares[0][3].setPiece("queen-white");

			pieces.put("king-white", new ImageIcon(ImageIO.read(new File("assets/king-white.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[0][4].setIcon(pieces.get("king-white"));
			squares[0][4].setPiece("king-white");

		}catch(IOException e){
			e.printStackTrace();		
		}

		try{

			//8 black pawns
			pieces.put("pawn1-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn2-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn3-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn4-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn5-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn6-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn7-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("pawn8-black", new ImageIcon(ImageIO.read(new File("assets/pawn-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));

			//place black pawns on board
			for(int i = 0; i<squares.length; i++){
				String piece = "pawn"+(i+1)+"-black";
				squares[6][i].setIcon(pieces.get(piece));
				squares[6][i].setPiece(piece);
			}

			pieces.put("rook1-black", new ImageIcon(ImageIO.read(new File("assets/rook-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("rook2-black", new ImageIcon(ImageIO.read(new File("assets/rook-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[7][0].setIcon(pieces.get("rook1-black"));
			squares[7][0].setPiece("rook1-black");
			squares[7][7].setIcon(pieces.get("rook2-black"));
			squares[7][7].setPiece("rook2-black");

			pieces.put("knight1-black", new ImageIcon(ImageIO.read(new File("assets/knight-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("knight2-black", new ImageIcon(ImageIO.read(new File("assets/knight-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[7][1].setIcon(pieces.get("knight1-black"));
			squares[7][1].setPiece("knight1-black");
			squares[7][6].setIcon(pieces.get("knight2-black"));
			squares[7][6].setPiece("knight2-black");

			pieces.put("bishop1-black", new ImageIcon(ImageIO.read(new File("assets/bishop-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			pieces.put("bishop2-black", new ImageIcon(ImageIO.read(new File("assets/bishop-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[7][2].setIcon(pieces.get("bishop1-black"));
			squares[7][2].setPiece("bishop1-black");
			squares[7][5].setIcon(pieces.get("bishop2-black"));
			squares[7][5].setPiece("bishop2-black");

			pieces.put("queen-black", new ImageIcon(ImageIO.read(new File("assets/queen-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[7][4].setIcon(pieces.get("queen-black"));
			squares[7][4].setPiece("queen-black");

			pieces.put("king-black", new ImageIcon(ImageIO.read(new File("assets/king-black.png")).getScaledInstance(120,120,java.awt.Image.SCALE_SMOOTH)));
			squares[7][3].setIcon(pieces.get("king-black"));
			squares[7][3].setPiece("king-black");

		}catch(IOException e){
			e.printStackTrace();		
		}

	}
	private boolean isIconThere(int i, int j){
		if(squares[i][j].piece==null){
			return false;
		}else{
			return true;
		}
	}
	
	
	private void checkCoin(int i, int j){
		
		
	}
	

	private void movePiece(int i, int j){
		if(first==null){
			first=squares[i][j];
			setXis(i);
			setYxis(j);
			System.out.println(isIconThere(i,j));
		}
		else{
			// if(i>=getXis()-2&&i<=getXis()+2&&j>=getYxis()-2&&j<=getYxis()+2){
			// 	Square second = squares[i][j];
			// 	second.setPiece(first.getPiece());
			// 	second.setIcon(pieces.get(second.getPiece()));
			// 	first.setPiece(null);
			// 	first.setIcon(new ImageIcon(
	  //                   	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
			// 	first = null;
			// }
			k=getXis();
			l=getYxis();
			
			if(first.getIcon()==pieces.get("knight1-black")||first.getIcon()==pieces.get("knight1-white")||
				first.getIcon()==pieces.get("knight2-black")||first.getIcon()==pieces.get("knight2-white")){

				if((i==k-1&&j==l-2)||(i==k+1&&j==l-2)||(i==k-2&&j==l-1)||(i==k+2&&j==l-1)||
				   (i==k-2&&j==l+1)||(i==k+2&&j==l+1)||(i==k-1&&j==l+2)||(i==k+1&&j==l+2)){    // this is for the horse movements
//	        		if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}
			}
			 if(first.getIcon()==pieces.get("pawn1-black")||first.getIcon()==pieces.get("pawn1-white")||
			 	first.getIcon()==pieces.get("pawn2-black")||first.getIcon()==pieces.get("pawn2-white")||
			 	first.getIcon()==pieces.get("pawn3-black")||first.getIcon()==pieces.get("pawn3-white")||
			 	first.getIcon()==pieces.get("pawn4-black")||first.getIcon()==pieces.get("pawn4-white")||
			 	first.getIcon()==pieces.get("pawn5-black")||first.getIcon()==pieces.get("pawn5-white")||
			 	first.getIcon()==pieces.get("pawn6-black")||first.getIcon()==pieces.get("pawn6-white")||
			 	first.getIcon()==pieces.get("pawn7-black")||first.getIcon()==pieces.get("pawn7-white")||
			 	first.getIcon()==pieces.get("pawn8-black")||first.getIcon()==pieces.get("pawn8-white")){	

			// if((i==k+1&&j==l)||(i==k-1&&j==l)){       // this is for the pawns movements
                
   //              Square second = squares[i][j];
			// 	second.setPiece(first.getPiece());
			// 	second.setIcon(pieces.get(second.getPiece()));
			// 	first.setPiece(null);
			// 	first.setIcon(new ImageIcon(
	  //                   	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
			// 	first = null; 
			// }

			// switch (k){
			// 	case 1:
				if(i==k+1 && j==l&&k<8){       // this is for the pawns movements
	                
//	                if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;				
						
						
						
//					}else{
//						first = null;
//					}
				}
				// break;
                // case 6:
	            if(i==k-1&&j==l&&k>=0){       // this is for the pawns movements
	                
//	               if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}	
				// break;
			// }
			}		
			 
				// for the king movements

			 
			 if(first.getIcon()==pieces.get("king-black")||first.getIcon()==pieces.get("king-white")){
	                if((i==k+1 && j==l) || (i==k-1 && j==l) || (i==k && j==l+1) || (i==k && j==l-1) || (i==k+1 && j==l+1) || (i==k+1 && j==l-1) || (i==k-1 && j==l-1) || (i==k-1 && j==l+1) ){		
			        		Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
	                }
			 }
			 
			// for the rook movements	 
			 
			 if(first.getIcon()==pieces.get("rook1-black") || first.getIcon()==pieces.get("rook1-white") || (first.getIcon()==pieces.get("rook2-black") || first.getIcon()==pieces.get("rook2-white"))){
	                if((i<k && j==l) || (i>k && j==l) || (i==k && j<l) || (i==k && j>l)){		
			        		Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
	                }
			 }
			 
				// for the bishop movements	
			 
			 if(first.getIcon()==pieces.get("bishop1-black") || first.getIcon()==pieces.get("bishop1-white") || (first.getIcon()==pieces.get("bishop2-black") || first.getIcon()==pieces.get("bishop2-white"))){
	                if((i<k && j<l) || (i>k && j>l) || (i>k && j<l) || (i<k && j>l)){		
			        		Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
	                }
			 }
			 
		 


			// for the queen movements
                
            if(first.getIcon()==pieces.get("queen-black")||first.getIcon()==pieces.get("queen-white")){
                if(i<=k-1&&j<=l-1&&i-k==j-l){		
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else if(i>=k+1&&j<=l-1&&k-i==j-l){
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else if(i<=k-1&&j>=l+1&&i-k==l-j){
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else if(i>=k+1&&j>=l+1&&k-i==l-j){
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else if(i>=0&&i<=7&&j==l){
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else if(i==k&&j>=0&&j<=7){
//					if(isIconThere(i,j)==false){
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
//					}else{
//						first = null;
//					}
				}else{
					first = null;
				}
			}				 

		}
	}
	  

	public static void main(String[] args){
		EventQueue.invokeLater(() ->{
            Gui gui = new Gui();
            gui.setVisible(true);
        });
	}

}