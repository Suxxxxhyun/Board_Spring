package wenb.modules.admin.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 관리자에서 사용하는 User 목록용 VO
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.vo
 * @class UserListVO.java
 * @author qkrtn
 * @since 2022. 11. 18.
 * @version 1.0
 * @company wenbiz
 */
public class UserListVO implements Serializable{

	private static final long serialVersionUID = -3328981843281441126L;
	
	private String userId;
	private String userNm;
	private String roleCd;
	private String roleNm;
	private Date regDate;
	private String regDt;
	private String searchCondition;
	private String searchKeyword;
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getRoleCd() {
		return roleCd;
	}
	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}
	public String getRoleNm() {
		return roleNm;
	}
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserListVO [userId=" + userId + ", userNm=" + userNm + ", roleCd=" + roleCd + ", roleNm=" + roleNm
				+ ", regDate=" + regDate + ", regDt=" + regDt + "]";
	}
	

}
