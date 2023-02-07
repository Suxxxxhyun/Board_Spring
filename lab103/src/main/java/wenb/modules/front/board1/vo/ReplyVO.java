package wenb.modules.front.board1.vo;

import java.io.Serializable;
import java.util.Date;

public class ReplyVO implements Serializable{
	
	private static final long serialVersionUID = -1069886853453810555L;
	
	private Integer commentId;
	private Integer boardId;
	private String userId;
	private String comment;
	private Date regDt;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
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
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	@Override
	public String toString() {
		return "ReplyVO [commentId=" + commentId + ", boardId=" + boardId + ", userId=" + userId + ", comment="
				+ comment + ", regDt=" + regDt + "]";
	}
	
	
}
