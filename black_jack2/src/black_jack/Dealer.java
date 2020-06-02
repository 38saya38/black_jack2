package black_jack;

import java.util.ArrayList;
import java.util.List;

public class Dealer{

	/**ディーラーのカードリスト */
	private List<Card> dealerCardList = new ArrayList<>();


	/**
	   * カード追加
	   * @param card
	   * @return 最後に追加したindex (0-)
	   */
	  int add(Card card) {
	    dealerCardList.add(card);
	    return dealerCardList.size() - 1;
	  }
	  /**
		 * 最初のディーラーの手札を表示するメソッド
		 * @param card
		 *
		 */
		void addShow() {
			System.out.println("ディーラーの1枚目のカードは" + dealerCardList.get(0) + "です");
			System.out.println(Constans.DEALER_SECOND_CARD_MASSAGE);
			}
	  /**
	   * カード読出
	   * @param index (0-)
	   * @return
	   */
	  Card get(int index) {
	    return dealerCardList.get(index);
	  }
	  /**
	   * 現在の合計ポイント
	   */
	  int sumPoint() {
	    int sum = 0;
	    for(Card card : dealerCardList) sum += card.getPoint();
	    if(hasAce() && sum+10 <= 21) sum += 10;
	    return sum;
	  }
	  /** A を持っているか */
	  public boolean hasAce() {
	    for(Card card : dealerCardList) {
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
