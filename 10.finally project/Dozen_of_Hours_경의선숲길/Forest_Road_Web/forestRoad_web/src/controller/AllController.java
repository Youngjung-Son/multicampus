/*학습내용
 * 1. command pattern 반영한 controller
 * 2. 여러개의 요청을 하나의 controller가 받아서 구분 
 * 		각 요청별 로직 처리
 * 3. 필요 로직
 * 		1. 요청 구분을 필요한 분기문
 * 		2. 각 로직을 처리하는 별도의 사용자 정의 메소드를 구현
 * 		3. 요청별 사용자 정의 메소드 호출
 * 4. 실제 처리 로직 관점
 * 		1. 로그인
 * 			1. 로그인 요청인지 구분
 * 			2. id/pw값 획득
 * 			3. id/pw값의 존재 여부 체크
 * 				-null여부, null이 아니면 DAO의 로그인 로직 처리 메소드 호출
 *			4. 실행되는 경우의 수
 *				정상 실행
 *					1. 존재한다 - name값 반환
 *						-세션 생성
 *						-세션 이름값 저장
 *						-SuccessView로 이름 값 출력 위임(Redirect로 이동)
 *
 *					2. 미존재한다  - null값 반환
 *				비정상 실행
 *					예외 발생
 * 		2. 이름 변경
 */


package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.PlaceDAO;
import model.domain.CustomerDTO;
import model.domain.PlaceDTO;

public class AllController extends HttpServlet {
       
    public AllController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("login")) {
			login(request,response);
		}else if(command.equals("signup")) {
			signup(request,response);
		}else if(command.equals("logout")){
			logout(request,response);
		}else if(command.equals("all")){
			all(request,response);
		}else if(command.equals("search")){
			search(request,response);
		}else {
			response.sendRedirect("login.html");
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		session.setAttribute("type", request.getParameter("type"));
		session.setAttribute("distance", request.getParameter("distance"));
		System.out.println(request.getParameter("lat")+request.getParameter("lng")+request.getParameter("type")+request.getParameter("distance"));
		System.out.println(session.getAttribute("type"));
		String type = (String) session.getAttribute("type");
		try {
			
			ArrayList<PlaceDTO> typesearch = PlaceDAO.typeSearch(type);
			System.out.println(typesearch.size());
			if (typesearch.size() == 0) {
				request.setAttribute("msg", "정보가 없습니다");
				request.getRequestDispatcher("msgView.jsp").forward(request, response);
			} else {
				session.setAttribute("typesearch", typesearch);
				response.sendRedirect("loginSucc.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "검색 실패. 재시도 하세요.");
			request.getRequestDispatcher("msgView.jsp").forward(request, response);
		}
	}
	private void setLocation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String clat2=request.getParameter("lat");
		String clng2=request.getParameter("lng");
		double clat = Double.parseDouble(clat2);
		double clng = Double.parseDouble(clng2);
		session.setAttribute("clat", clat);
		session.setAttribute("clng", clng);
		System.out.println("setLocation");
		response.sendRedirect("loginSucc.jsp");
		
	}
	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println("----- " + name);
		if (id != null && pw!=null&&name != null) {
			try {
				if (CustomerDAO.signup(id, pw,name)) {
					System.out.println("회원가입 완료");
					response.sendRedirect("index.html");
				} else {
					request.setAttribute("msg", "범위를 벗어난 입력입니다.");
					try {
						request.getRequestDispatcher("msgView.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("정보를 제대로 입력해주세요");
			response.sendRedirect("index.html");
		}		
	}
	// 로그인 처리 메소드
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String type = "restaurant";
		if (id != null && pw != null) {
			try {
				String name = CustomerDAO.loginCheck(id, pw);
				if (name != null) { // 회원일 경우
					HttpSession session = request.getSession();
					session.setAttribute("dataAll", PlaceDAO.typeSearchAll());
					session.setAttribute("name", name);
					session.setAttribute("type", type);
					response.sendRedirect("loginSucc.jsp");
				} else { // 비회원일 경우
					// 요청 객체에 "당신은 회원이 아니십니다"
					request.setAttribute("msg", "당신은 회원이 아니십니다");
					request.getRequestDispatcher("msgView.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login.html");
		}

	}
	

	// 로그아웃 처리 메소드
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		//response.sendRedirect("byView.jsp");
		response.sendRedirect("index.html");

	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String newName = request.getParameter("newName");
		System.out.println("----- " + newName);
		if (id != null && newName != null) {
			try {
				if (CustomerDAO.update(id, newName)) {
					CustomerDAO.update(id, newName);
					HttpSession session = request.getSession();
					session.setAttribute("newName", newName);
					response.sendRedirect("updateSucc");
				} else {
					request.setAttribute("msg", "회원이 아니십니다");
					request.getRequestDispatcher("msgView.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login.html");
		}

	}

	/*
	 * 모든 검색 결과인 ArrayList를 획득 -> request에 저장 -> forward 방식으로 모두 보기 화면으로 이동 로그인 안한
	 * 경우 결과 보기는 불가 로그인 전 - login.html로 화면 이동 로그인 후 - 모든 검색 로그인 여부 확인 - session에
	 * "name" 별칭 존재 여부 확인 검증은 controller? 모든 검색 결과 출력해주는 view에서? -getSession()
	 * 1.blank or ture 인 경우 , 없으면 세션 생성, 있으면 유지 2. false인 경우, 없어도 생성 불가, 있어야만 받아옴.
	 * HttpSession session = request.getSession(false);
	 */
	protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
			try {
				ArrayList<CustomerDTO> all = CustomerDAO.allSearch();
				if (all.size() == 0) {
					request.setAttribute("msg", "정보가 없습니다");
					request.getRequestDispatcher("msgView.jsp").forward(request, response);
				} else {
					session.setAttribute("all", all);
					response.sendRedirect("allView.jsp");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("msg", "검색 실패. 재시도 하세요.");
				request.getRequestDispatcher("errorView.jsp").forward(request, response);
			}
		

	}

}

