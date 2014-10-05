public class Position {

	private int row;
	private int col;

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Position))
			return false;

		Position pos = (Position) obj;
		if (row != pos.getRow() || col != pos.getCol())
			return false;
		
		return true;
	}

	public void addRow() {
		this.row++;
	}

	public void addCol() {
		this.col++;
	}

	public void subCol() {
		this.col--;
	}

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
