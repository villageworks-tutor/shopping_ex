package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CustomerBean;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの文字コードの設定
		request.setCharacterEncoding("utf-8");
		// リクエストパラメータ（actionキー）を取得
		String action = request.getParameter("action");
		if (action == null || action.isEmpty() || action.equals("entry")) {
			// actionキーが送信されていないかまたは初期画面表示（entry）の場合
			this.gotoPage(request, response, "/customerInfo.jsp");
		} else if (action.equals("confirm")) {
			// 確認画面表示（confirm）の場合
			// リクエストパラメータを取得
			String name = request.getParameter("name");
			String addree = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			// 顧客をインスタンス化
			CustomerBean customer = new CustomerBean();
			customer.setName(name);
			customer.setAddress(addree);
			customer.setTel(tel);
			customer.setEmail(email);
			
			// セッションスを取得
			HttpSession session = request.getSession(false);
			if (session == null) {
				// セッションオブジェクトがない場合：セッションが切れている
				// リクエストスコープにエラーメッセージを登録
				request.setAttribute("message", "セッションが切れています。もう一度トップページから操作してください。");
				// 内部エラー画面に遷移
				this.gotoPage(request, response, "/errInternal.jsp");
				return;
			}
			
			// セッションスコープに顧客インスタンスを登録
			session.setAttribute("customer", customer);
			// 確認画面に遷移
			this.gotoPage(request, response, "/confirm.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
