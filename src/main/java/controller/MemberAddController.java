package controller;

import dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validator.MemberValidator;
import vo.Member;

import javax.validation.Valid;

@Controller
public class MemberAddController {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberValidator memberValidator;

    public void setMemberValidator(MemberValidator memberValidator) {
        this.memberValidator = memberValidator;
    }

    @RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAddForm() {
		return "/member/MemberForm";
	}
	
	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String addMember(@Valid Member member, BindingResult bindingResult) throws Exception {
//		this.memberValidator.validate(member, bindingResult);
		if(bindingResult.hasErrors()) {
			return "/member/MemberForm";
		}
		
		memberDao.insert(member);
		
		return "redirect:list.do";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(memberValidator);
	}
	
}
