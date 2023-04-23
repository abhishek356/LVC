//package com.spring.lvc.config;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class SpringConfig //implements WebApplicationInitializer 
//{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		
//		//While using xml based files please use the below  piece of code.
//
////		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
////		webApplicationContext.setConfigLocation("classpath:webConfig.xml");
////		
//		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//		webApplicationContext.register(webConfig.class);
//		//Creating Dispatcher Servlet
//		
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
//		
//		//Registered dispatcher servlet with servlet context
//		
//		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",dispatcherServlet);
//		
//		myCustomDispatcherServlet.setLoadOnStartup(1);
//		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
//		
//		System.out.println("Inside the springConfig file <<<< abhishek ");
//		
//	}
//
//}
