import java.util.ArrayList;
import java.util.List;

public class LadderGame {

	private static final int heightOfLadder = 10;

	private static List<Position> steps;

	public LadderGame() {
		steps = new ArrayList<Position>();
	}

	/**
	 * 말을 사다리의 끝까지 움직입니다.
	 * 특정 위치의 말을 파라미터로 받고 모든 이동 후 사다리(col) 번호를 반환합니다.
	 * @param horse
	 * @return ladder #
	 */
	public int moveAllStep(Horse horse) {
		
		while(null != moveOneStep(horse));
		
		Position result = horse.getPosition();
		
		return result.getCol();
	}

	/**
	 * 말을 앞으로 한 칸 움직이고 연결된 다른 사다리로 이동합니다.
	 * 특정 위치의 말을 파라미터로 받고 이동 후 위치를 반환합니다.
	 * 만약 사다리를 다 내려왔다면 null을 반환합니다.
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
