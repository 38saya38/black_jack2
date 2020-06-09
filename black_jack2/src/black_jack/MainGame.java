package black_jack;

public class MainGame {
	public static void main(String[] args) {
		try {
			System.out.println(Constans.START_MASSAGE);

			Player player = new Player(Constans.START_CASH);
			Dealer dealer = new Dealer();

			while (player.isContinue()) {
				player.betInput();
				Deck deck = new Deck();

				System.out.println(Constans.DRAW_CARD_MASSAGE);
				player.add(deck.pop()); //プレイヤーが1枚目のカードを引く
				player.add(deck.pop()); //プレイヤーが2枚目のカードを引く
				dealer.add(deck.pop()); //ディーラーが1枚目のカードを引く
				dealer.add(deck.pop()); //ディーラーが2枚目のカードを引く

				player.addShow();
				dealer.addShow();
				if (player.sumPoint() == 21) {
					System.out.println(Constans.BRACK_JACK_MASSAGE);
					break;
				} else {
					int select = 0;
					while(select == 2) {
						player.selectHandShow();
						dealer.InsuranceShow();

						player.spritShow();
						player.selectHand();
						break;
					}

				}

			}
		} catch (Exception e) {
			System.out.println(Constans.ERROR_MASSAGE);
			System.exit(0);
		}
	}
}

//	System.out.println("ブラックジャックへようこそ！");
//
//	Deck deck = new Deck();
//	//deck.printAll(); //デバック用
//
//	Player player = new Player();
//	Player dealer = new Player();
//
//	System.out.println("現在の手持ちは" + player.nowCash() + "です。賭け金を決めてください");
//
//	try {
//		while (true) {
//			Scanner scan = new Scanner(System.in);
//			//キーボードの入力を受け付けて、変数strに代入する
//			String str = scan.nextLine();
//			int bet = Integer.parseInt(str);
//			BlackJackBean.setBet(bet);
//			if (bet < 1000) {
//				System.out.println("賭け金は1000以上からです。設定し直してください");
//			} else if (bet > player.nowCash()) {
//				System.out.println("手持ち金以上を賭けることはできません。設定し直してください");
//			} else {
//				System.out.println("賭け金を" + bet + "に設定");
//				int cash = player.nowCash() - bet;
//				System.out.println("手持ち金は" + cash + "になりました\n");
//				break;
//			}
//		}
//	} catch (Exception e) {
//		System.out.println("正しく入力し直してください");
//	}
//
//	//プレイヤー・ディーラーがカードを2枚引く
//	player.add(deck.pop());
//	dealer.add(deck.pop());
//	player.add(deck.pop());
//	dealer.add(deck.pop());
//
//	//プレイヤー・ディーラーの手札を表示
//	System.out.println("貴方の1枚目のカードは" + player.get(0) + "です");
//	System.out.println("ディーラーの1枚目のカードは" + dealer.get(0) + "です");
//	System.out.println("貴方の2枚目のカードは" + player.get(1) + "です");
//	System.out.println("ディーラーの2枚目のカードは秘密です");
//	System.out.println("\nあなたの現在のポイントは" + player.sumPoint() + "です");
//
//	//プレイヤーがカードを引くフェーズ
//	try (Scanner scan2 = new Scanner(System.in);) {
//		System.out.println("次の手を選択してください。\nカードを引く:h\nこの手札で勝負する:s\n降参する:l");
//		//キーボードの入力を受け付けて、変数に代入する
//		String str2 = scan2.next();
//		while ("h".equals(str2)) {
//			if ("s".equals(str2)) { //stand処理
//				break;
//			} else if ("l".equals(str2)) { //surrender処理
//				Player.surrender();
//			} else if ("h".equals(str2)) {//hit処理
//				//手札に山札から1枚加える
//				int index = player.add(deck.pop());
//				System.out.println("あなたの" + (index + 1) + "枚目のカードは" + player.get(index) + "です");
//				System.out.println("現在の合計は" + player.sumPoint() + "です\n");
//				//プレイヤーのバーストチェック
//				if (player.isBusted()) {
//					System.out.println("残念、バーストしてしまいました。ディーラーの勝ちです。");
//					return;
//				} else {
//					if ("h".equals(str2) || "s".equals(str2) || "h".equals(str2)) {
//					} else {
//						System.out.println("あなたの入力は"
//								+ str2 + "です。正しく入力し直してください。");
//					}
//				}
//			}
//		}
//
//		System.out.println("ディーラーの3枚目のカードは" + dealer.get(1) + "です");
//		//ディーラーが手札を17以上にするまでカードを引くフェーズ
//		while (dealer.sumPoint() < 17) {
//			//手札に山札から1枚加える
//			int index = dealer.add(deck.pop());
//			System.out.println("ディーラーの" + (index + 2) + "枚目のカードは" + dealer.get(index) + "です");
//			System.out.println("ディーラーのポイントは" + dealer.sumPoint() + "です");
//			//ディーラーのバーストチェック
//			if (dealer.isBusted()) {
//				System.out.println("ディーラーがバーストしました。あなたの勝ちです！");
//				return;
//			}
//		}
//
//		//ポイントを比較する
//		System.out.println("\n" + "ディーラーのポイントは" + dealer.sumPoint());
//		System.out.println("あなたのポイントは" + player.sumPoint());
//
//		if (player.sumPoint() == dealer.sumPoint()) {
//			System.out.println("引き分けです。betが戻ってきます");
//		} else if (player.sumPoint() > dealer.sumPoint()) {
//			System.out.println("あなたの勝ちです！");
//		} else {
//			System.out.println("あなたの負けです・・・");
//		}
//	}
//}
//}
