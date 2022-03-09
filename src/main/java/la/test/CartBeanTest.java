package la.test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import la.bean.CartBean;
import la.bean.ItemBean;

class CartBeanTest {

	/** テスト対象クラス */
	CartBean sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new CartBean();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Nested
	@DisplayName("CartBean#deleteItemメソッドのテストクラス")
	class deleteItem {
		
		@BeforeEach
		void setUp() {
			// 【テストの前提】カートに2個の商品「Javaの基礎」、4個の商品「MLB Fun」と3個の「なつかしのアニメシリーズ」が入っている。
			sut.addItem(new ItemBean(1, "Javaの基礎", 2500), 2);
			sut.addItem(new ItemBean(2, "MLB Fun", 980), 4);
			sut.addItem(new ItemBean(4, "なつかしのアニメシリーズ", 2000), 3);
		}
		
		@Test
		@DisplayName("カートに入っていない商品番号「-1」の商品を削除すると合計金額は14920円である")
		void test_02() {
			// setup
			int target = -1;
			int expected = 14920;
			// execute
			sut.deleteItem(target);
			int actual = sut.getTotal();
			// verify
			assertThat(actual, is(expected));
		}
		
		@Test
		@DisplayName("商品「Javaの基礎」をカートから削除すると合計金額は11000円である")
		void test_01() {
			// setup
			int target = 2;
			int expected = 11000;
			// execute
			sut.deleteItem(target);
			int actual = sut.getTotal();
			// verify
			assertThat(actual, is(expected));
		}
	}
	
	@Nested
	@DisplayName("CartBean#getTotalメソッドのテストクラス")
	class addItem {
		@Test
		@DisplayName("カートに１個の商品「料理BOOK!」と１個の商品「パズルゲーム」が追加されている状態でさらに4個の商品「パズルゲーム」を追加すると合計金額は5100円である")
		void test_04() {
			// setup
			List<ItemBean> targets = new ArrayList<>();
			targets.add(new ItemBean(3, "料理BOOK!", 1200));
			targets.add(new ItemBean(7, "パズルゲーム", 780));
			for (ItemBean item : targets) {
				item.setQuantity(1);
				sut.addItem(item, item.getQuantity());
			}
			ItemBean target = new ItemBean(7, "パズルゲーム", 780);
			int expected = 5100;
			// execute
			sut.addItem(target, 4);
			int actual = sut.getTotal();
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("カートに１個の商品「料理BOOK!」と１個の商品「パズルゲーム」が追加されている状態でさらに１個の商品「パズルゲーム」を追加すると合計金額は2760円である")
		void test_03() {
			// setup
			List<ItemBean> targets = new ArrayList<>();
			targets.add(new ItemBean(3, "料理BOOK!", 1200));
			targets.add(new ItemBean(7, "パズルゲーム", 780));
			for (ItemBean item : targets) {
				item.setQuantity(1);
				sut.addItem(item, item.getQuantity());
			}
			ItemBean target = new ItemBean(7, "パズルゲーム", 780);
			target.setQuantity(1);
			int expected = 2760;
			// execute
			sut.addItem(target, target.getQuantity());
			int actual = sut.getTotal();
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("カートに１個の商品「料理BOOK!」が追加されている状態で１個の商品「パズルゲーム」を追加すると合計金額は1980円である")
		void test_02() {
			// setup
			List<ItemBean> targets = new ArrayList<>();
			targets.add(new ItemBean(3, "料理BOOK!", 1200));
			targets.add(new ItemBean(7, "パズルゲーム", 780));
			int expected = 1980;
			// execute
			for (ItemBean item : targets) {
				item.setQuantity(1);
				sut.addItem(item, item.getQuantity());
			}
			int actual = sut.getTotal();
			// vsrify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("空のカートに１個の商品「料理BOOK!」を追加すると合計金額は2000円である")
		void test_01() {
			// setup
			ItemBean target = new ItemBean(3, "料理BOOK!", 1200);
			target.setQuantity(1);
			int expected = 1200;
			// execute
			sut.addItem(target, target.getQuantity());
			int actual = sut.getTotal();
			// verify
			assertThat(actual, is(expected));
		}
	}
	
}
