package black_jack;

class Card {
  private static final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
  private static final String[] SUITS = {"クラブ","ダイヤ","ハート","スペード"};

  private int cardNumber; //1-52

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
  int getPoint() {
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

  public String toString() {
    return SUITS[getSuitIndex()] + "の" + RANKS[getRankIndex()];
  }

  /**
   * トランプの数字を得点計算用のポイントに変換するメソッド
   * J/Q/Kは10とする
   * @return 10
   */
  private static int toPoint(int num) {
	    if(num ==11||num == 12||num == 13) {
	        num = 10;
	    }
	    return num;
	}

  /**
   * プレイヤーの引いた手札が同じ数だった場合
   * ふた山に分けることができる。betはそれぞれにかかる。
   * @return
   */
  static Card sprit(int num) {

	  return;
	}

  /**
   * ディーラーの１枚目の手札がAだった場合、選択できる。賭け金の
   * 半額をbetし、ディーラーがブラックジャックだった場合
   * 賭け金が戻ってくる
   * @return
   */
  static Card insurance(int num) {
	  return;
	}
}