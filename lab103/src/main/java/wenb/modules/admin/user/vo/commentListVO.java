package wenb.modules.admin.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 댓글 목록 VO 
 * <pre>
 * </pre>
 * @package wenb.modules.admin.user.vo
 * @class commentListVO.java
 * @author qkrtn
 * @since 2022. 12. 16.
 * @version 1.0
 * @company wenbiz
 */
public class commentListVO implements Serializable{
	
	private static final long serialVersionUID = -3328981843281441126L;
	
	private int commentId;
	private String userId;
	private String comment;
	private Date regDate;
	
	@Override
	public String toString() {
		return "commentListVO [commentId=" + commentId + ", userId=" + userId + ", comment=" + comment + ", regDate="
				+ regDate + "]";
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
