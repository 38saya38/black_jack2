package black_jack;

import java.util.ArrayList;
import java.util.List;

class Player {

	private int cash; //手持ちのポイント
	private int bet; //掛け金

	public Player() {
		cash = 20000; //プレイヤーの手持ちの初期値は20000;
		bet = 1000; //プレイヤーの賭け金の初期値は1000;
	}

	public Player(int dealerPoint,int dealerBet ) {
		cash = dealerPoint; //ディーラーの手持ちの初期値は0;
		bet = dealerBet; //ディーラーに賭け金は存在しないので0に設定;
	}


	  private List<Card> cardList = new ArrayList<>(); //手札
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
	    for(Card card : cardList) sum += card.getPoint();
	    if(hasAce() && sum+10 <= 21) sum += 10;
	    return sum;
	  }
	  /** A を持っているか */
	  private boolean hasAce() {
	    for(Card card : cardList) {
	      if(card.getPoint() == 1) return true;
	    }
	    return false;
	  }
	  /**
	   * 手札がバーストしているか
	   */
	  boolean isBusted() {
	    return sumPoint() > 21;
	  }


	}

