package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * すべてのDAOクラスが継承する基底クラス
 * @author tutor
 */
public class BaseDAO {

	/**
	 * クラス定数：データベース接続情報文字列
	 */
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/sample";
	private static final String DB_USER = "student";
	private static final String DB_PASSWORD = "himitu";
	
	/**
	 * クラスフィールド：データベース接続オブジェクト
	 */
	protected Connection conn;
	
	/**
	 * コンストラクタ
	 * @throws DAOException
	 */
	public BaseDAO() throws DAOException {
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DAOException("データベースの説ぞ失敗しました。");
		}
	}
	
}
