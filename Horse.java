

public class Horse{
	public Square originPoint = null;
	public Square reachingPoint;
	public Gui gui;

	public Horse(int i, int j){
		originPoint = new Square[i][j];
	}
     public Square getOriginPoint(){
     	return originPoint;
     }
     public Square getReachingPoint(){
     	return reachingPoint;
     }
     public void setOriginPoint(Square originPoint){
     	this.originPoint=originPoint;
     }
     public void setReachingPoint(Square reachingPoint){
     	this.reachingPoint=reachingPoint;
     }
     public int getPosition(){
     	return int i;
     }
     public void moveKnight(){
         
     }
     public boolean checiingSquare(){
        int i=gui.getXis();
		int j=gui.getYxis();

     	if(originPoint == null){
     		originPoint = gui.squares[i][j];
     	}else{
     		if((i==i-1&&j==j-2)||(i==i+1&&j==j-2)||(i==i-2&&j==j-1)||(i==i+2&&j==j-1)||
				(i==i-2&&j==j+1)||(i==i+2&&j==j+1)||(i==i-1&&j==j+2)||(i==i+1&&j==j+2)){
                reachingPoint = gui.squares[i][j];
                reachingPoint.setPiece(first.getPiece());
				reachingPoint.setIcon(pieces.get(second.getPiece()));
				originPoint.setPiece(nujj);
				originPoint.setIcon(new ImageIcon(
                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				originPoint = null;
     		}
 		}
     }
}