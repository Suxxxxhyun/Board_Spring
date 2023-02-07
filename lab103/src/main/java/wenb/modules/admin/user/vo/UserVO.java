package wenb.modules.admin.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 관리자 사이트 사용자 VO
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.vo
 * @class UserVO.java
 * @author qkrtn
 * @since 2022. 11. 25.
 * @version 1.0
 * @company wenbiz
 */

public class UserVO implements Serializable{
	private static final long serialVersionUID = -1069886853453810555L;
	
	private String userId;
	private String userNm;
	private String password;
	private String roleCd;
	private String roleNm;
	private Date regDate;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "UserVO [userId=" + userId + ", userNm=" + userNm + ", password=" + password + ", roleCd=" + roleCd
				+ ", roleNm=" + roleNm + ", regDate=" + regDate + "]";
	}
	
}
