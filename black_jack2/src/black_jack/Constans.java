package black_jack;

/**
 * 定数をまとめたクラス
 *
 * @author Saya Tobari
 *
 */

public class Constans {

	/**プレイヤーの初期手持ち金額 */
	public static final int START_CASH = 20000;

	/**ゲーム開始のメッセージ */
	public static final String START_MASSAGE = "ブラックジャックへようこそ";

	/**賭け金を決めるためのメッセージ*/
	public static final String BET_DECITION_MASSAGE = "賭け金を決めてください";

	/** 賭け金が1000以下だった場合のエラーメッセージ*/
	public static final String NOT_ENOUGH_MASSAGE = "賭け金は1000以上からです。設定し直してください";

	/**手持ち金以上をかけようとした時のエラーメッセージ*/
	public static final String OVER_BET_MASSAGE = "手持ち金以上を賭けることはできません。設定し直してください";

	/**数値以外が入力された時のエラーメッセージ*/
	public static final String NOT_NUMBER_MASSAGE = "不当な値が入力されました。正しく入力し直してください";

	/** プレイヤーがバーストした時のメッセージ*/
	public static final String PLAYER_BURST_MASSAGE = "残念、バーストしてしまいました。ディーラーの勝ちです。";

	/** ディーラーがバーストした時のメッセージ*/
	public static final String DEALER_BURST_MASSAGE = "ディーラーがバーストしました。あなたの勝ちです！";

	/**ポイント比較（引き分け）のメッセージ*/
	public static final String DRAW_MASSAGE = "引き分けです。betが戻ってきます";

	/**ポイント比較でプレイヤーが勝利した時のメッセージ*/
	public static final String WIN_MASSAGE = "あなたの勝ちです！";

	/** ポイント比較でプレイヤーが負けた時のメッセージ*/
	public static final String LOSE_MASSAGE = "あなたの負けです・・・";

    /** 数値以外のものが入っていないかをチェックする正規表現 */
    public static final String NUMBER_MATCH_CHECK = "^[0-9]+$";

}
