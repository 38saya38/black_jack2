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
	/**スプリットで使うプレイヤーの手札*/
	private List<Card> spritCardList = new ArrayList<>();
	/**手持ち金*/
	private int cash;
	/**掛け金 */
	private int bet;
	/**スプリットで使う掛け金 */
	private int spritBet;
	/**ゲームで得た配当*/
	private int getCash;
	/**プレイヤーが入力した値*/
	private int select;
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
				this.bet = bet;
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
	 * 最初プレイヤー手札にカードを追加するメソッド。
	 * @param card
	 * @return 最後に追加したindex (0-)
	 */
	int spritAdd(Card card) {
		System.out.println(Constans.DRAW_CARD_MASSAGE);
		spritCardList.add(card);
		return spritCardList.size() - 1;
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

	//	/**
	//	 * 手札が2枚とも同じ数pointか
	//	 */
	//	boolean isSame() {
	//
	//
	//	}

	/**
	 * 次の手を促すためのメッセージを表示するメソッド
	 */
	void selectHandShow() {
		System.out.println("\nあなたの現在のポイントは" + point + "です");
			System.out.println(Constans.URGE_MASSAGE);
			System.out.println(Constans.HIT_MASSAGE);
			System.out.println(Constans.STAND_MASSAGE);
			System.out.println(Constans.DOUBLE_DOWN_MASSAGE);
	}

	/**
	 * 次の手を指定するためのメソッド
	 */
	int selectHand() {
		try {
//			System.out.println(Constans.HIT_MASSAGE);
//			System.out.println(Constans.STAND_MASSAGE);
//			System.out.println(Constans.DOUBLE_DOWN_MASSAGE);
//			System.out.println(Constans.SURRENDER_MASSAGE);
//			System.out.println(Constans.SPRIT_MASSAGE);
//			System.out.println(Constans.URGE_MASSAGE);
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			select = Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(Constans.ERROR_MASSAGE);
			System.exit(0);
		}
		return select;
	}

	/**
	 *プレイヤーの手持ち金が1000以下になっていないか判定するメソッド
	 */
	boolean isContinue() {
		return cash > 1000;
	}

	/**
	 * プレイヤーの引いた手札が同じ数だった場合
	 * ふた山に分けることができる。betはそれぞれにかかる。
	 * @return
	 */
	void sprit() {
		spritBet = bet;
		cash = cash - spritBet;
		System.out.println(Constans.SPRIT_MASSAGE + "\n betは2つ合わせて"
				+ (bet + spritBet) + "になりました。");
		return;
	}

	/**
	 * ディーラーの１枚目の手札がAだった場合、選択できる。賭け金の
	 * 半額をbetし、ディーラーがブラックジャックだった場合
	 * 賭け金が戻ってくる
	 * @return
	 */
	void insurance() {
		bet = bet / 2;

		return;
	}

	/**
	 * add(); でカードを1枚だけ引く代わりに
	 * 配当を倍にできる
	 * @return
	 */
	void doubleDown() {
		getCash = bet * 3;
	}

	/**
	 * プレイヤーに配られた２枚の手札では勝てそうもないと判断した時
	 * betの半額を回収し、そのゲームを放棄できる
	 * @return
	 */
	void surrender() {
		System.out.println("降参しました。賭け金の半分" + (bet / 2) + "が戻ってきます。ディーラーの勝ちです。");
		cash = bet / 2;
		System.exit(0);
	}

}
