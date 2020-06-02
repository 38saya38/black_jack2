package black_jack;

public class BlackJackBean {

	/**手持ち金*/
	private int cash;
	/**掛け金 */
	private int bet;
	/**ゲームで得た金額*/
	private int getCash;


    public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public int getGetCash() {
		return getCash;
	}

	public void setGetCash(int getCash) {
		this.getCash = getCash;
	}
}
