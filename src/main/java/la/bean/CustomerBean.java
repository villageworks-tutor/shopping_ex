package la.bean;

import java.io.Serializable;

/**
 * customerテーブルの1レコードを制御するJavaBean
 * @author tutor
 */
public class CustomerBean implements Serializable {

	/**
	 * クラスフィールド
	 */
	private int code;		// 顧客番号
	private String name;	// 顧客名
	private String address;	// 送付先住所
	private String tel;		// 電話番号
	private String email;	// 電子メールアドレス
	
	/**
	 * デフォルトコンストラクタ
	 */
	public CustomerBean() {}

	/**
	 * 顧客番号を取得する。
	 * @return code 顧客番号
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 顧客番号を設定する。
	 * @param code セットする顧客番号
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 顧客名を取得する。
	 * @return name 顧客名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 顧客名を設定する。
	 * @param name セットする顧客名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 送付先住所を取得する。
	 * @return address 送付先住所
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 送付先住所を設定する。
	 * @param address セットする送付先住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 電話番号を取得する。
	 * @return tel 電話番号
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 電話番号を設定する。
	 * @param tel セットする電話番号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 電子メールアドレスを取得する。
	 * @return email 電子メールアドレス
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 電子メールアドレスを設定する。
	 * @param email セットする電子メールアドレス
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerBean [");
		builder.append("code=" + code + ", ");
		builder.append("name=" + name + ", ");
		builder.append("address=" + address + ", ");
		builder.append("tel=" + tel + ", ");
		builder.append("email=" + email + "]");
		return builder.toString();
	}
	
	
	
}
