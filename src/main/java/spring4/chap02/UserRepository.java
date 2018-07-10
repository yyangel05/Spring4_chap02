package spring4.chap02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
	
	private Map<String, User> userMap = new HashMap<String, User>();
	
	public User findUserById(String id) { //?
		return userMap.get(id);
	}
	
	public void setUsers(List<User> users) { //맵에 유저들을 저장
		for(User u : users) 
			userMap.put(u.getId(), u);
	}

}
