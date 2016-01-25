package controller;

import dao.MemberDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import validator.MemberValidator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class MemberAddControllerTest {
	private MockMvc mockMvc;

    @Mock
    MemberDao memberDao;

    MemberValidator memberValidator = new MemberValidator();

    @InjectMocks
	private MemberAddController memberAddController;


    @Before
    public void setUp() throws Exception {
        memberAddController.setMemberValidator(memberValidator);

		this.mockMvc = MockMvcBuilders.standaloneSetup(memberAddController)
                .build();
    }
    
    @Test
    public void testAddMember_파라미터_없을때() throws Exception {
		mockMvc.perform(post("/member/add.do")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(view().name("/member/MemberForm"));
    }
    
    @Test
    public void testAddMember_Email_없을때() throws Exception {
		mockMvc.perform(post("/member/add.do")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("name", "손담비")
				.param("email", "")
				.param("password", "2"))
				.andExpect(view().name("/member/MemberForm"));
    }
    
    @Test
    public void testAddMember_성공() throws Exception {
    		mockMvc.perform(post("/member/add.do")
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    				.param("name", "dongmyo")
    				.param("email", "dongmyo@nhnent.com")
    				.param("password", "1"))
    				.andExpect(status().is3xxRedirection())
    				.andExpect(view().name("redirect:list.do"));
	}
    
}
