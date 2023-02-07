package wenb.core.mvc.vo;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class RestfulStatusVO implements Serializable {
	private static final long serialVersionUID = -8586265687087048283L;
	
	private int code;
	private HttpStatus name;
	private String message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public HttpStatus getName() {
		return name;
	}
	public void setName(HttpStatus name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RestfulStatusVO [code=" + code + ", name=" + name + ", message=" + message + "]";
	}

}
