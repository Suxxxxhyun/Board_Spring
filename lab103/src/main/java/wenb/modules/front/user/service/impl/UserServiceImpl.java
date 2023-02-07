package wenb.modules.front.user.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import wenb.modules.front.user.mapper.UserMapper;
import wenb.modules.front.user.service.UserService;
import wenb.modules.front.user.vo.UserVO;

/**
 * 사용자 관련 서비스 구현체
 * <pre>
 * </pre>
 * @package wenb.modules.front.user.service.impl
 * @class UserServiceImpl.java
 * @author swchoi
 * @since 2022. 10. 26.
 * @version 1.0
 * @company wenbiz
 */
@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	/**
	 * 사용자 정보 조회
	 */
	@Override
	public UserVO getUser(UserVO vo) throws Exception {
		return userMapper.selectUser(vo);
	}
}
