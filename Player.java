public class Player  extends Entity{// this class inherits the Entity class which means we can use entitys methods.
	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
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
		x += moveDistance;
		System.out.println("Player moved to: " + x); // Debug output
	}

}
