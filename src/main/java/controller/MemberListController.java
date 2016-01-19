package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.MemberDao;

public class MemberListController implements Controller {
	@Autowired
	MemberDao memberDao;

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/member/MemberList");
		mav.addObject("members", memberDao.selectList());
		
		return mav;
	}

}
