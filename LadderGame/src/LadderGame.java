import java.util.ArrayList;
import java.util.List;

public class LadderGame {

	private static final int heightOfLadder = 10;

	private static List<Position> steps;

	public LadderGame() {
		steps = new ArrayList<Position>();
	}

	/**
	 * ���� ��ٸ��� ������ �����Դϴ�.
	 * Ư�� ��ġ�� ���� �Ķ���ͷ� �ް� ��� �̵� �� ��ٸ�(col) ��ȣ�� ��ȯ�մϴ�.
	 * @param horse
	 * @return ladder #
	 */
	public int moveAllStep(Horse horse) {
		
		while(null != moveOneStep(horse));
		
		Position result = horse.getPosition();
		
		return result.getCol();
	}

	/**
	 * ���� ������ �� ĭ �����̰� ����� �ٸ� ��ٸ��� �̵��մϴ�.
	 * Ư�� ��ġ�� ���� �Ķ���ͷ� �ް� �̵� �� ��ġ�� ��ȯ�մϴ�.
	 * ���� ��ٸ��� �� �����Դٸ� null�� ��ȯ�մϴ�.
	 * @param horse
	 * @return position
	 */
	public Position moveOneStep(Horse horse) {

		Position currentPos = horse.getPosition();
		
		if (heightOfLadder < currentPos.getRow())
			return null;

		horse.moveForward();
		moveHorizonIfStepExists(horse);

		return horse.getPosition();
	}

	private void moveHorizonIfStepExists(Horse horse) {

		Position currentPos = horse.getPosition();

		if (hasRightStepFrom(currentPos))
			horse.moveRight();
		else if (hasLeftStepFrom(currentPos))
			horse.moveLeft();
	}

	private boolean hasRightStepFrom(Position pos) {
		return steps.contains(pos);
	}

	private boolean hasLeftStepFrom(Position pos) {
		Position leftPos = new Position(pos.getRow(), pos.getCol() - 1);
		return steps.contains(leftPos);
	}

	public void addStep(int row, int col) {
		steps.add(new Position(row, col));
	}
}
