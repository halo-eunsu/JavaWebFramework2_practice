package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration(classes = config.RootContextConfiguration.class),
	@ContextConfiguration(classes = config.ServletContextConfiguration.class)
})
public class MemberAddControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
    @Before
    public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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
