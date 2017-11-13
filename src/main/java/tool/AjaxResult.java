package tool;

import java.io.Serializable;

public class AjaxResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean result;//处理结果

	private String code;//编号（用来区分的预留字段）
	
	private Object data;//传输的对象
	
	private String errorMessage;//传输的字符串信息
	
	private String redirectURL;//需要跳转的url
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	
	/**
	 * 
	 * @param result			处理结果
	 * @param code				编号（用来区分的预留字段） 
	 * @param data				传输的对象
	 * @param errorMessage		传输的字符串信息
	 * @param redirectURL				需要跳转的url
	 */
	public AjaxResult(boolean result,String code,Object data,String errorMessage,String redirectURL){
		this.result = result;
		this.code = code;
		this.data = data;
		this.errorMessage = errorMessage;
		this.redirectURL = redirectURL;
	}
	
	/**
	 * 
	 * @param result			处理结果
	 * @param code				编号（用来区分的预留字段） 
	 * @param data				传输的对象
	 */
	public AjaxResult(boolean result,String code,Object data){
		this.result = result;
		this.code = code;
		this.data = data;
		
	}
	
	/**
	 * 
	 * @param result			处理结果
	 * @param code				编号（用来区分的预留字段） 
	 * @param errorMessage		传输的字符串信息
	 * @param redirectURL				需要跳转的url
	 */
	public AjaxResult(boolean result,String code,String errorMessage,String redirectURL){
		this.result = result;
		this.code = code;
		this.errorMessage = errorMessage;	
		this.redirectURL = redirectURL;
	}
	
	
}
