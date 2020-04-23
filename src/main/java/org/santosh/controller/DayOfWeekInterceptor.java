/**
 * 
 */
package org.santosh.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Santosh @dat28-Apr-2018
 */
public class DayOfWeekInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean isIntercepted = true;
		Calendar cal = Calendar.getInstance();

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			response.getWriter().write("Aaj Ravivar hain bhai. Aaram karne ne");
			isIntercepted = false;
		}

		return isIntercepted;
	}

}
