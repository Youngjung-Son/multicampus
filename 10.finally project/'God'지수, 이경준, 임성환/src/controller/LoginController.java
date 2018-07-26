package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cont2")
public class LoginController extends HttpServlet {
	
	//get or post 모든 방식 처리하는 메소드, 재정의
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client가 입력한 데이터 획득
		String command = request.getParameter("command");
		System.out.println(request.getRemoteAddr());
		
		
		if(command.equals("login")) {
			request.setAttribute("newData", "로그인에 성공하였습니다.");
			request.getRequestDispatcher("succ").forward(request, response);
		}else {
			request.setAttribute("newData", "로그인에 실패하였습니다. 아이디와 비밀번호 확인 후 다시 시도하여 주시기 바랍니다.");
			response.sendRedirect("fail");
		}
	}
}