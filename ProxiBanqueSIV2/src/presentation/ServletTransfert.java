package presentation;

/**
 * @author Jonas Maeva
 *
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.BankAccount;
import service.ServiceAccount;

/**
 * Servlet implementation class ServletTransfert 
 * Récupère les paramètres du
 * formulaire de virement pour requète à la base de données et mise à jour des soldes
 * comptes
 * 
 */
@WebServlet("/ServletTransfert")
public class ServletTransfert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTransfert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sold = request.getParameter("montant");
		String idhost = request.getParameter("idHost");
		String iddest = request.getParameter("idDest");
		HttpSession session = request.getSession();

		BankAccount host = ServiceAccount.getAccountById(Long.parseLong(idhost));
		BankAccount dest = ServiceAccount.getAccountById(Long.parseLong(iddest));

		ServiceAccount.transferAccoutToAccount(host, dest, Double.parseDouble(sold));
		RequestDispatcher dispatcher = null;

		session.setAttribute("listCount", ServiceAccount.getAllAccount());

		dispatcher = request.getRequestDispatcher("transfert.jsp");
		dispatcher.forward(request, response);
	}

}
