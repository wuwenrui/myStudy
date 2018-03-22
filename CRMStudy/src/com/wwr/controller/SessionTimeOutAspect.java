/*package com.wwr.controller;

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

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wwr.entity.User;

public class SessionTimeOutAspect implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {  
            throw new ServletException("OncePerRequestFilter just supports HTTP requests");  
        }  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
        HttpSession session = httpRequest.getSession(true);  
  
        StringBuffer url = httpRequest.getRequestURL();  
        String[] strs = ProsReader.getString("INDICATION_APP_NAME").split("\\|");  
        if (strs != null && strs.length > 0) {  
            for (String str : strs) {  
                if (url.indexOf(str) >= 0) {  
                    filterChain.doFilter(request, response);  
                    return;  
                }  
            }  
        }  
        Object object = session.getAttribute(SessionConstants.SESSION_USER);  
        User user = object == null ? null : (User) object;  
        if (user == null) {  
            boolean isAjaxRequest = isAjaxRequest(httpRequest);  
            if (isAjaxRequest) {  
                httpResponse.setCharacterEncoding("UTF-8");  
                httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(),  
                        "您已经太长时间没有操作,请刷新页面");  
            }  
            httpResponse.sendRedirect("/page/login/user_login");  
            return;  
        }  
        filterChain.doFilter(request, response);  
        return;  
		
	}
	
	 *//** 
     * 判断是否为Ajax请求 
     * 
     * @param request HttpServletRequest 
     * @return 是true, 否false 
     *//*  
    public static boolean isAjaxRequest(HttpServletRequest request) {  
        return request.getRequestURI().startsWith("/api");  
//        String requestType = request.getHeader("X-Requested-With");  
//        return requestType != null && requestType.equals("XMLHttpRequest");  
    }  

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		如果需要注入，请取消注释  
//      ServletContext servletContext = filterConfig.getServletContext();  
//       WebApplicationContext applicationContext = (WebApplicationContext) servletContext.  
//               getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
//       if (null == topConstantsImpl) {  
//           //从Spring AC 中加载app configuration对象  
//           topConstantsImpl = applicationContext.getBean(TopConstantsImpl.class);  
//   }  
	}

	private static Logger logger = Logger.getLogger(SessionTimeOutAspect.class);   
	  
    public SessionTimeOutAspect() {  
    }  
    @Pointcut("execution(public * com.wwr.controller..*.*(..))")  
    public void controllerPointcut(){  
    }  
    @Pointcut("execution(public * com.wwr.controller.controller.*(..))")  
    public void rootPointcut(){//登录登出功能不需要Session验证  
    }     
    @Pointcut("controllerPointcut()&&(!rootPointcut())")  
    public void sessionTimeOutPointcut(){  
    }  
    @Around("sessionTimeOutPointcut()")  
    public Object sessionTimeOutAdvice(ProceedingJoinPoint pjp) throws IOException {  
        Object result = null;  
        String targetName = pjp.getTarget().getClass().getSimpleName();  
        String methodName = pjp.getSignature().getName();  
        logger.info("----------------执行方法-----------------");  
        logger.info("类名："+targetName+" 方法名："+methodName);  
        HttpServletResponse response = null;  
        for (Object param : pjp.getArgs()) {   
            if (param instanceof HttpServletResponse) {   
                response = (HttpServletResponse) param;  
            }  
        }  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();      
        HttpSession session = request.getSession();  
        if(session.getAttribute("currentUser")!=null){  
            try {  
                result = pjp.proceed();  
            } catch (Throwable e) {  
                e.printStackTrace();  
            }  
            return result;  
        } else{  
            logger.debug("Session已超时，正在跳转回登录页面");  
            response.sendRedirect(request.getContextPath());  
        }  
        return result;  
    }    
	
	
	public String sessionTime(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		User user = (User) request.getAttribute("currentUser");
		System.out.println(user);
		return null;
	}
	
	
	
	
}
*/