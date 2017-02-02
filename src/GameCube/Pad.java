package GameCube;

public class Pad {

	private int x = 0;
	private int y = 0;
	private int xTam;
	private int yTam;
	
	
	public Pad(int x, int y){
		this.x = x;
		this.y = y;
		this.xTam = x + 15; 
		this.yTam = y + 80;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getxTam() {
		return xTam;
	}


	public void setxTam(int xTam) {
		this.xTam = xTam;
	}


	public int getyTam() {
		return yTam;
	}


	public void setyTam(int yTam) {
		this.yTam = yTam;
	}
	
	
	
}
