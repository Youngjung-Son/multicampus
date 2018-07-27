
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LeagueDAO;
import model.ManagerDAO;
import model.domain.PlayerDTO;
import model.domain.ScheduleDTO;

@WebServlet("/cont")
public class Allcontroller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command"); // login 또는 rename 또는 logout 이 넘어옴
		
		if (command.equals("login")) {
			login(request, response);
		} else if (command.equals("logout")) {
			logout(request, response);
		} else if (command.equals("insert")) {
			insert(request, response);
		} else if (command.equals("delete")) {
			
			delete(request, response);
		} else if (command.equals("update")) {
			update(request, response);
		} else if (command.equals("getOne")) {
	         getOne(request, response);
		}else {
			response.sendRedirect("login.html");
		}
	}

	// 로그인 처리 메소드
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id != null && pw != null) {
			try {
				String name = ManagerDAO.loginCheck(id, pw);
				if (name != null) { // 회원일 경우
					HttpSession session = request.getSession(); // 일회성이 아님. 세션은 유지시키기 때문
					session.setAttribute("name", name);
					response.sendRedirect("cv.jsp");
				} else { // 비회원일 경우
					// 요청 객체에 "당신은 회원이 아니십니다"
					response.sendRedirect("error404.html");
				} // jsp 랑 html 은 확장자가 꼭 들어감.

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error404.html");
		}

	}

	// 로그아웃 처리 메소드 // 코드의 이관 작업 // 리팩토리 // 클린코드
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		response.sendRedirect("test.html");
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String tname = request.getParameter("tname");
		String name = request.getParameter("name");
		int BackNumber = Integer.parseInt(request.getParameter("BackNumber"));
		String Position = request.getParameter("Position");
		int Stat = Integer.parseInt(request.getParameter("Stat"));
		int Inumber = Integer.parseInt(request.getParameter("Inumber"));

		if (tname != null && name != null && BackNumber != '\0' && Position != null && Stat != '\0'
				&& Inumber != '\0') {
			try {
				PlayerDTO newPlayer = new PlayerDTO(tname, name, BackNumber, Position, Stat, Inumber);
				System.out.println(newPlayer);
				boolean result = LeagueDAO.insert(newPlayer);
				if (result != false) { // 회원일 경우
					HttpSession session = request.getSession(); // 일회성이 아님. 세션은 유지시키기 때문
					response.sendRedirect("cv.jsp");
				} else { // 비회원일 경우
					// 요청 객체에 "당신은 회원이 아니십니다"
					response.sendRedirect("error404.html");
				} // jsp 랑 html 은 확장자가 꼭 들어감.

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error404.html");
		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long Inumber = Long.parseLong(request.getParameter("Inumber"));
		System.out.println(Inumber);
		if (Inumber != '\0') {
			try {
				boolean result = LeagueDAO.delete(Inumber);
				if (result != false) { // 회원일 경우
					HttpSession session = request.getSession(); // 일회성이 아님. 세션은 유지시키기 때문
					response.sendRedirect("cv.jsp");
				} else { // 비회원일 경우
					// 요청 객체에 "당신은 회원이 아니십니다"
					response.sendRedirect("error404.html");
				} // jsp 랑 html 은 확장자가 꼭 들어감.

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error404.html");
		}

	}

	protected void getOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String tname = request.getParameter("tname");
		// String tname = "전북";
		System.out.println("-------------- " + tname);
		if (session != null) {// 이미 로그인 되어 있음을 의미
			try {
				ArrayList<PlayerDTO> all = LeagueDAO.getOne(tname);
				System.out.println(all);
				session.setAttribute("allData", all);
				request.getRequestDispatcher("allView.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "검색 실패..재 시도하세요");
				request.getRequestDispatcher("errorView.jsp").forward(request, response);
			}
		}
	}
//	protected void getSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//			try {
//				ArrayList<ScheduleDTO> result = LeagueDAO.getSchedule();
//				if(result.size() != 0) { // 회원일 경우
//					response.sendRedirect("cv.html");
//				}else { // 비회원일 경우
//					//요청 객체에 "당신은 회원이 아니십니다"
//					response.sendRedirect("error404.html");
//				}//jsp 랑 html 은 확장자가 꼭 들어감.
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//		} else {
//			response.sendRedirect("error404.html");
//		}
//	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int Stat = Integer.parseInt(request.getParameter("Stat"));
		long Inumber = Long.parseLong(request.getParameter("Inumber"));
		System.out.println(Stat + "   "+Inumber);
		if (Inumber != '\0') {
			try {
				boolean result = LeagueDAO.update(Stat, Inumber);
				if (result != false) { // 회원일 경우
					HttpSession session = request.getSession(); // 일회성이 아님. 세션은 유지시키기 때문
					response.sendRedirect("cv.jsp");
//					request.getRequestDispatcher("cv.html").forward(request, response);
				} else { // 비회원일 경우
					// 요청 객체에 "당신은 회원이 아니십니다"
					response.sendRedirect("error404.html");
				} // jsp 랑 html 은 확장자가 꼭 들어감.

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error404.html");
		}

	}
}