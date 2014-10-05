import java.util.Scanner;

public class GameDaemon {

	private static final LadderGame game = new LadderGame();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		setupGame();

		while (true) {
			System.out.print("말의 번호를 입력하세요(말 : 1~6, 종료 : 0)\n > ");
			int horseNum = getOneInput();

			if (horseNum == 0)
				break;
			else if (horseNum > 6) {
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요.\n > ");
				continue;
			}

			int result = game.moveAllStep(new Horse(horseNum));
			System.out.println("결과 : " + result);
		}
		System.out.println("사다리게임을 종료합니다.");
	}

	private static int getOneInput() {
		String token = scanner.next();
		int input = Integer.parseInt(token);
		return input;
	}
	
	private static void setupGame() {

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

}
