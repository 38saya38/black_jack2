package black_jack;

/**
 * カードの使用をまとめたクラス
 *
 * @author Saya Tobari
 *
 */

class Card {

	/**トランプの数字 */
	public static final String[] RANKS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	/**トランプのスート */
	public static final String[] SUITS = { "クラブ", "ダイヤ", "ハート", "スペード" };

	 int cardNumber; //1-52


	public static String[] getRanks() {
		return RANKS;
	}

	/**
	 * @param cardNumber 1-52
	 */
	Card(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 得点計算用
	 * @return 1-10
	 */
	public int getPoint() {
		return Math.min(getRankIndex() + 1, 10);
	}

	/**
	 * 数を絵札か数札に変換するメソッド
	 * @return 0-12
	 */
	private int getRankIndex() {
		return (cardNumber - 1) % 13;
	}

	/**数をスートに変換するメソッド
	 * @return 0-3
	 */
	private int getSuitIndex() {
		return (cardNumber - 1) / 13;
	}

	/**数を文字列に変換するメソッド
	 * @return
	 */
	public String toString() {
		return SUITS[getSuitIndex()] + "の" + RANKS[getRankIndex()];
	}


}