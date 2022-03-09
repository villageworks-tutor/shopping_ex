package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CartBean;
import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータ（actionキー）の取得
		String action = request.getParameter("action");
		if (action == null || action.isEmpty() || action.equals("show")) {
			// actionキーが送信されていないかまたはカートの中身を見る（show）の場合
		} else if (action.equals("add")) {
			// 商品を追加する場合
			// リクエストパラメータを取得
			int code = Integer.parseInt(request.getParameter("code")); 
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			try {
				// 商品を取得
				ItemDAO dao = new ItemDAO();
				ItemBean bean = dao.findByPrimaryKey(code);
				// 取得した商品に購入数量を設定
				bean.setQuantity(quantity);
				
				// セッションに登録
				HttpSession session = request.getSession(false);
				// セッションからカートを取得
				@SuppressWarnings("unchecked")
				CartBean cart = (CartBean) session.getAttribute("cart");
				if (cart == null) {
					// カートが登録されていない場合：はじめてカートに登録する場合
					cart = new CartBean();
					// セッションに登録
					session.setAttribute("cart", cart);
				}
				// カートに商品を追加
				cart.addItem(bean, quantity);
				// カート内容表示画面に遷移
				this.gotoPage(request, response, "/cart.jsp");
			} catch (DAOException e) {
				e.printStackTrace();
				// リクエストスコープにエラーメッセージを登録
				request.setAttribute("message", "内部エラーが発生しました。");
				// 内部エラー画面に遷移
				this.gotoPage(request, response, "/errInternal.jsp");
			}
		} else {
			// actionキーが未定義の文字列の場合：不正なアクセスと判断する
			// リクエストスコープにエラーメッセージを登録
			request.setAttribute("message", "正しく操作してください。");
			// 内部エラー画面に遷移
			this.gotoPage(request, response, "/errInternal.jsp");
		}
	}

	/**
	 * 指定したURLに遷移する。
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param nextPage 遷移先URL
	 * @throws ServletException
	 * @throws IOException
	 */
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String nextPage) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
