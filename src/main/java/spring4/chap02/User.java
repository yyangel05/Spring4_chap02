package spring4.chap02;

public class User {
	
	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean matchPassword(String inputPasswd) {
		return password.equals(inputPasswd);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!matchPassword(oldPassword)) //기존의 패스워드와 사용자가 적은 기본 패스워드가 서로 다르면
			throw new IllegalArgumentException("illegal password"); //서로 다른 패스워드라고 예외를 발생시킨다.
		//기존 패스워드와 사용자가 적은 패스워드가 서로 같으면
		password = newPassword; //새로운 패스워드로 기존 패스워드를 변경한다
	}

}
