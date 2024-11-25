public class NPC  extends Entity {//this class inherits the Entity class which means we can use entitys methods
	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;	
	private int speed;
	
	public NPC ( int startX, int startY, int Speed )
	{
		super(startX,startY);
		this.speed = Speed;
		this.x = startX;
		this.y = startY;
		
	}
	public void move() {
		x += speed; //this will move the npc when needed.
		System.out.println("NPC moved to: " + x); // Debug output
	}
}
