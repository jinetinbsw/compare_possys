package kr.or.possys.Staff_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Staff_interceptor extends HandlerInterceptorAdapter{

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        try {
	            //admin�̶�� ����key�� ���� ������ ���ϰ�� �α����������� �̵�
	            if(request.getSession().getAttribute("admin") == null ){
	                    response.sendRedirect("/possys/");
	                    System.out.println("������������ �α��� ȭ������ �̵�");
	                    return false;
	            }
	            System.out.println("������������");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //admin ����key ����� main ������ �̵�
	        return true;
	    }
	 
	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        super.postHandle(request, response, handler, modelAndView);
	    }
	 
	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        super.afterCompletion(request, response, handler, ex);
	    }
	 
	    @Override
	    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        super.afterConcurrentHandlingStarted(request, response, handler);
	    }
	
}