package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;

public class LoginOkServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");

		RegisterDao dao = new RegisterDao();
		RegisterDto dto = dao.selectByIdPwd(id,pwd);

		if (dto != null) {
		HttpSession session = request.getSession();
		session.setAttribute("UserId",dto.getId());
		session.setAttribute("UserEmail",dto.getEmail());
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //True 클라이언트가 새로운 페이지를 요청하게 할 거예요
		forward.setPath("/WEB-INF/views/login/login_welcome.jsp");
		return forward;
	}

}
