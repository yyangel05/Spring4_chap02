package spring4.chap02.main;

import spring4.chap02.AuthException;
import spring4.chap02.AuthenticationService;
import spring4.chap02.PasswordChangeService;
import spring4.chap02.UserNotFoundException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainByXml {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config.xml");
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "gyyoon", "1111");
		runAuthAndCatchAuthEx(authSvc, "gyyoon", "11111");
		runAuthAndCatchAuthEx(authSvc, "gyyoon", "111111");
		try {
			authSvc.authenticate("gyyoon", "1234");
		}catch(UserNotFoundException ex) {
			
		}
		authSvc.authenticate("gyyoon", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("gyyoon", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "gyyoon", "1234");
		authSvc.authenticate("gyyoon", "5678");
		ctx.close();
	}
	
	private static void runAuthAndCatchAuthEx (AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		}catch(AuthException ex) {
			
		}
	}

}
