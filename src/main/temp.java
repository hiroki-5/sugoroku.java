package main;

public class temp {

	public static void main(String[] args) {

		/*		System.out.println("| START  |");
				System.out.println("| 　　　  |");
				System.out.println("| 　橋　  |");
				System.out.println("| 　⭐ 　|");
				System.out.println("| 　　　  |");
				System.out.println("|   ●　  |");
				System.out.println("| 　　　  |");
				System.out.println("| 　　　  |");
				System.out.println("|   蛇　  |");
				System.out.println("| 　　　  |");
				System.out.println("|  GOAL   |"); */

		for (int i = 0; i <= 10; i++) {
			if (i == 0) {
				System.out.println("| START  |");
			} else if (i == 2) {
				System.out.println("| 　橋　  |");
			}  else if (i == 5) {
				System.out.println("| 　 ●　  |");
			} else if (i == 8) {
				System.out.println("| 　 蛇　  |");
			}else if (i == 10) {
				System.out.println("| 　GOAL　|");
			} else {
				System.out.println("| 　　　  |");
			}
		}
	}

}
