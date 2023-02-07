package wenb.modules.admin.user.vo;

import java.io.Serializable;

public class RoleListVO implements Serializable{
	
	private static final long serialVersionUID = -3328981843281441126L;
	
	private String roleCd;
	private String roleNm;
	
	@Override
	public String toString() {
		return "RoleListVO [roleCd=" + roleCd + ", roleNm=" + roleNm + "]";
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
}
