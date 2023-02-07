package wenb.modules.admin.user.mapper;

import java.io.IOException;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import wenb.modules.admin.user.vo.RoleListVO;
import wenb.modules.admin.user.vo.UserListVO;
import wenb.modules.admin.user.vo.UserVO;
import wenb.modules.admin.user.vo.commentListVO;

@Mapper
public interface AdminUserMapper {
	
	/**
	 * 관리자에서 사용자 관련 매퍼
	 * <pre>
	 * </pre>
	 * @package wenb.modules.admin.user.mapper
	 * @class AdminUserMapper.java
	 * @author qkrtn
	 * @since 2022. 11. 18.
	 * @version 1.0
	 * @company wenbiz
	 */
	
	public List<UserListVO> selectList(UserListVO vo) throws IOException;
	//이름, 아이디를 기반으로 해서 목록에 아이디, 이름, 역할을 페이지에 보여줄 생각인데,
	//이렇다면, 사용자에서 받은 입력값은 이름, 아이디이지? 이름과 아이디를 UserListVO에 담을 것임(이게 파라미터 UserListVO vo)임
	
	/**
	 * 사용자 상세정보반환
	 * <pre>
	 * </pre>
	 * @method selectList
	 * @return List<UserListVO>
	 * @date 2022. 11. 18.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws IOException
	 */
	
	public UserVO selectInfo(UserVO vo) throws Exception;
	
	/**
	 * 권한 목록 반환
	 * <pre>
	 * </pre>
	 * @method selectRoleList
	 * @return List<RoleListVO>
	 * @date 2022. 11. 25.
	 * @author qkrtn
	 * @return
	 * @throws Exception
	 */
	
	public List<RoleListVO> selectRoleList() throws Exception;
	
	/**
	 * 사용자 정보 수정
	 * <pre>
	 * </pre>
	 * @method updateUser
	 * @return void
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	public void updateUser(UserVO vo) throws Exception;
	
	/**
	 * 사용자 등록
	 * <pre>
	 * </pre>
	 * @method insertUser
	 * @return void
	 * @date 2022. 12. 2.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	public void insertUser(UserVO vo) throws Exception;
	
	/**
	 * 댓글 조회
	 * <pre>
	 * </pre>
	 * @method selectcommentList
	 * @return List<commentListVO>
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<commentListVO> selectcommentList(UserVO vo) throws Exception;
	
	/**
	 * 
	 * 댓글 등록
	 * <pre>
	 * </pre>
	 * @method insertComment
	 * @return void
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	public void insertComment(commentListVO vo) throws Exception;
}
