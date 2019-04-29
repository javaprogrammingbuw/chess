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
	private JPanel buttonPane;
	private Square[][] squares = new Square[8][8];
	private JTextField tf1;
	private JTextField tf2;
	private JButton calcBtn;
	private HashMap<String,ImageIcon> pieces = new LinkedHashMap<>();
	private Square first = null;

	public int xis, xking_black=7, xking_white=0, previousX, xknight1_white=0, xknight1_black=7, xknight2_white=0, xknight2_black=7;
	public int yxis, yking_black=3, yking_white=4, previousY, yknight1_white=1, yknight1_black=1, yknight2_white=6, yknight2_black=6;
	public int k,l;
	public int white = 0 ;
	public int black = 0;

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

    public int getXking_white(){
		return this.xking_white;
    }
    public int getYking_white(){
    	return this.yking_white;
    }
    public void setXking_white(int x){
    	this.xking_white = x;
    }
    public void setYking_white(int y){
    	this.yking_white = y;
    }
    public int getXking_black(){
		return this.xking_black;
    }
    public int getYking_black(){
    	return this.yking_black;
    }
    public void setXking_black(int x){
    	this.xking_black = x;
    }
    public void setYking_black(int y){
    	this.yking_black = y;
    }
    // for first knights
    public int getXknight1_white(){
		return this.xknight1_white;
    }
    public int getYknight1_white(){
    	return this.yknight1_white;
    }
    public void setXknight1_white(int x){
    	this.xknight1_white = x;
    }
    public void setYknight1_white(int y){
    	this.yknight1_white = y;
    }
    public int getXknight1_black(){
		return this.xknight1_black;
    }
    public int getYknight1_black(){
    	return this.yknight1_black;
    }
    public void setXknight1_black(int x){
    	this.xknight1_black = x;
    }
    public void setYknight1_black(int y){
    	this.yknight1_black = y;
    }
    // for second knights 
    public int getXknight2_white(){
		return this.xknight2_white;
    }
    public int getYknight2_white(){
    	return this.yknight2_white;
    }
    public void setXknight2_white(int x){
    	this.xknight2_white = x;
    }
    public void setYknight2_white(int y){
    	this.yknight2_white = y;
    }
    public int getXknight2_black(){
		return this.xknight2_black;
    }
    public int getYknight2_black(){
    	return this.yknight2_black;
    }
    public void setXknight2_black(int x){
    	this.xknight2_black = x;
    }
    public void setYknight2_black(int y){
    	this.yknight2_black = y;
    }
    // for the tracking the previous positions of the previous piece
    public int getPreX(){
		return this.previousX;
    }
    public int getPreY(){
    	return this.previousY;
    }
    public void setPreX(int x){
    	this.previousX = x;
    }
    public void setPreY(int y){
    	this.previousY = y;
    }


	public Gui(){
		initUi();
		initPieces();
	}

	public void initUi(){
		contentPane = (JPanel) getContentPane();

		chessBoard = new JPanel(new GridLayout(8, 8));
		chessBoard.setPreferredSize(new Dimension(1000, 1000));
        chessBoard.setBorder(new LineBorder(Color.BLACK));

        contentPane.add(chessBoard);

        // buttonPane = new JPanel();
        // calcBtn = new JButton("Check-Button");
        // buttonPane.add(calcBtn);
        // tf1 = new JTextField();
        // // tf1.setFont(font);
        // tf1.setText("the black checks till now:");
        // buttonPane.add(tf1);
        // tf2 = new JTextField();
        // // tf2.setFont(font);
        // tf2.setText("the white checks till now:");
        // buttonPane.add(tf2);
        // contentPane.add(buttonPane);

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
        calcBtn = new JButton("Check-Button");
        calcBtn.setToolTipText("know the about checks, give a klick");
        calcBtn.addActionListener((event)-> submit());

		contentPane.setLayout(new FlowLayout());

        pack();
        // createGroupLayout();

        //Position in screen center
        setLocationRelativeTo(null);
        //Close Application when window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// private void createGroupLayout(){
	// 	JPanel pane1 = new JPanel();
 //    	GroupLayout gl1 = new GroupLayout(pane1);
 //    	pane1.setLayout(gl1);

 //    	pane1.setToolTipText("display  pane");

 //    	gl1.setAutoCreateContainerGaps(true);
 //    	gl1.setAutoCreateGaps(true);

 //    	gl1.setHorizontalGroup(gl1.createSequentialGroup().addComponent(tf1).addComponent(calcBtn).addComponent(tf2));
 //        	gl1.setVerticalGroup(gl1.createSequentialGroup().addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
 //                                                    .addComponent(tf1)
 //                                                    .addComponent(calcBtn)
 //                                                    .addComponent(tf2)));

 //        		pack();
	// }

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

	private boolean isIconInWay(int i, int j, int y, int d){
		if(y==getXis()&&d==getYxis()){
			k = getXis();
			l = getYxis();
		}else{
			k = getPreX();
			l = getPreY();
		}
		if(i<=k-1&&j<=l-1&&i-k==j-l){
            for(int s=k-1, n=l-1; s>i&&n>j;s--,n--){
            	if(isIconThere(s,n)==true){
            		return true;
            	}

            }
		}else if(i>=k+1&&j<=l-1&&k-i==j-l){
			for(int s=k+1, n=l-1; s<i&&n>j;s++,n--){
            	if(isIconThere(s,n)==true){
            		return true;
            	}
            }
		}else if(i<=k-1&&j>=l+1&&i-k==l-j){
			for(int s=k-1, n=l+1; s>i&&n<j;s--,n++){
            	if(isIconThere(s,n)==true){
            		return true;
            	}
            }
		}else if(i>=k+1&&j>=l+1&&k-i==l-j){
			for(int s=k+1, n=l+1; s<i&&n<j;s++,n++){
            	if(isIconThere(s,n)==true){
            		return true;
            	}
            }
		}else if(i>=0&&i<=7&&j==l){
			for(int s=k+1; s<i;s++){
            	if(isIconThere(s,j)==true){
            		return true;
            	}
            }
            for(int n=k-1; n>i; n--){
            	if(isIconThere(n,j)==true){
            		return true;
            	}
            }
		}else if(i==k&&j>=0&&j<=7){
			for(int s=l+1; s<j;s++){
            	if(isIconThere(i,s)==true){
            		return true;
            	}
            }
            for(int n=l-1; n>j; n--){
            	if(isIconThere(i,n)==true){
            		return true;
            	}
            }
		}
			return false;
	}

	private boolean isWhite(int i, int j){
		if(squares[i][j].getIcon()==pieces.get("rook1-white")||squares[i][j].getIcon()==pieces.get("rook2-white")||squares[i][j].getIcon()==pieces.get("knight1-white")||
			squares[i][j].getIcon()==pieces.get("knight2-white")||squares[i][j].getIcon()==pieces.get("bishop1-white")||squares[i][j].getIcon()==pieces.get("bishop2-white")||
			squares[i][j].getIcon()==pieces.get("queen-white")||squares[i][j].getIcon()==pieces.get("king-white")||squares[i][j].getIcon()==pieces.get("pawn1-white")||
			squares[i][j].getIcon()==pieces.get("pawn2-white")||squares[i][j].getIcon()==pieces.get("pawn3-white")||squares[i][j].getIcon()==pieces.get("pawn4-white")||
			squares[i][j].getIcon()==pieces.get("pawn5-white")||squares[i][j].getIcon()==pieces.get("pawn6-white")||squares[i][j].getIcon()==pieces.get("pawn7-white")||
			squares[i][j].getIcon()==pieces.get("pawn8-white")){
			return true;

		}else{
			return false;
		}
	}

	private int checksFigure(){
		k = getXis();
		l = getYxis();
		
		if(isWhite(k,l)==true){
           return white++;
		}else if(isWhite(k,l)==false){
			return black++;
		}else{
			return 0;
		}
	}

	private boolean noBackStep(int i, int j){
		k = getXis();
		l = getYxis();
		if((i<=k&&isWhite(k,l)==true)||(i>=k&&isWhite(k,l)==false)){
			return false;
		}else{
			return true;
		}
	}
	private void check(){

		int i = getPreX();
		int j = getPreY();
    // it should target the black king
            if(squares[i][j].getIcon()==pieces.get("rook1-white")||squares[i][j].getIcon()==pieces.get("rook2-white")||squares[i][j].getIcon()==pieces.get("rook1-black")||
               squares[i][j].getIcon()==pieces.get("rook2-black")){
         	
         	}else if(squares[i][j].getIcon()==pieces.get("knight1-white")||squares[i][j].getIcon()==pieces.get("knight2-white")||squares[i][j].getIcon()==pieces.get("knight1-black")||
         	         squares[i][j].getIcon()==pieces.get("knight2-black")){
         		    if(isWhite(i,j) == true){
         		    	if((i-1==getXking_black()&&j-2==getYking_black())||(i+1==getXking_black()&&j-2==getYking_black())||(i-2==getXking_black()&&j-1==getYking_black())
         		    		||(i+2==getXking_black()&&j-1==getYking_black())||(i-2==getXking_black()&&j+1==getYking_black())||(i+2==getXking_black()&&j+1==getYking_black())
         		    		||(i-1==getXking_black()&&j+2==getYking_black())||(i+1==getXking_black()&&j+2==getYking_black()))  squares[getXking_black()][getYking_black()].setBackground(Color.RED);

         		    }else {
         		    	if((i-1==getXking_white()&&j-2==getYking_white())||(i+1==getXking_white()&&j-2==getYking_white())||(i-2==getXking_white()&&j-1==getYking_white())
         		    		||(i+2==getXking_white()&&j-1==getYking_white())||(i-2==getXking_white()&&j+1==getYking_white())||(i+2==getXking_white()&&j+1==getYking_white())
         		    		||(i-1==getXking_white()&&j+2==getYking_white())||(i+1==getXking_white()&&j+2==getYking_white()))  squares[getXking_white()][getYking_white()].setBackground(Color.RED);
     
         		    }
         	
         	}else if(squares[i][j].getIcon()==pieces.get("bishop1-white")||squares[i][j].getIcon()==pieces.get("bishop2-white")||squares[i][j].getIcon()==pieces.get("bishop1-black")||
         	         squares[i][j].getIcon()==pieces.get("bishop2-black")){

         	
         	}else if(squares[i][j].getIcon()==pieces.get("queen-white")||squares[i][j].getIcon()==pieces.get("queen-black")){
         		int bx = getXking_black(), by = getYking_black();
         		int wx = getXking_white(), wy = getYking_white(); 
         			if(isWhite(i,j) == false){
         				if((wx<=i-1&&wy<=j-1&&wx-i==wy-j)||(wx>=i+1&&wy<=j-1&&i-wx==wy-j)||(wx<=i-1&&wy>=j+1&&wx-i==j-wy)||
                   		(wx>=i+1&&wy>=j+1&&i-wx==j-wy)||(wx>=0&&wx<=7&&wy==j)||(wx==i&&wy>=0&&wy<=7)){
         					if(isIconInWay(wx, wy, i, j) == false){
                            	squares[wx][wy].setBackground(Color.RED);
                            }
         				}
         			}else{
         				if((bx<=i-1&&by<=j-1&&bx-i==by-j)||(bx>=i+1&&by<=j-1&&i-bx==by-j)||(bx<=i-1&&by>=j+1&&bx-i==j-by)||
                   		(bx>=i+1&&by>=j+1&&i-bx==j-by)||(bx>=0&&bx<=7&&by==j)||(bx==i&&by>=0&&by<=7)){
         					if(isIconInWay(bx, by,i ,j) == false){
                            	squares[bx][by].setBackground(Color.RED);
                            }
         				}
         			}
         	
         	}else if(squares[i][j].getIcon()==pieces.get("pawn1-white")||squares[i][j].getIcon()==pieces.get("pawn2-white")||squares[i][j].getIcon()==pieces.get("pawn3-white")||
	         	      squares[i][j].getIcon()==pieces.get("pawn4-white")||squares[i][j].getIcon()==pieces.get("pawn5-white")||squares[i][j].getIcon()==pieces.get("pawn6-white")||
	         	      squares[i][j].getIcon()==pieces.get("pawn7-white")||squares[i][j].getIcon()==pieces.get("pawn8-white")||squares[i][j].getIcon()==pieces.get("pawn1-black")||
	         	      squares[i][j].getIcon()==pieces.get("pawn2-black")||squares[i][j].getIcon()==pieces.get("pawn3-black")||squares[i][j].getIcon()==pieces.get("pawn4-black")||
	         	      squares[i][j].getIcon()==pieces.get("pawn5-black")||squares[i][j].getIcon()==pieces.get("pawn6-black")||squares[i][j].getIcon()==pieces.get("pawn7-black")||
	         	      squares[i][j].getIcon()==pieces.get("pawn8-black")){
         		if(isWhite(i,j)==true){
         			if(i+1==getXking_black()&&j-1==getYking_black()||i+1==getXking_black()&&j+1==getYking_black()){
         				squares[getXking_black()][getYking_black()].setBackground(Color.RED);
         			} 
         		}else{
         			if(i-1==getXking_white()&&j-1==getYking_white()||i-1==getXking_white()&&j+1==getYking_white()){
         				squares[getXking_white()][getYking_white()].setBackground(Color.RED);
         			}
         		}
         	
         	}
		}
	private String direction_1(int i, int j ){
		  
		for(int s=i-1; s>=0&&j>=0&&j<=7; s--){
           if(isIconThere(s,j)==true){
           	return squares[s][j].piece;
           }
        }
        return "king-white";
    }
    private String direction_2(int i, int j ){
		 
		for(int n=j-1; n>=0&&i>=0&&i<=7; n--){
           if(isIconThere(i,n)==true){
           	return squares[i][n].piece;
           }
        }
        return "king-white";
    }
    private String direction_3(int i, int j ){
         
		for(int s=i+1; s<=7&&j>=7&&j<=0; s++){
			if(isIconThere(s,j)==true){
				return squares[s][j].piece;
			}
		}
		return "king-white";
	}
	private String direction_4(int i, int j ){
		
		for(int n=j+1; n<=7&&i>=7&&i<=0; n++){
           if(isIconThere(i,n)==true){
           	return squares[i][n].piece;
           }
        }
        return "king-white";
    }
	private String direction_5(int i, int j ){
		
		for(int s=i-1,n=j-1; s>=0&&n>0&&i-s==j-n; s--,n--){
			if(isIconThere(s,n)==true){
                 return squares[s][n].piece;
			}
		}
		return "king-white";
	}
	private String direction_6(int i, int j ){
		 
		for(int k=i+1,l=j+1; k<=7&&l<=7&&k-i==l-j; k++,l++){
           if(isIconThere(k,l)==true){
           	return squares[k][l].piece;
           }
        }
        return "king-white";
    }
	private String direction_7(int i, int j ){
		
		for(int s=i+1,n=j-1; s<=7&&n>0&&s-i==j-n; s++,n--){
			if(isIconThere(s,n)==true){
                 return squares[s][n].piece;
			}
		}
		return "king-white";
	}
    private String direction_8(int i, int j){
		
		for(int k=i-1,l=j+1; k>=0&&l<=7&&i-k==l-j; k--,l++){
           if(isIconThere(k,l)==true){
           	return squares[k][l].piece;
           }
        }
        return "king-white";
    }


	private boolean pointingToCheck(int i, int j, int color){
		
         int x1, y1,x2, y2  ;
		
		if(color==0){
            x1 = getXknight1_black(); y1 = getYknight1_black();
            x2 = getXknight2_black(); y2 = getYknight2_black();
           
			if((i==x1-1&&j==y1-2)||(i==x1+1&&j==y1-2)||(i==x1-1&&j==y1+2)||(i==x1+1&&j==y1+2)||(i==x1-2&&j==y1-1)||(i==x1-2&&j==y1+1)||(i==x1+2&&j==y1-1)||(i==x1+2&&j==y1+1)||
			   (i==x2-1&&j==y2-2)||(i==x2+1&&j==y2-2)||(i==x2-1&&j==y2+2)||(i==x2+1&&j==y2+2)||(i==x2-2&&j==y2-1)||(i==x2-2&&j==y2+1)||(i==x2+2&&j==y2-1)||(i==x2+2&&j==y2+1)){
			   
                return true;   	
            
			}else if(direction_1(i,j)=="queen-black"||direction_2(i,j)=="queen-black"||direction_3(i,j)=="queen-black"||
				     direction_4(i,j)=="queen-black"||direction_5(i,j)=="queen-black"||direction_6(i,j)=="queen-black"||
				     direction_7(i,j)=="queen-black"||direction_8(i,j)=="queen-black"){
				
				return true;
			}else if(i+1<=7&&i+1>=0&&j-1<=7&&j-1>=0&&j+1<=7&&j+1>=0){
				        if(squares[i+1][j-1].getIcon()==pieces.get("pawn1-black")||squares[i+1][j-1].getIcon()==pieces.get("pawn2-black")||squares[i+1][j-1].getIcon()==pieces.get("pawn3-black")||
				     squares[i+1][j-1].getIcon()==pieces.get("pawn4-black")||squares[i+1][j-1].getIcon()==pieces.get("pawn5-black")||squares[i+1][j-1].getIcon()==pieces.get("pawn6-black")||
				     squares[i+1][j-1].getIcon()==pieces.get("pawn7-black")||squares[i+1][j-1].getIcon()==pieces.get("pawn8-black")||squares[i+1][j+1].getIcon()==pieces.get("pawn1-black")||
				     squares[i+1][j+1].getIcon()==pieces.get("pawn2-black")||squares[i+1][j+1].getIcon()==pieces.get("pawn3-black")||squares[i+1][j+1].getIcon()==pieces.get("pawn4-black")||
				     squares[i+1][j+1].getIcon()==pieces.get("pawn5-black")||squares[i+1][j+1].getIcon()==pieces.get("pawn6-black")||squares[i+1][j+1].getIcon()==pieces.get("pawn7-black")||
				     squares[i+1][j+1].getIcon()==pieces.get("pawn8-black")){
				      
				       return true;
				   		}
			}


		}else{
		    x1 = getXknight1_white(); y1 = getYknight1_white();
		    x2 = getXknight2_white(); y2 = getYknight2_white();
		    
			if((i==x1-1&&j==y1-2)||(i==x1+1&&j==y1-2)||(i==x1-1&&j==y1+2)||(i==x1+1&&j==y1+2)||(i==x1-2&&j==y1-1)||(i==x1-2&&j==y1+1)||(i==x1+2&&j==y1-1)||(i==x1+2&&j==y1+1)||
			   (i==x2-1&&j==y2-2)||(i==x2+1&&j==y2-2)||(i==x2-1&&j==y2+2)||(i==x2+1&&j==y2+2)||(i==x2-2&&j==y2-1)||(i==x2-2&&j==y2+1)||(i==x2+2&&j==y2-1)||(i==x2+2&&j==y2+1)){
			   	
				return true;
			
			}else if(direction_1(i,j)=="queen-white"||direction_2(i,j)=="queen-white"||direction_3(i,j)=="queen-white"||
				     direction_4(i,j)=="queen-white"||direction_5(i,j)=="queen-white"||direction_6(i,j)=="queen-white"||
				     direction_7(i,j)=="queen-white"||direction_8(i,j)=="queen-white"){
				
				return true;
			}else if(i-1<=7&&i-1>=0&&j-1<=7&&j-1>=0&&j+1<=7&&j+1>=0){
				        if(squares[i-1][j-1].getIcon()==pieces.get("pawn1-white")||squares[i-1][j-1].getIcon()==pieces.get("pawn2-white")||squares[i-1][j-1].getIcon()==pieces.get("pawn3-white")||
				     squares[i-1][j-1].getIcon()==pieces.get("pawn4-white")||squares[i-1][j-1].getIcon()==pieces.get("pawn5-white")||squares[i-1][j-1].getIcon()==pieces.get("pawn6-white")||
				     squares[i-1][j-1].getIcon()==pieces.get("pawn7-white")||squares[i-1][j-1].getIcon()==pieces.get("pawn8-white")||squares[i-1][j+1].getIcon()==pieces.get("pawn1-white")||
				     squares[i-1][j+1].getIcon()==pieces.get("pawn2-white")||squares[i-1][j+1].getIcon()==pieces.get("pawn3-white")||squares[i-1][j+1].getIcon()==pieces.get("pawn4-white")||
				     squares[i-1][j+1].getIcon()==pieces.get("pawn5-white")||squares[i-1][j+1].getIcon()==pieces.get("pawn6-white")||squares[i-1][j+1].getIcon()==pieces.get("pawn7-white")||
				     squares[i-1][j+1].getIcon()==pieces.get("pawn8-white")){
				    
				     return true;
				        }
			}

		}
		return false;
	}
	private void checkingSquareForKing(int i, int j){
		int wx = getXking_white(), wy = getYking_white();
		int bx = getXking_black(), by = getYking_black();

           if(isWhite(i,j)==false){
           	  for(int d=bx-1; d<=bx+1; d++){
           	  	 for(int y=by-1; y<=by+1; y++){
           	  	 	if(d<=7&&d>=0&&y<=7&&y>=0){
           	  	 		if(pointingToCheck(d, y, 1)==true||isIconThere(d, y)==true){
           	  	 			if(squares[d][y].piece!="king-black"){
           	  	 				squares[d][y].setBackground(Color.BLUE);

       	  	 				}
           	  	 			
           	  	 		}
           	  	 	}
           	  	 }
           	  }
           	    
           }else if(isWhite(i,j)==true){

           		for(int n=wx-1; n<=wx+1; n++){
           	  		for(int s=wy-1; s<=wy+1; s++){
           	  	 		if(n<=7&&n>=0&&s<=7&&s>=0){
           	  	 			if(pointingToCheck(n, s, 0)==true||isIconThere(n, s)==true){
           	  	 				if(squares[n][s].piece!="king-white"){
           	  	 					squares[n][s].setBackground(Color.ORANGE);
           	  	 				}
           	  	 				
           	  	 			}
           	  	 		}
           	  		}
           	    }
	       	    	       	    
           }
           	
	}
	// private void checkMate(){
	// 	int wx = getXking_white(), wy = getYking_white();
	// 	int bx = getXking_black(), by = getYking_black();
	// 	if(squares[bx-1][by-1].getBackground()==Color.BLUE&&squares[bx][by-1].getBackground()==Color.BLUE&&squares[bx+1][by-1].getBackground()==Color.BLUE&&
	// 		squares[bx-1][by].getBackground()==Color.BLUE&&squares[bx+1][by].getBackground()==Color.BLUE&&squares[bx-1][by+1].getBackground()==Color.BLUE&&
	// 		squares[bx][by+1].getBackground()==Color.BLUE&&squares[bx+1][by+1].getBackground()==Color.BLUE){
	// 		JLable label = new JLable("CHECKMATE FOR THE BLACK KING \n WHITES ARE WINNERS");
	// 	         label.set

	// 	}else if(squares[wx-1][wy-1].getBackground()==Color.PINK&&squares[wx][wy-1].getBackground()==Color.PINK&&squares[wx+1][wy-1].getBackground()==Color.PINK&&
	// 			 squares[wx-1][wy].getBackground()==Color.PINK&&squares[wx+1][wy].getBackground()==Color.PINK&&squares[wx-1][wy+1].getBackground()==Color.PINK&&
	// 		 	 squares[wx][wy+1].getBackground()==Color.PINK&&squares[wx+1][wy+1].getBackground()==Color.PINK){

	// 	}
	// }

	private void submit(){
		k = getXis();
		l = getYxis();
		
		if(isWhite(k,l)==false){
			tf1.setText("the black checks till now: "+checksFigure());
			System.out.println(white+checksFigure());
		}else{
			tf2.setText("the white checks till now: "+checksFigure());
		}
	}


	private void movePiece(int i, int j){
		if(first==null){
			first=squares[i][j];
			setXis(i);
			setYxis(j);
			
			
			
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
			if(first.getBackground()==Color.RED){
				if ((k % 2 == 1 && l % 2 == 1)|| (k % 2 == 0 && l % 2 == 0)) {
                    first.setBackground(Color.WHITE);
                } else {
                    first.setBackground(Color.BLACK);
                }
			}
			for(int d=0;d<8;d++){
				for(int y=0;y<8;y++){
					if(squares[y][d].getBackground()==Color.ORANGE||squares[y][d].getBackground()==Color.BLUE){
						if ((y % 2 == 1 && d % 2 == 1)|| (y % 2 == 0 && d % 2 == 0)) {
                    		squares[y][d].setBackground(Color.WHITE);
		                } else {
		                    squares[y][d].setBackground(Color.BLACK);
		                }
					}
				}
			}
			// check();

			if(i==k&&j==l){
				// Square second = squares[i][j];
				// second.setPiece(first.getPiece());
				// second.setIcon(pieces.get(second.getPiece()));
				// first.setPiece(null);
				// first.setIcon(new ImageIcon(
	   //                  	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				first = null;
			}
			
			if(squares[k][l].getIcon()==pieces.get("knight1-black")||squares[k][l].getIcon()==pieces.get("knight1-white")||
				squares[k][l].getIcon()==pieces.get("knight2-black")||squares[k][l].getIcon()==pieces.get("knight2-white")){

				if((i==k-1&&j==l-2)||(i==k+1&&j==l-2)||(i==k-2&&j==l-1)||(i==k+2&&j==l-1)||
				   (i==k-2&&j==l+1)||(i==k+2&&j==l+1)||(i==k-1&&j==l+2)||(i==k+1&&j==l+2)){    // this is for the horse movements
	        	
	        		if(isIconThere(i,j)==true){
	        			if((isWhite(k,l)==true&&isWhite(i,j)==false)||(isWhite(k,l)==false&&isWhite(i,j)==true)){
	        				Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
							setPreX(i);
							setPreY(j);
							if(isWhite(i,j)==true&&squares[i][j].piece=="knight1-white"){
								setXknight1_white(i);
								setYknight1_white(j);
							}else if(isWhite(i,j)==true&&squares[i][j].piece=="knight2-white"){
								setXknight2_white(i);
								setYknight2_white(j);
							}else if(isWhite(i,j)==false&&squares[i][j].piece=="knight1-black"){
								setXknight1_black(i);
								setYknight1_black(j);
							}else {
								setXknight2_black(i);
								setYknight2_black(j);
							}
							check();
                             
	        			}else{
	        				first = null;
	        			}

	        		}else{
	        			Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
						setPreX(i);
						setPreY(j);
						if(isWhite(i,j)==true&&squares[i][j].piece=="knight1-white"){
								setXknight1_white(i);
								setYknight1_white(j);
							}else if(isWhite(i,j)==true&&squares[i][j].piece=="knight2-white"){
								setXknight2_white(i);
								setYknight2_white(j);
							}else if(isWhite(i,j)==false&&squares[i][j].piece=="knight1-black"){
								setXknight1_black(i);
								setYknight1_black(j);
							}else {
								setXknight2_black(i);
								setYknight2_black(j);
							}
						check();
						
	        		}
	        		
					
				}
			}

			 if(squares[k][l].getIcon()==pieces.get("pawn1-black")||squares[k][l].getIcon()==pieces.get("pawn1-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn2-black")||squares[k][l].getIcon()==pieces.get("pawn2-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn3-black")||squares[k][l].getIcon()==pieces.get("pawn3-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn4-black")||squares[k][l].getIcon()==pieces.get("pawn4-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn5-black")||squares[k][l].getIcon()==pieces.get("pawn5-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn6-black")||squares[k][l].getIcon()==pieces.get("pawn6-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn7-black")||squares[k][l].getIcon()==pieces.get("pawn7-white")||
			 	squares[k][l].getIcon()==pieces.get("pawn8-black")||squares[k][l].getIcon()==pieces.get("pawn8-white")){	

			      // this is for the pawns movements
                
  

				if((i==k+1 && j==l&&k<8)||(i==k-1&&j==l&&k>=0)||(k==6&&i==k-2||k==1&&i==k+2)){       // this is for the pawns movements
	                
	                if(isIconThere(i,j)==false && noBackStep(i,j)==true){
				
		        		Square second = squares[i][j];
						second.setPiece(first.getPiece());
						second.setIcon(pieces.get(second.getPiece()));
						first.setPiece(null);
						first.setIcon(new ImageIcon(
			                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
						first = null;
						setPreX(i);
						setPreY(j);
						check();
					}else{
						first = null;
					}
                }else if((i==k+1&&j==l-1||i==k+1&&j==l+1)||(i==k-1&&j==l-1||i==k-1&&j==l+1)){
					if(isIconThere(i,j)==true){
						if((isWhite(k,l)==true&&isWhite(i,j)==false)||(isWhite(k,l)==false&&isWhite(i,j)==true)){
			        		Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
							setPreX(i);
							setPreY(j);
							check();
						}else{
							first = null;
						}
					}else{
						first = null;
					}
				}else{
					first = null;
				}

				// break;
			// }
			}		


			// for the queen movements
                
            if(squares[k][l].getIcon()==pieces.get("queen-black")||squares[k][l].getIcon()==pieces.get("queen-white")){
                if((i<=k-1&&j<=l-1&&i-k==j-l)||(i>=k+1&&j<=l-1&&k-i==j-l)||(i<=k-1&&j>=l+1&&i-k==l-j)||
                   (i>=k+1&&j>=l+1&&k-i==l-j)||(i>=0&&i<=7&&j==l)||(i==k&&j>=0&&j<=7)){	
 	
					if(isIconInWay(i,j,k,l)==false){
						if(isIconThere(i,j)==true){
							if(isWhite(k,l)==true&&isWhite(i,j)==false){
								Square second = squares[i][j];
								second.setPiece(first.getPiece());
								second.setIcon(pieces.get(second.getPiece()));
								first.setPiece(null);
								first.setIcon(new ImageIcon(
					                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
								first = null;
								setPreX(i);
								setPreY(j);
								check();
							}else if(isWhite(k,l)==false&&isWhite(i,j)==true){
								Square second = squares[i][j];
								second.setPiece(first.getPiece());
								second.setIcon(pieces.get(second.getPiece()));
								first.setPiece(null);
								first.setIcon(new ImageIcon(
					                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
								first = null;
								setPreX(i);
								setPreY(j);
								check();
							}else{
								first = null;
							}
						}else{
							Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
							setPreX(i);
							setPreY(j);
							check();
						}
		        		
					}else{
						first = null;
					}

				}else{
					first = null;
				}
			}


			// for the king movements


			 if(squares[k][l].getIcon()==pieces.get("king-black")||squares[k][l].getIcon()==pieces.get("king-white")){
	                if((i==k+1 && j==l) || (i==k-1 && j==l) || (i==k && j==l+1) || (i==k && j==l-1) || (i==k+1 && j==l+1) || (i==k+1 && j==l-1) || (i==k-1 && j==l-1) || (i==k-1 && j==l+1) ){		
			        	if(isIconThere(i,j)==true){
	                		if((isWhite(k,l)==true&&isWhite(i,j)==false)||(isWhite(k,l)==false&&isWhite(i,j)==true)){		
				        		Square second = squares[i][j];
								second.setPiece(first.getPiece());
								second.setIcon(pieces.get(second.getPiece()));
								first.setPiece(null);
								first.setIcon(new ImageIcon(
					                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
								first = null;
								if(isWhite(i,j)==true){
									setXking_white(i);
									setYking_white(j);

								}else{
									setXking_black(i);
									setYking_black(j);
								}
								checkingSquareForKing(i,j);
							}else{
								first = null;
							}
						}else{
							Square second = squares[i][j];
							second.setPiece(first.getPiece());
							second.setIcon(pieces.get(second.getPiece()));
							first.setPiece(null);
							first.setIcon(new ImageIcon(
				                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
							first = null;
							if(isWhite(i,j)==true){
								setXking_white(i);
								setYking_white(j);
							}else{
								setXking_black(i);
								setYking_black(j);
							}
							checkingSquareForKing(i,j);
						}

	                }else{
	                	first = null;
	                }
			 }

			// for the rook movements	 

			 // if(first.getIcon()==pieces.get("rook1-black") || first.getIcon()==pieces.get("rook1-white") || (first.getIcon()==pieces.get("rook2-black") || first.getIcon()==pieces.get("rook2-white"))){
	   //              if((i<k && j==l) || (i>k && j==l) || (i==k && j<l) || (i==k && j>l)){		
			 //        		Square second = squares[i][j];
				// 			second.setPiece(first.getPiece());
				// 			second.setIcon(pieces.get(second.getPiece()));
				// 			first.setPiece(null);
				// 			first.setIcon(new ImageIcon(
				//                     	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				// 			first = null;
				// 			check();
	   //              }
			 // }

				// for the bishop movements	

			 // if(first.getIcon()==pieces.get("bishop1-black") || first.getIcon()==pieces.get("bishop1-white") || (first.getIcon()==pieces.get("bishop2-black") || first.getIcon()==pieces.get("bishop2-white"))){
	   //              if((i<k && j<l) || (i>k && j>l) || (i>k && j<l) || (i<k && j>l)){
	   //              	if(isIconThere(i,j)==true){
	   //              		if((isWhite(k,l)==true&&isWhite(i,j)==false)||(isWhite(k,l)==false&&isWhite(i,j)==true)){		
				//         		Square second = squares[i][j];
				// 				second.setPiece(first.getPiece());
				// 				second.setIcon(pieces.get(second.getPiece()));
				// 				first.setPiece(null);
				// 				first.setIcon(new ImageIcon(
				// 	                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				// 				first = null;
				// 				check();
				// 			}else{
				// 				first = null;
				// 			}
				// 		}else{
				// 			first = null;
				// 		}

	   //              }else{
	   //              	first = null;
	   //              }
			 // }	


					 

		}
	}
	  

	public static void main(String[] args){
		EventQueue.invokeLater(() ->{
            Gui gui = new Gui();
            gui.setVisible(true);
        });
	}

}
