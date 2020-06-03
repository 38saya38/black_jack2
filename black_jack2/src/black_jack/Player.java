package black_jack;

/**
 * プレイヤーの動きをまとめたクラス
 *
 * @author Saya Tobari
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {

	/**プレイヤーの手札*/
	private List<Card> cardList = new ArrayList<>();
	/**手持ち金*/
	private int cash;
	/**掛け金 */
	private int bet;
	/**ゲームで得た金額*/
	private int getCash;
	/**プレイヤーが入力した値*/
	private int number;
	/**プレイヤーのポイント*/
	private int point;

	Player(int cash) {
		this.cash = cash;
	}

	/**
	 * betを決め、出力するメソッド
	 * @param
	 */
	void betInput() {
		System.out.println("現在の手持ち金は" + this.cash + "です。\n" + Constans.BET_DECITION_MASSAGE);
		while (true) {
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			int bet = Integer.parseInt(str);
			if (bet < 1000) {
				System.out.println(Constans.NOT_1000OVER_MASSAGE);
			} else if (bet > cash) {
				System.out.println(Constans.OVER_BET_MASSAGE);
			} else {
				System.out.println("\n賭け金を" + bet + "に設定");
				int cash = this.cash - bet;
				System.out.println("手持ち金は" + cash + "になりました\n");
				break;
			}
		}
	}

	/**
	 * 最初プレイヤー手札にカードを追加するメソッド。
	 * @param card
	 * @return 最後に追加したindex (0-)
	 */
	int add(Card card) {
		cardList.add(card);
		return cardList.size() - 1;
	}

	/**
	 * 最初のプレイヤー手札を表示するメソッド
	 * @param card
	 *
	 */
	void addShow() {
		System.out.println("あなたの1枚目のカードは" + cardList.get(0) + "です");
		System.out.println("あなたの2枚目のカードは" + cardList.get(1) + "です");
		}

	/**
	 * カード読出
	 * @param index (0-)
	 * @return
	 */
	Card get(int index) {
		return cardList.get(index);
	}

	/**
	 * 現在の合計ポイント
	 */
	int sumPoint() {
		point = 0;
		for (Card card : cardList)
			point += card.getPoint();
		if (hasAce() && point + 10 <= 21)
			point += 10;
		return point;
	}

	/** A を持っているか */
	public boolean hasAce() {
		for (Card card : cardList) {
			if (card.getPoint() == 1)
				return true;
		}
		return false;
	}

	/**
	 * 手札がバーストしているか
	 */
	boolean isBusted() {
		return sumPoint() > 21;
	}

	/**
	 * 次の手を指定するためのメソッド
	 */
	void selectHand() {
		System.out.println("あなたの現在のポイントは" + point + "です");
		System.out.println(Constans.URGE_MASSAGE);
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int select = Integer.parseInt(str);
		while(select != 1) {

		}
		return ;
		}




	/**
	 *プレイヤーの手持ち金が1000以下になっていないか判定するメソッド
	 */
	boolean isContinue() {
		return cash > 1000;
	}

	//	/**
	//	 *ゲームに勝った時、プレイヤーに配当する
	//	 */
	//	public static int addCash(int cash) {
	//		int dividend = this.cash;
	//		return cash;
	//	}

	//	  /**
	//	   * プレイヤーの引いた手札が同じ数だった場合
	//	   * ふた山に分けることができる。betはそれぞれにかかる。
	//	   * @return
	//	   */
	//	  static Card sprit() {
	//
	//		  return;
	//		}
	//
	//	  /**
	//	   * ディーラーの１枚目の手札がAだった場合、選択できる。賭け金の
	//	   * 半額をbetし、ディーラーがブラックジャックだった場合
	//	   * 賭け金が戻ってくる
	//	   * @return
	//	   */
	//	  static Card insurance() {
	//		  return;
	//		}
	//
	//	  /**
	//	   * プレイヤーはカードを１枚だけ引く代わりに
	//	   * 賭け金を倍にできる
	//	   * @return
	//	   */
	//	  static Card doubleDown() {
	//		  return;
	//		}

	/**
	 * プレイヤーに配られた２枚の手札では勝てそうもないと判断した時
	 * betの半額を回収し、そのゲームを放棄できる
	 * @return
	 */
	public static void surrender() {
		System.out.println("降参しました。賭け金の半額"
				+ "が戻ってきます。ディーラーの勝ちです。");
		System.exit(0);
	}

}
