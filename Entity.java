public class Entity {
	private int x;
	private int y;
	
	public Entity(int startX, int startY)// this is the constructor and this class will have the entitys starting position
	{
		this.x = startX;
		this.y = startY;
	}

	public int getX() {
		return x;
	}
	public int getY()
	{
		return y;
	}
}