package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import constraints.CommonConstraints;
import constraints.MessageConstraints;
import constraints.NumberConstraints;

public class Sugoroku implements NumberConstraints,MessageConstraints,CommonConstraints {

	public static void main(String[] args) {
		//変数宣言
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		int diceNumber = 0;
		int location = 0;
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(PROPERTIES_FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(MESSAGE_SUGOROKU_START);

		//falseになるまでループする
		while (location < MASU_LENGTH) {
			//処理
			System.out.println(MESSAGE_PRESS_ENTER);
			//エンターを押すのを待つ。
			scanner.nextLine();
			//ダイスの目（1~6の乱数）
			diceNumber = rand.nextInt(DICE_EYE_MAX) + 1;
			System.out.println(diceNumber + MESSAGE_DICE_RESULT);
			//進んだ位置
			location += diceNumber;
			System.out.println(location + MESSAGE_FORWARD);
			//すごろく盤を表示
			showSugorokuBan(location);
			
			switch (location) {
			//2マス目に止まった場合
			case 2:
				System.out.println(MESSAGE_STOP);
				System.out.println(MESSAGE_FORWARD_ONE);
				//位置を1足す。
				location += 1;
				System.out.println(location + MESSAGE_FORWARD);
				//すごろく盤を表示
				showSugorokuBan(location);
				break;

			//5マス目に止まった場合
			case 5:

				System.out.println(MESSAGE_HOLE);
				//「スタートに戻りました。」と表示する。
				location = 0;
				System.out.println(MESSAGE_BACK_TO_START);
				//すごろく盤を表示
				showSugorokuBan(location);
				break;

			//8マス目に止まった場合
			case 8:
				System.out.println(MESSAGE_SNAKE);

				System.out.println(MESSAGE_BACK_TWO);
				//進んだ位置を2戻す。
				location -= 2;
				System.out.println(location + MESSAGE_FORWARD);
				//すごろく盤を表示
				showSugorokuBan(location);
				break;
			}

		}
		//ゴールした時
		if (location == 10) {
			System.out.println(MESSAGE_GOAL);
		}
		//ゴールできなかった時
		else {
			System.out.println(MESSAGE_GOAL_FAIL);
		}
		System.out.println(MESSAGE_SUGOROKU_END);
		scanner.close();
		
	}
	private static void showSugorokuBan(int location) {
		for (int i = 0; i <= 10; i++) {
			//盤の上に自分の現在位置を表示する
			if (i==location) {
				System.out.println(MASU_ME);
				//盤のますを表示する
			} else if (i==0){
				System.out.println(MASU_START);
			} else if (i == 2) {
				System.out.println(MASU_BRIDGE);
			}  else if (i == 5) {
				System.out.println(MASU_HOLE);
			} else if (i == 8) {
				System.out.println(MASU_SNAKE);
			}else if (i == 10) {
				System.out.println(MASU_GOAL);
			} else {
				System.out.println(MASU_NOTHING);
			}
		}
	}
}
