package spring4.chap02.main;

import spring4.chap02.AuthException;
import spring4.chap02.AuthenticationService;
import spring4.chap02.PasswordChangeService;
import spring4.chap02.UserNotFoundException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainByXml2 {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-with-namespace.xml");
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "yssong", "1111");
		runAuthAndCatchAuthEx(authSvc, "yssong", "11111");
		runAuthAndCatchAuthEx(authSvc, "yssong", "111111");
		try {
			authSvc.authenticate("yssong", "1234");
		}catch(UserNotFoundException ex) {
			
		}
		authSvc.authenticate("yssong", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("yssong", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "yssong", "1234");
		authSvc.authenticate("yssong", "5678");
		ctx.close();
	}
	
	private static void runAuthAndCatchAuthEx (AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		}catch(AuthException ex) {
			
		}
	}

}
