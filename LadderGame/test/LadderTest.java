import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LadderTest {

	private LadderGame game;

	@Before
	public void setupGame() {
		game = new LadderGame();

		game.addStep(1, 1);
		game.addStep(6, 1);
		game.addStep(9, 1);

		game.addStep(3, 2);
		game.addStep(5, 2);
		game.addStep(8, 2);

		game.addStep(4, 3);
		game.addStep(7, 3);
		game.addStep(10, 3);
		
		game.addStep(2, 4);
		game.addStep(6, 4);
		game.addStep(8, 4);

		game.addStep(3, 5);
		game.addStep(5, 5);
		game.addStep(7, 5);

	}

	@Test
	public void getAGameResult() {
		Horse horse1 = new Horse(1);
		Horse horse2 = new Horse(2);
		
		int result1 = game.moveAllStep(horse1);
		int result2 = game.moveAllStep(horse2);
		
		assertThat(result1, is(6));
		assertThat(result2, is(4));
	}
	
	@Test public void moveForwardFrom() {
		Horse horse = new Horse(5);
		horse.setPosition(new Position(1, 5));
		
		Position result = game.moveOneStep(horse);
		
		assertThat(result.getRow(), is(2));
		assertThat(result.getCol(), is(4));
	}

}
