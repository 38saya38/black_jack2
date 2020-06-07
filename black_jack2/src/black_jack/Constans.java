package black_jack;

/**
 * 定数をまとめたクラス
 *
 * @author Saya Tobari
 *
 */

public class Constans {

	/**privateコンストラクタでインスタンス生成を抑止*/
		private Constans(){}

	/**プレイヤーの初期手持ち金額 */
	public static final int START_CASH = 20000;

	/**ゲーム開始のメッセージ */
	public static final String START_MASSAGE = "ブラックジャックへようこそ٩( 'ω' )و\n";

	/**賭け金を決めるためのメッセージ*/
	public static final String BET_DECITION_MASSAGE = "賭け金を決めてください";

	/** 賭け金が1000以下だった場合のエラーメッセージ*/
	public static final String NOT_1000OVER_MASSAGE = "賭け金は1000以上からです。設定し直してください";

	/**手持ち金以上をかけようとした時のエラーメッセージ*/
	public static final String OVER_BET_MASSAGE = "手持ち金以上を賭けることはできません。設定し直してください";

	/**数値以外が入力された時のエラーメッセージ*/
	public static final String NOT_NUMBER_MASSAGE = "不当な値が入力されました。正しく入力し直してください";

	/**ディーラーが2枚目のカードを引いた時のメッセージ*/
	public static final String DEALER_SECOND_CARD_MASSAGE = "ディーラーの2枚目のカードは秘密";

	/**プレイヤーに次の手を促すメッセージ*/
	public static final String URGE_MASSAGE = "次の手を選択します。番号を入力してください";

	/**プレイヤーが最初の2枚でブラックジャックになった時のメッセージ*/
	public static final String BRACK_JACK_MASSAGE = "\nプレイヤー、ブラックジャック！";

	/** プレイヤーがバーストした時のメッセージ*/
	public static final String PLAYER_BURST_MASSAGE = "残念、バーストしてしまいました。ディーラーの勝ちです。";

	/** ディーラーがバーストした時のメッセージ*/
	public static final String DEALER_BURST_MASSAGE = "ディーラーがバーストしました。あなたの勝ちです！";

	/**ポイント比較（引き分け）のメッセージ*/
	public static final String DRAW_MASSAGE = "引き分けです。betが戻ってきます";

	/**プレイヤーがカードを１枚引くときのメッセージ*/
	public static final String DRAW_CARD_MASSAGE = "カードを1枚引きます";

	/**プレイヤーがスプリットを選択したときのメッセージ*/
	public static final String SPRIT_MASSAGE = "手札を2つに分け、それぞれにbetをかけます";

	/**hitでプレイヤーがカードを１枚引くときのメッセージ*/
	public static final String HIT_MASSAGE = "ヒット：カードを1枚引きます";

	/**プレイヤーがサレンダーを選択するときのメッセージ*/
	public static final String SURRENDER_MASSAGE = "サレンダー：betの半額を回収し、ゲームを放棄できます";

	/**プレイヤーがダブルダウンを選択したときのメッセージ*/
	public static final String DOUBLE_DOWN_MASSAGE = "ダブルダウン：カードを1枚だけ引き、賭け金を２倍にします";

	/**プレイヤーがスタンドを選択したときのメッセージ*/
	public static final String STAND_MASSAGE = "スタンド：このカードで勝負します";

	/**インシュランスを選択するときのメッセージ*/
	public static final String INSURANCE_MASSAGE = "インシュランス：ディーラーの１枚目の手札がAだった場合、賭け金の半額をbetし、\nディーラーがブラックジャックだった場に賭け金が戻ってきます";

	/**インシュランスを選択するときのメッセージ*/
	public static final String SPRITNO_MASSAGE = "スプリット：最初に引いた手札が同じ数だった場合、ふた山に分けることができます。\nbetはそれぞれにかかります";

	/**ポイント比較でプレイヤーが勝利した時のメッセージ*/
	public static final String WIN_MASSAGE = "あなたの勝ちです！";

	/** ポイント比較でプレイヤーが負けた時のメッセージ*/
	public static final String LOSE_MASSAGE = "あなたの負けです・・・";

    /** 数値以外のものが入っていないかをチェックする正規表現 */
    public static final String NUMBER_MATCH_CHECK = "^[0-9]+$";

    /** プレイヤーの手持ち金が1000以下になりゲームオーバーになった時のメッセージ */
    public static final String GAME_OVER = "手持ち金が最低ベット額を下回りました。ゲームオーバーです。";

    /** 予期せぬエラーになった時のメッセージ */
    public static final String ERROR_MASSAGE = "予期せぬエラーが発生しました。ゲームを終了します";

}
