package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import dao.MemberDao;

public class ApplicationStartUpListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext context = (ApplicationContext) event.getSource();
		
		MemberDao memberDao = (MemberDao) context.getBean("memberDao");
		memberDao.createTable();
	}

}
