package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mybatis.spring.SqlSessionTemplate;
import vo.Member;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberDaoTest {
    @Mock
    private SqlSessionTemplate sqlSessionTemplate;

    @InjectMocks
    private MemberDao memberDao;

    private List<Member> members = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        members.add(new Member(1, "신동민", "dongmyo@nhnent.com", "1"));
        members.add(new Member(2, "콤틴", "comtin@nhnent.com", "*"));
        members.add(new Member(3, "손담비", "sondambi@nhnent.com", "abcde"));
        members.add(new Member(4, "만두", "goodmandoo@nhnent.com", "10000do"));
        members.add(new Member(5, "나박", "nabak@nhnent.com", "kimchi"));
    }

    @After
    public void tearDown() throws Exception {
        members.clear();
    }

    @Test
    public void testMemberExists() throws Exception {
        assertNotNull("dongmyo@nhnent.com NOT EXISTS",         checkMemberExistence("dongmyo@nhnent.com", "1"));
        assertNotNull("sondambi@nhnent.com NOT EXISTS",        checkMemberExistence("sondambi@nhnent.com", "abcde"));
        assertNull("goodmandoo@nhnent.com PASSWORD MATCH",     checkMemberExistence("goodmandoo@nhnent.com", ""));
        assertNull("franky@nhnent.com EXISTS!!! unbelievable", checkMemberExistence("franky@nhnent.com", "1111"));
    }

    private Member checkMemberExistence(String email, String password) {
        Member foundMember = null;

        for(Member m: members) {
            if(m.getEmail().equals(email) && m.getPassword().equals(password)) {
                foundMember = m;
                break;
            }
        }

        when(sqlSessionTemplate.selectOne(eq("memberDao.selectMemberExist"), anyObject())).thenReturn(foundMember);

        Member m1 = memberDao.exist(email, password);
        return m1;
    }

    @Test
    public void testMemberAdd() throws Exception {
        when(sqlSessionTemplate.insert(eq("memberDao.insertMember"), isA(Object.class))).thenReturn(1);

        Member newMember = new Member(6, "아지몽", "ajimong@nhnent.com", "mongmong");

        assertEquals(1, memberDao.insert(newMember));
    }

}
