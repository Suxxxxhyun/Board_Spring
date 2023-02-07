package wenb.modules.admin.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import wenb.modules.admin.user.mapper.AdminUserMapper;
import wenb.modules.admin.user.service.AdminUserService;
import wenb.modules.admin.user.vo.RoleListVO;
import wenb.modules.admin.user.vo.UserListVO;
import wenb.modules.admin.user.vo.UserVO;
import wenb.modules.admin.user.vo.commentListVO;

/**
 * 관리자 사용자 서비스 구현체
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.service.impl
 * @class AdminUserServiceImpl.java
 * @author qkrtn
 * @since 2022. 11. 18.
 * @version 1.0
 * @company wenbiz
 */

@Service("adminUserService") //단순히 @Service라고 하면, 스프링에서 adminUserServiceImpl까지 정보가 들억가기 때문에 impl정보를 지우려고 일부러 이름을 adminUserService라고 넣어줌.
public class AdminUserServiceImpl extends EgovAbstractServiceImpl implements AdminUserService{
	@Resource(name="adminUserMapper")
	AdminUserMapper adminUserMapper;
	
	/**
	 * 사용자 목록 반환
	 */
	@Override
	public List<UserListVO> getList(UserListVO vo) throws Exception {
		return adminUserMapper.selectList(vo);
	}
	
	/*
	 * 사용자 상세 정보 반환
	 */
	@Override
	public UserVO getInfo(UserVO vo) throws Exception{
		return adminUserMapper.selectInfo(vo);
	}
	
	@Override
	public List<RoleListVO> getRoleList() throws Exception{
		return adminUserMapper.selectRoleList();
	}
	
	/**
	 * 사용자 정보 수정
	 */
	//반환값이 없으니까 return추가하지않음.
	@Override
	public void modifyUser(UserVO vo) throws Exception{
		adminUserMapper.updateUser(vo);
	}
	
	@Override
	public void createUser(UserVO vo) throws Exception{
		adminUserMapper.insertUser(vo);
	}
	
	@Override
	public List<commentListVO> getCommentList(UserVO vo) throws Exception{
		return adminUserMapper.selectcommentList(vo);
	}
	
	@Override
	public void createComment(commentListVO vo) throws Exception{
		adminUserMapper.insertComment(vo);
	}
}
