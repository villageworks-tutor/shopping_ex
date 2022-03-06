package la.bean;

import java.io.Serializable;

/**
 * categoryテーブルの1レコードを制御するJavaBean
 * @author tutor
 */
public class CategoryBean implements Serializable {
	/**
	 * クラスフィールド
	 */
	private int code;	 // 商品カテゴリーコード 
	private String name; // 商品カテゴリー名
	
	/**
	 * デフォルトコンストラクタ
	 */
	public CategoryBean() {}
	
	/**
	 * コンストラクタ
	 * @param code 商品カテゴリーコード
	 * @param name 商品カテゴリー名
	 */
	public CategoryBean(int code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * 商品カテゴリーコードを取得する。
	 * @return code 商品カテゴリーコード
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 商品カテゴリーコードを設定する。
	 * @param code セットする商品カテゴリコード
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 商品カテゴリー名を取得する。
	 * @return name 商品カテゴリー名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 商品カテゴリー名を設定する。
	 * @param name セットする商品カテゴリー名
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryBean [");
		builder.append("code=" + code + ", ");
		builder.append("name=" + name + "]");
		return builder.toString();
	}
	
}
