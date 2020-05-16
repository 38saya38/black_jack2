package black_jack;

import java.util.Scanner;

public class MainGame {
	public static void main(String[] args) {
		System.out.println("ブラックジャックへようこそ！");

		Deck deck = new Deck();
		//deck.printAll(); //デバック用

		Player player = new Player(20000); //プレイヤーを作成し初期値を設定
		Player dealer = new Player(); //ディーラーを作成し初期値を設定

//		try (Scanner scan = new Scanner(System.in);) {
//			while (true) {
//				//プレイヤーは賭け金を設定する
//				System.out.println("賭け金を決めてください");
//				//キーボードの入力を受け付けて、変数strに代入する
//				String str = scan.next();
//				int bet = Integer.parseInt(str);
//
//				if


		//プレイヤー・ディーラーがカードを2枚引く
		player.add(deck.pop());
		dealer.add(deck.pop());
		player.add(deck.pop());
		dealer.add(deck.pop());

		//プレイヤー・ディーラーの手札を表示
		System.out.println("貴方の1枚目のカードは" + player.get(0) + "です");
		System.out.println("ディーラーの1枚目のカードは" + dealer.get(0) + "です");
		System.out.println("貴方の2枚目のカードは" + player.get(1) + "です");
		System.out.println("ディーラーの2枚目のカードは秘密です");

		System.out.println("あなたの現在のポイントは" + player.sumPoint() + "です");

		//プレイヤーがカードを引くフェーズ
		try (Scanner scan2 = new Scanner(System.in);) {
			while (true) {
				System.out.println("カードを引きますか？ Yes:y or No:n");
				//キーボードの入力を受け付けて、変数str2に代入する
				String str2 = scan2.next();

				if ("n".equals(str2)) {
					break;
				} else if ("y".equals(str2)) {
					//手札に山札から1枚加える
					int index = player.add(deck.pop());
					System.out.println("あなたの" + (index + 1) + "枚目のカードは" + player.get(index) + "です");
					System.out.println("現在の合計は" + player.sumPoint() + "です");
					//プレイヤーのバーストチェック
					if (player.isBusted()) {
						System.out.println("残念、バーストしてしまいました。ディーラーの勝ちです。");
						return;
					}
				} else {
					System.out.println("あなたの入力は"
							+ str2 + "です。y か n を入力してください。");
				}
			}
		}

		System.out.println("ディーラーの2枚目のカードは" + dealer.get(1) + "です");
		//ディーラーが手札を17以上にするまでカードを引くフェーズ
		while (dealer.sumPoint() < 17) {
			//手札に山札から1枚加える
			int index = dealer.add(deck.pop());
			System.out.println("ディーラーの" + (index + 1) + "枚目のカードは" + dealer.get(index) + "です");
			//ディーラーのバーストチェック
			if (dealer.isBusted()) {
				System.out.println("ディーラーがバーストしました。あなたの勝ちです！");
				return;
			}
		}

		//ポイントを比較する
		System.out.println("あなたのポイントは" + player.sumPoint() + "です");
		System.out.println("ディーラーのポイントは" + dealer.sumPoint() + "です");

		if (player.sumPoint() == dealer.sumPoint()) {
			System.out.println("引き分けです。");
		} else if (player.sumPoint() > dealer.sumPoint()) {
			System.out.println("勝ちました！");
		} else {
			System.out.println("負けました・・・");
		}
	}
}
