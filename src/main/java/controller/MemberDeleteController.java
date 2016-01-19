package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MemberDao;

@Controller
public class MemberDeleteController {
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = "/member/delete.do", method = RequestMethod.GET)
	public String deleteMember(@RequestParam Integer no) throws Exception {
		memberDao.delete(no);

		return "redirect:list.do";
	}
	
}
