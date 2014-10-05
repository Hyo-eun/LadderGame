
public class Horse {
	
	private Position position;
	
	public Horse(int col) {
		position = new Position(0, col);
	}
	
	public void moveForward() {
		position.addRow();
	}
	
	public void moveLeft() {
		position.subCol();
	}
	
	public void moveRight() {
		position.addCol();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
