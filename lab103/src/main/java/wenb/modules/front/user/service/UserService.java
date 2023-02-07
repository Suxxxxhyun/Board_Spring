package wenb.modules.front.user.service;

import wenb.modules.front.user.vo.UserVO;

/**
 * 사용자 관련 서비스
 * <pre>
 * </pre>
 * @package wenb.modules.front.user.service
 * @class UserService.java
 * @author swchoi
 * @since 2022. 10. 26.
 * @version 1.0
 * @company wenbiz
 */
public interface UserService {

	UserVO getUser(UserVO vo) throws Exception; //select * from where userid = ? and userpassword = ? -> 결과가 row가 한개, 그 row를 vo에 담은 것
}
