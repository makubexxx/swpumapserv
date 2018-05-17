/*********************************************************************************
 * Copyright (c) 2016 woderchen@163.com
 * FILE: BaseController.java
 * 版本      DATE              BY             REMARKS
 * ----  -----------  ---------------  ------------------------------------------
 * 1.0      2016/12       陈小平           初始化
 ********************************************************************************/
package com.example.swpumapserv.base;
import com.example.swpumapserv.entity.StatusEntity;
import com.example.swpumapserv.utils.CyWebException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有的controller都需要来自这里，统一管理
 * 
 * @author woderchen
 *
 */
@Controller
public class BaseController implements InitializingBean {
	public static Gson gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping()
			.create();
	final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler({ Exception.class })
	public @ResponseBody
    String exception(Exception e, HttpServletRequest request, HttpServletResponse response) {
		e.printStackTrace();
		logger.error("#######ERROR#######", e);
		StatusEntity statusEntity = new StatusEntity();
		statusEntity.setMessage("系统出现错误，请稍后再试");
		statusEntity.setStatus(false);
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		return gsonBuilder.toJson(statusEntity);
	}

	@ExceptionHandler({ CyWebException.class })
	public @ResponseBody
    String exceptionToPage(CyWebException e, HttpServletRequest request,
                           HttpServletResponse response) {
		logger.error("catch web CyWebException：" + e.getMessage());
		// e.printStackTrace();
		StatusEntity statusEntity = new StatusEntity();
		statusEntity.setMessage(e.getErrMsg());
		statusEntity.setStatus(false);
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		return gsonBuilder.toJson(statusEntity);

	}

	/**
	 * 返回json数据格式
	 * 
	 * @param content
	 * @return
	 */
	public <T> String toJson(T content, HttpServletRequest request, HttpServletResponse response) {
		CommResponse<T> commResponse = new CommResponse<>();
		commResponse.setStatus(CommResponse.STATUS_SUCCESS);
		commResponse.setErrorMessage("");
		commResponse.setSuccessMessage("执行成功");
		commResponse.setBody(content);
		Object sn = request.getAttribute("serialno");
		commResponse.setSerialno(sn == null ? "" : sn.toString());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST");
		return gsonBuilder.toJson(commResponse, CommResponse.class);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
