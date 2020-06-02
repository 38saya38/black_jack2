package black_jack;

/**
 * プレイヤーの動きをまとめたクラス
 *
 * @author Saya Tobari
 *
 */

import java.util.ArrayList;
import java.util.List;

class Player {

	/**
	 * プレイヤーの手札
	 */
	private List<Card> cardList = new ArrayList<>();

	/**
	 * カード追加
	 * @param card
	 * @return 最後に追加したindex (0-)
	 */
	int add(Card card) {
		cardList.add(card);
		return cardList.size() - 1;
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
		int sum = 0;
		for (Card card : cardList)
			sum += card.getPoint();
		if (hasAce() && sum + 10 <= 21)
			sum += 10;
		return sum;
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
//	 * 手札を増やしていく
//	 */
//	  int drawCard() {
//			int index = player.add(deck.pop());
//			System.out.println("あなたの" + (index + 1) + "枚目のカードは" + player.get(index) + "です");
//			System.out.println("現在の合計は" + player.sumPoint() + "です\n");
//			System.out.println("次の手を選択してください。\nカードを引く:h\nこの手札で勝負する:s\n降参する:l");
//		return;
//	}

	/**
	 * 現在の手持ち金を表示
	 */
	public int nowCash() {
		return cash;
	}

	/**
	 *プレイヤーの手持ち金から賭け金を引く
	 */
	int loseCash() {
		return cash;
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
