package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CompoHistoryDAO;
import model.CompoStateDAO;
import model.CustomerDAO;
import model.domain.CompoHistoryDTO;
import model.domain.CompoStateDTO;
import model.domain.CustomerDTO;

@WebServlet("/cont")
public class AllController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		
		String command = request.getParameter("command");	//login or rename
		
		System.out.println("++++++++++++++ " + command);
		if(command.equals("login")) {
			login(request, response);
		}else if(command.equals("register")) {
			register(request, response);
		}else if(command.equals("logout")){
			logout(request, response);
		}else if(command.equals("serialRegister")) {
			serialRegister(request,response);
		}else if(command.equals("myPage")) {
			myPage(request,response);
		}else if(command.equals("allCompoState")){
			allCompoState(request, response);
		}else if(command.equals("replaceCompo")) {
			replaceCompo(request, response);
		}else if(command.equals("allCompoHist")) {
			allCompoHist(request, response);
		}else {
			response.sendRedirect("login.html");
		}
	}
	
	
	//회원가입
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = request.getParameter("cust_email");
		String cust_name = request.getParameter("cust_name");
		String cust_pw = request.getParameter("cust_pw");
		String serialno = request.getParameter("serialno");
		
		CustomerDTO newCustomer = null;
		if(cust_email != null && cust_name != null && cust_pw != null) {
			try {
				newCustomer = new CustomerDTO(cust_email, cust_name, cust_pw, serialno);
				boolean result = CustomerDAO.register(newCustomer);
				if(result == true) {//회원가입 성공
					request.setAttribute("result", "회원가입 성공!");
					request.setAttribute("registerInfo", newCustomer);
					response.sendRedirect("loginindex.html");
					//request.getRequestDispatcher("main.jsp").forward(request, response);
				}else {	//회원가입 실패
					request.setAttribute("result", "회원가입 실패");
					//request에 저장한 것은 리다이렉트가 아닌 포워드방식을 데이터를 전송할 수 있다.
					request.getRequestDispatcher("main.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("login.html");
		}
	}
	
	//로그인
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = request.getParameter("cust_email");
		String cust_pw = request.getParameter("cust_pw");
		String cust_name = null;
	
		if(cust_email != null && cust_pw != null) {
			try {
				cust_name = CustomerDAO.login(cust_email,cust_pw);
				HttpSession session = request.getSession();
				if(cust_name != null) {//로그인 성공
					session.setAttribute("result", "로그인 성공!");
					session.setAttribute("cust_name", cust_name);
					session.setAttribute("cust_email", cust_email);
					response.sendRedirect("main.jsp");
				}else {	//로그인 실패
					session.setAttribute("result", "로그인 실패");
					response.sendRedirect("main.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("index.html");
		}
	}

	
	//로그아웃
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	//이미 존재할 경우 반환
		session.invalidate();
		session = null;
		response.sendRedirect("index.html");
	}
	
	//시리얼 등록
	protected void serialRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serialno = request.getParameter("serialno");
		String cust_email = null;
		HttpSession session = request.getSession();
		cust_email = (String) session.getAttribute("cust_email");
		
		if(cust_email != null && serialno != null) {
			try {
				boolean result = CustomerDAO.serialRegister(cust_email, serialno);
				if(result == true) {// 시리얼 등록 성공
					
					session.setAttribute("result", "시리얼번호 등록 성공!");
					session.setAttribute("serialno", serialno);
					if(CompoStateDAO.insertCompoInfo(cust_email) == true) {
						session.setAttribute("result2", "부품정보 입력 성공!");
					}else {
						session.setAttribute("result2", "부품정보 입력 실패");
					}
					
					response.sendRedirect("cont?command=myPage");
				}else {	//시리얼 등록 실패
					session.setAttribute("result", "시리얼번호 등록 실패");
					response.sendRedirect("cont?command=myPage");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("serialRegister.jsp");
		}
		
	}
	
	//모든 부품상태 보기
	protected void allCompoState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = loginCheck(request, response);
		ArrayList<CompoStateDTO> myCompo = null;
		if(cust_email != null) {	//로그인한경우
			try {
				myCompo = CompoStateDAO.allCompoState(cust_email);
				System.out.println(myCompo);
				if(myCompo.size() == 0) {// 부품 보기 실패
					request.setAttribute("result", "모든 부품 보기 실패!");
					request.getRequestDispatcher("tmsMain.jsp").forward(request, response);
				}else {	//부품 보기 성공
					request.setAttribute("result", "모든 부품 보기 성공");
					request.setAttribute("myCompo", myCompo);
					request.getRequestDispatcher("tmsMain.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	
	//부품교체내역 조회
	protected void allCompoHist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = loginCheck(request, response);
		ArrayList<CompoHistoryDTO> data = null;
		if(cust_email != null) { //로그인 한경우
			String compo_name = request.getParameter("compo_name");
			System.out.println("---------------- " + compo_name);
			try {
				data = CompoHistoryDAO.allCompoHist(cust_email, compo_name);
				if(data.size() != 0) {
					request.setAttribute("result", "부품 교체내역 조회 성공");
					request.setAttribute("data", data);
					request.getRequestDispatcher("dataView.jsp").forward(request, response);
				}else {
					request.setAttribute("result", "부품 교체내역 데이터가 없습니다.");
					request.getRequestDispatcher("replace.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	
	//부품 교체
	protected void replaceCompo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = loginCheck(request, response);
		if(cust_email != null) { //로그인 한경우
			String compo_name = request.getParameter("compo_name");
			String replacedate = request.getParameter("replacedate");
			System.out.println(compo_name+" "+replacedate);
			if(compo_name!=null && replacedate!=null) {
				try {
					boolean result = CompoStateDAO.replaceCompo(cust_email, compo_name, replacedate);
					boolean result2 = CompoHistoryDAO.insertCompoHist(cust_email, compo_name, replacedate);
					
					if(result == true && result2 == true) {
						request.setAttribute("result", "success");
						request.getRequestDispatcher("replace.jsp").forward(request, response);
					}else {
						request.setAttribute("result", "fail");
						request.getRequestDispatcher("replace.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {//입력한 값이 없을때
				request.setAttribute("result", "fail");
				request.getRequestDispatcher("replace.jsp").forward(request, response);
			}
			
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	//마이페이지 보기
	protected void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = loginCheck(request, response);
		CustomerDTO myInfo = null;
		if(cust_email != null) {	//로그인한경우
			try {
				myInfo = CustomerDAO.myPage(cust_email);
				System.out.println(myInfo);
				if(myInfo != null) {// 마이페이지 보기 성공
					request.setAttribute("result", "마이페이지 보기 성공!");
					request.setAttribute("myInfo", myInfo);
					request.getRequestDispatcher("myPage.jsp").forward(request, response);
				}else {	//마이페이지 보기 실패
					request.setAttribute("result", "마이페이지 보기 실패");
					request.getRequestDispatcher("myPage.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	//로그인 여부 체크
	protected String loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_email = null;
		HttpSession session = request.getSession();
		cust_email = (String) session.getAttribute("cust_email");
		
		return cust_email;
	}
	
	
	
}
