package la.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.CategoryBean;
import la.bean.ItemBean;

/**
 * 商品（商品カテゴリーを含む）に関するデータベースアクセスを実行するDAO
 * @author tutor
 */
public class ItemDAO extends BaseDAO {

	/**
	 * コンストラクタ
	 * @throws DAOException
	 */
	public ItemDAO() throws DAOException {
		super();
	}

	/**
	 * すべての商品カテゴリーを取得する。
	 * @return 商品カテゴリーリスト
	 * @throws DAOException
	 */
	public List<CategoryBean> findAllCategory() throws DAOException {
		
		// 実行するSQLを設定
		String sql = "SELECT code, name FROM category ORDER BY code";
		
		// 処理の実行
		try (PreparedStatement pstmt = this.conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();) {
			// 戻り値の商品カテゴリーリストを初期化
			List<CategoryBean> list = new ArrayList<>();
			// 結果セットから商品カテゴリーリストを生成
			CategoryBean bean = null;
			while (rs.next()) {
				// 一時的に格納する商品カテゴリーのインスタンス化
				bean = new CategoryBean();
				bean.setCode(rs.getInt("code"));
				bean.setName(rs.getString("name"));
				// 商品カテゴリーリストに追加
				list.add(bean);
			}
			// 商品カテゴリーリストを返却
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("データの取得に失敗しました。");
		}
	}

	/**
	 * 指定された商品カテゴリーに属する商品を取得する。
	 * @param categoryCode 商品カテゴリーコード
	 * @return 商品リスト
	 * @throws DAOException
	 */
	public List<ItemBean> findByCategory(int categoryCode) throws DAOException {
		// 実行するSQLを設定
		String sql = "SELECT code, name, price FROM item WHERE category_code = ? ORDER By code";
		try (PreparedStatement pstmt = this.conn.prepareStatement(sql);) {
			// プレースホルダにパラメータをバインド
			pstmt.setInt(1, categoryCode);
			try (ResultSet rs = pstmt.executeQuery();) {
				// 戻り値の商品リストを初期化
				List<ItemBean> list = new ArrayList<>();
				// 結果セットから商品リストを生成
				ItemBean bean = null;
				while (rs.next()) {
					bean = new ItemBean();
					bean.setCode(rs.getInt("code"));
					bean.setName(rs.getString("name"));
					bean.setPrice(rs.getInt("price"));
					// 商品リストに追加
					list.add(bean);
				}
				// 商品リストを返却
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
}
