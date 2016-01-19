package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
public class MemberAddController {
	@Autowired
	MemberDao memberDao;
	
	
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAddForm() {
		return "/member/MemberForm";
	}
	
	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String addMember(Member member) throws Exception {
		memberDao.insert(member);
		
		return "redirect:list.do";
	}
	
}
