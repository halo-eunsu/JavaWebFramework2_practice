package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
public class LogInController {
	@Autowired
	MemberDao memberDao;

	@RequestMapping(value = "/auth/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "/auth/LogInForm.jsp";
	}
	
	@RequestMapping(value = "/auth/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, Member loginInfo) {
		Member member = memberDao.exist(loginInfo.getEmail(), loginInfo.getPassword());
		if(member != null) {
			session.setAttribute("member", member);
			
			return "redirect:../member/list.do";
		}
		else {
			return "/auth/LogInFail";
		}
	}
	
}
