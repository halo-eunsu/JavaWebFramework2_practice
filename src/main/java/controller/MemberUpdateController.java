package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MemberDao;
import vo.Member;

@Controller
public class MemberUpdateController {
	@Autowired
	MemberDao memberDao;
	
	
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String memberUpdateForm(@RequestParam Integer no, Model model) throws Exception {
		model.addAttribute("member", memberDao.selectOne(no));
		
		return "/member/MemberUpdateForm";
	}
	
	@RequestMapping(value = "/member/update.do", method = RequestMethod.POST)
	public String updateMember(Member member) throws Exception {
		memberDao.update(member);
		
		return "redirect:list.do";
	}

}
