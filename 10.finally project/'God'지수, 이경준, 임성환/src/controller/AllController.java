package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClientDAO;
import model.domain.ClientDTO;

@WebServlet("/cont")
public class AllController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("EUC-KR");
		String command = request.getParameter("command");

		if (command.equals("loginform")) {
		} else if (command.equals("signUp")) {
			String userId = request.getParameter("userId");
			System.out.println(userId);
			String password1 = request.getParameter("password1");
			System.out.println(password1);
			String koreanLastName = request.getParameter("koreanLastName");
			String koreanFirstName = request.getParameter("koreanFirstName");
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("firstName");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String representPhoneNumber = request.getParameter("representPhoneNumber");
			ClientDTO dto = new ClientDTO(userId, password1, koreanLastName, koreanFirstName, lastName, firstName,
					dateOfBirth, gender, email, representPhoneNumber);
			try {
				boolean r = ClientDAO.insert(dto);
				if(r) {
					request.setAttribute("msg", "회원가입에 성공하였습니다.");
					request.getRequestDispatcher("signupSucc.jsp").forward(request, response);
				}else {
					request.setAttribute("msg2", "회원가입에 실패하였습니다. 다시 시도하여 주시기 바랍니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("loginform.html");
			}

		} else {
			response.sendRedirect("loginform.html");
		}
	}
}