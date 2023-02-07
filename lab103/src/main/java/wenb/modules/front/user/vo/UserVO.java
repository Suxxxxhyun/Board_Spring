package wenb.modules.front.user.vo;

//사용자아이디, 비밀번호를 화면에 입력하지? -> 2개의 정보를 mybatis에서 조회해줘야하는데, mybatis는 정보를 하나밖에 안받음.
//그래서 vo에 2개의 정보를 받아서 mybatis에 보내줌. 그래서 vo파일이 필요한것임

import java.io.Serializable;
import java.util.Date;

/**
 * 사용자 VO
 * <pre>
 * </pre>
 * @package wenb.modules.front.user.vo
 * @class UserVO.java
 * @author swchoi
 * @since 2022. 10. 26.
 * @version 1.0
 * @company wenbiz
 */
//board > vo 패키지가 비어있는데 UserVO를 쓰려고 한건가?
public class UserVO implements Serializable {
	private static final long serialVersionUID = -1069886853453810555L;

	private String userId;
	private String userNm;
	private String roleCd;
	private String roleNm;
	private Date regDate;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "UserVO [userId=" + userId + ", userNm=" + userNm + ", roleCd=" + roleCd + ", roleNm=" + roleNm
				+ ", regDate=" + regDate + ", password=" + password + "]";
	}
	
}
