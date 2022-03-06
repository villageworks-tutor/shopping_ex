package la.test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import la.bean.CategoryBean;
import la.bean.ItemBean;
import la.dao.BaseDAO;
import la.dao.DAOException;
import la.dao.ItemDAO;

class ItemDaoTest {
	
	/** テスト対象クラス：system under test */
	ItemDAO sut = null;

	@BeforeEach
	void setUp() throws Exception {
		sut = new ItemDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("ItemDAO#findByCategoryメソッドのテストクラス")
	class findByCategory {
		@Test
		@DisplayName("登録されていない商品コード「-1」の商品はない")
		void test_02() throws Exception {
			// setup
			int target = -1;
			List<ItemBean> expected = new ArrayList<>();
			// execute
			List<ItemBean> actual = sut.findByCategory(target);
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("登録された商品カテゴリーコード「3」の商品は「パズルゲーム」「Invader Fighter」「Play the BascketBall」である")
		void test_01() throws Exception {
			// setup
			int target = 3;
			List<ItemBean> expectedList = new ArrayList<>();
			expectedList.add(new ItemBean(7, "パズルゲーム", 780));
			expectedList.add(new ItemBean(8, "Invader Fighter",	3400));
			expectedList.add(new ItemBean(9, "Play the BascketBall", 2200));
			// execute
			List<ItemBean> actualList = sut.findByCategory(target);
			// verify
			if (actualList.size() > 0) {
				ItemBean expected = null;
				ItemBean actual = null;
				for (int i = 0; i < actualList.size(); ++i) {
					actual = actualList.get(i);
					expected = expectedList.get(i);
					assertThat(actual.getCode(), is(expected.getCode()));
					assertThat(actual.getName(), is(expected.getName()));
					assertThat(actual.getPrice(), is(expected.getPrice()));
				}
			} else {
				fail("未実装です");
			}
		}
	}
	
	
	@Nested
	@DisplayName("ItemDAO#findAllCategoryメソッドのテストクラス")
	class findAllCategory {
		@Test
		@DisplayName("テーブルに登録されているすべての商品分類を取得できる")
		void test_01() throws Exception {
			// setup
			List<CategoryBean> expectedList = new ArrayList<>();
			expectedList.add(new CategoryBean(1, "本"));
			expectedList.add(new CategoryBean(2, "DVD"));
			expectedList.add(new CategoryBean(3, "ゲーム"));
			// execute
			List<CategoryBean> actualList = sut.findAllCategory();
			// verify
			if (actualList.size() > 0) {
				for (int i = 0; i < actualList.size(); ++i) {
					assertThat(actualList.get(i).getCode(), is(expectedList.get(i).getCode()));
					assertThat(actualList.get(i).getName(), is(expectedList.get(i).getName()));
				}
			} else {
				fail("未実装です");
			}
		}
	}
	
	@Nested
	@DisplayName("ItemDAOのインスタンス化のテストクラス")
	class constructor {
		@Test
		@DisplayName("ItemDAOのデータベース接続オブbジェクトはインスタンス化できる")
		void test_02() throws Exception {
			// setup
			// execute
			ExtendedItemDAO dao = new ExtendedItemDAO();
			Object actual = dao.getConn();
			// verify
			assertThat(actual, is(instanceOf(Connection.class)));
		}
		
		@Test
		@DisplayName("ItemDAOをインスタンス化できる")
		void test_01() throws Exception {
			// setup
			// execute
			Object actual = new ItemDAO();
			// verify
			assertThat(actual, is(instanceOf(ItemDAO.class)));
		}
	}
	
	/**
	 * インスタンス化テスト用DAO継承クラス
	 * @author villa
	 *
	 */
	class ExtendedItemDAO extends BaseDAO {

		// コンストラクタ
		public ExtendedItemDAO() throws DAOException {
			super();
		}
		
		/**
		 * データベース接続オブジェクトを取得する。
		 * @return データベース接続オブジェクト
		 */
		public Connection getConn() {
			return conn;
		}
		
	}

}
