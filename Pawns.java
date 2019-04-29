

public class Pawns{
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
	 		switch (i){
				case 1:
					if(i==k+1&&j==l){       // this is for the pawns movements
	                
	                reachingPoint = squares[i][j];
					reachingPoint.setPiece(originPoint.getPiece());
					reachingPoint.setIcon(pieces.get(reachingPoint.getPiece()));
					originPoint.setPiece(null);
					originPoint.setIcon(new ImageIcon(
		                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					originPoint = null; 
					}
				break;
                case 6:
	                if(i==k-1&&j==l){       // this is for the pawns movements
	                
	                reachingPoint = squares[i][j];
					reachingPoint.setPiece(first.getPiece());
					reachingPoint.setIcon(pieces.get(second.getPiece()));
					originPoint.setPiece(null);
					originPoint.setIcon(new ImageIcon(
		                    	new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					originPoint = null; 
					}
				break;
			}
		}
	}
}