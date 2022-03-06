package la.dao;

/**
 * DAOで発生した例外が変換される非業務例外
 * @author tutor
 */
public class DAOException extends Exception {

	/**
	 * コンストラクタ
	 * @param message 例外メッセージ
	 */
	public DAOException(String message) {
		super(message);
	}

}
