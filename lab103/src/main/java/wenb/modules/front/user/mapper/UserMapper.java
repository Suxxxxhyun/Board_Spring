package wenb.modules.front.user.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import wenb.modules.front.user.vo.UserVO;

/**
 * 사용자 관련 Mapper
 * <pre>
 * </pre>
 * @package wenb.modules.front.user.mapper
 * @class User.java
 * @author swchoi
 * @since 2022. 10. 26.
 * @version 1.0
 * @company wenbiz
 */
@Mapper("userMapper")
public interface UserMapper {

	/**
	 * 사용자 정보 조회
	 * <pre>
	 * </pre>
	 * @method selectUser
	 * @return UserVO
	 * @date 2022. 10. 26.
	 * @author swchoi
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public UserVO selectUser(UserVO vo) throws Exception;
}
