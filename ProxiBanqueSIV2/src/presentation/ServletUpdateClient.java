package presentation;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Client;
import metier.Person;
import service.ServiceActor;

/**
 * Servlet implementation class ServletUpdateClient
 */
@WebServlet("/ServletUpdateClient")
public class ServletUpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpdateClient() {
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
		// TODO Auto-generated method stub
		String id = request.getParameter("idClient");

		HttpSession session = request.getSession();
		List<Client> listtmp = (List<Client>) session.getAttribute("list");
		System.out.println("ServletUpdate doPost list de client lenght = " + listtmp.size());
		Client realClientFromList = null;
		for (Client client : listtmp) {
			if (client.getId() == Long.parseLong(id)) {
				realClientFromList = client;
				break;
			}
		}

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		String city = request.getParameter("city");

		if (firstName.equals(null) && !realClientFromList.getFirstName().equals(null))
			firstName = realClientFromList.getFirstName();

		if (lastName.equals(null) && !realClientFromList.getLastName().equals(null))
			lastName = realClientFromList.getLastName();

		if (email.equals(null) && !realClientFromList.getEmail().equals(null))
			email = realClientFromList.getEmail();

		if (address.equals(null) && !realClientFromList.getAddress().equals(null))
			address = realClientFromList.getAddress();

		if (zip.equals(null) && !realClientFromList.getZipCode().equals(null))
			zip = realClientFromList.getZipCode();

		if (city.equals(null) && !realClientFromList.getTown().equals(null))
			city = realClientFromList.getTown();

		Client cl = new Client(Long.parseLong(id), "0", lastName, firstName, "0", address, zip, city,email);
		System.out.println(" client in updateServlet TTTTTTTTT donne moi l'id client stp = "+cl.getId());
		
		ServiceActor.updateClientToBDD(cl);
		
		

		RequestDispatcher dispatcher = null;
		session.setAttribute("list", ServiceActor.getAllClient());
		dispatcher = request.getRequestDispatcher("updateClient.jsp");
		dispatcher.forward(request, response);

	}

}
