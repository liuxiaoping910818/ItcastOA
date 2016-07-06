package cn.itcast.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.PrivilegeService;

public class InitServletContextListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();

		// 得到Service的实例对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		
		// 准备所有顶级权限的集合（顶级菜单）
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
		System.out.println("-- 已准备好顶级权限的数据 --");
		
		// 准备所有权限URL的集合
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("-- 已准备好所有权限的URL数据 --");
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
