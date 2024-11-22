public class Player  extends Entity{// this class inherits the Entity class which means we can use entitys methods.
	private int x;
	private int y;
	final int moveDistance;// how many pixels it moves per click
	
	public Player(int startX, int startY, int moves) {
		super(startX,startY);
		this.moveDistance = moves;
		this.y = startY;
		this.x = startX;
		
		
	}
	public void move() // this will be used to move the pos and distance of the player each click.
	{
		this.x += moveDistance;
	}

}
