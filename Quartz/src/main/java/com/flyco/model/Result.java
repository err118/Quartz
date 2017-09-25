package com.flyco.model;

import java.io.Serializable;



/**
 * 统一返回体
 * 
 * @author
 *
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "0";
	public static final String FAIL = "-1";
	
	private String code = FAIL;
	private String message = null;
	private Object data = null;

	private Result(){}

	private Result(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	private Result(String code, String message) {
		this(code, message, null);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Result failMessage(String message) {
		return new Result(FAIL, message);
	}

	public static Result failMessage(String code, String message) {
		return new Result(code, message);
	}

	public static Result successMessage(String message, Object data) {
		return new Result(SUCCESS, message, data);
	}
}
