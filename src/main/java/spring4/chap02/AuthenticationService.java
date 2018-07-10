package spring4.chap02;

public class AuthenticationService {
	
	private UserRepository userRepository; //유저저장소 객체선언
	private AuthFailLogger failLogger; //?? 객체선언
	
	public AuthInfo authenticate(String id, String password) {
		User user = userRepository.findUserById(id); //아이디에 해당하는 유저정보를 받아와 user객체에 넣는다
		if(user == null)
			throw new UserNotFoundException();
		
		if(!user.matchPassword(password)) {
			failLogger.insertBadPw(id, password);
			throw new AuthException();
		}
		
		return new AuthInfo(user.getId());
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setFailLogger(AuthFailLogger failLogger) {
		this.failLogger = failLogger;
	}
	
}
