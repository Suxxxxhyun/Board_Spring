package wenb.modules.admin.user.service;

import java.util.List;

import wenb.modules.admin.user.vo.RoleListVO;
import wenb.modules.admin.user.vo.UserListVO;
import wenb.modules.admin.user.vo.UserVO;
import wenb.modules.admin.user.vo.commentListVO;

/**
 * 관리자 사용자 서비스
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.service
 * @class AdminUserService.java
 * @author qkrtn
 * @since 2022. 11. 18.
 * @version 1.0
 * @company wenbiz
 */
public interface AdminUserService {
	
	/**
	 * 사용자 목록 반환
	 * <pre>
	 * </pre>
	 * @method getList
	 * @return List<UserListVO>
	 * @date 2022. 11. 18.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<UserListVO> getList(UserListVO vo) throws Exception;
	
	/**
	 * 사용자 상세정보 반환
	 * <pre>
	 * </pre>
	 * @method getInfo
	 * @return UserVO
	 * @date 2022. 11. 25.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	UserVO getInfo(UserVO vo) throws Exception;
	
	/**
	 * 권한목록 반환
	 * <pre>
	 * </pre>
	 * @method getRoleList
	 * @return List<RoleListVO>
	 * @date 2022. 11. 25.
	 * @author qkrtn
	 * @return
	 * @throws Exception
	 */
	List<RoleListVO> getRoleList() throws Exception;
	
	/**
	 * 사용자 정보 수정
	 * <pre>
	 * </pre>
	 * @method modifyUser
	 * @return void
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void modifyUser(UserVO vo) throws Exception;
	
	/**
	 * 사용자 등록
	 * <pre>
	 * </pre>
	 * @method createUser
	 * @return void
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void createUser(UserVO vo) throws Exception;
	
	/**
	 * 댓글 목록
	 * <pre>
	 * </pre>
	 * @method getCommentList
	 * @return List<commentListVO>
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<commentListVO> getCommentList(UserVO vo) throws Exception;
	
	/**
	 * 
	 * 댓글 등록
	 * <pre>
	 * </pre>
	 * @method createComment
	 * @return void
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void createComment(commentListVO vo) throws Exception;
}
