package wenb.modules.front.board1.vo;

import java.io.Serializable;
import java.util.Date;

public class Board1VO implements Serializable{
	private static final long serialVersionUID = -1069886853453810555L;
	
	private Integer seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Integer cnt;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board1VO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}
	
	
}
