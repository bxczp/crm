package com.bx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bx.util.StringUtil;

/**
 * @date 2016年4月16日 LoginFilter.java
 * @author CZP
 * @parameter
 */
public class LoginFilter implements Filter {

	private String[] excludedUrls;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String excludedUrl = filterConfig.getInitParameter("excludedUrl");
		if (StringUtil.isNotEmpty(excludedUrl)) {
			this.excludedUrls = excludedUrl.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		String url = httpServletRequest.getRequestURI();
		for (String u : excludedUrls) {
			if (url.contains(u.trim())) {
				chain.doFilter(request, response);
				// 一定要return！！！
				// 跳出方法
				return;
			}
		}
		if (session.getAttribute("currentUser") == null) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
			// 一定要return！！！
			// 跳出方法
			return;
		} else {
			chain.doFilter(request, response);
			// 一定要return！！！
			// 跳出方法
			return;
		}
	}

	@Override
	public void destroy() {

	}

}
