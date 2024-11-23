public class NPC  extends Entity {//this class inherits the Entity class which means we can use entitys methods
	@SuppressWarnings("unused")
	private  int x ;
	@SuppressWarnings("unused") // im adding supressed warning as it is a quick fix becaus eit keeps saying these variable are not bieng used.
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
		this.x += speed; //this will move the npc when needed.
	}
}
