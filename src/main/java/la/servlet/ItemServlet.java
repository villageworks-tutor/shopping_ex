package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CategoryBean;
import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	
	/** シリアルバージョンUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// リクエストパラメータ（actionキー）の取得
			String action = request.getParameter("action");
			if (action == null || action.isEmpty() || action.equals("top")) {
				// actionキーが送信されていないかまたは初期画面表示（top）の場合
				this.gotoPage(request, response, "/top.jsp");
			} else if (action.equals("list")) {
				// リクエストパラメータを取得
				int code = Integer.parseInt(request.getParameter("code"));
				// ItemDAoをインスタンス化
				ItemDAO dao = new ItemDAO();
				// 商品リストを取得
				List<ItemBean> list = dao.findByCategory(code);
				// リクエストスコープに商品リストを登録
				request.setAttribute("items", list);
				// 商品一覧画面に遷移
				this.gotoPage(request, response, "/list.jsp");
			} else {
				// リクエストスコープにエラーメッセージを登録
				request.setAttribute("message", "正しく操作してください。");
				// 内部エラー画面に遷移
				this.gotoPage(request, response, "/errInternal.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			// リクエストスコープにエラーメッセージを登録
			request.setAttribute("message", "内部エラーが発生しました。");
			// 内部エラー画面に遷移
			this.gotoPage(request, response, "/errInternal.jsp");
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			// ItemDAOをインスタンス化
			ItemDAO dao = new ItemDAO();
			// すべての処品カテゴリーを取得
			List<CategoryBean> list = dao.findAllCategory();
			// アプリケーションスコープに登録：このメソッドが呼び出される時点ではアプリケーションスコープ理科利用できないことに注意！
			this.getServletContext().setAttribute("categories", list);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException();
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
