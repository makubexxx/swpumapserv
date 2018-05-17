/*********************************************************************************
 * Copyright (c) 2016 woderchen@163.com
 * FILE: BaseControllerAdvice.java
 * 版本      DATE              BY             REMARKS
 * ----  -----------  ---------------  ------------------------------------------
 * 1.0      2016/12       陈小平           初始化
 ********************************************************************************/
package com.example.swpumapserv.base;

import com.example.swpumapserv.utils.DateHelper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;


/**
 * 对传入参数进行预先处理
 * @author woderchen
 *
 */
@ControllerAdvice
public class BaseControllerAdvice {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}
			
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				setValue(DateHelper.parseDate(text));
			}
		});
	}
	
}
