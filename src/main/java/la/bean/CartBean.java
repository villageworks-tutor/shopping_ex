package la.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * カートを制御するクラス
 * @author tutor
 */
public class CartBean {

	/**
	 * クラスフィールド
	 */
	private List<ItemBean> items = new ArrayList<>(); // 商品リスト
	private int total; // 商品の金額の総合計
	
	/**
	 * コンストラクタ
	 */
	public CartBean() {}

	/**
	 * 商品を追加する。
	 * @param newItem 追加する商品
	 * @param qualtity 追加数量
	 */
	public void addItem(ItemBean newItem, int quantity) {
		// 追加する商品をカートから取得
		ItemBean item = null;
		for (ItemBean bean : this.items) {
			if (bean.getCode() == newItem.getCode()) {
				// 商品が見つかった場合：商品を確保してループを抜ける
				item = bean;
				break;
			}
		}
		
		if (item == null) {
			// 商品が見つからなかった場合：初めてカートに追加する商品
			newItem.setQuantity(quantity);
			this.items.add(newItem);
		} else {
			// 商品が見つかった場合：数量を追加
			item.setQuantity(item.getQuantity() + quantity);
		}
		// 商品の金額の総合計を再計算
		this.recalcTotal();
	}
	
	/**
	 * 商品リストを取得する。
	 * @return 商品リスト
	 */
	public List<ItemBean> getItems() {
		return this.items;
	}
	
	/**
	 * 商品の価格の総合計を取得する。
	 * @return 商品の価格の総合計
	 */
	public int getTotal() {
		return this.total;
	}

	/**
	 * 商品の価格の総合計を計算する。
	 */
	private void recalcTotal() {
		// 仮の合計金額を初期化
		int total = 0;
		// 商品リストの商品の器楽の合計を計算
		for (ItemBean item : this.items) {
			total += item.getPrice() * item.getQuantity();
		}
		// totalフィールドを仮の合計金額で上書き
		this.total = total;
	}
	
	
	
}
