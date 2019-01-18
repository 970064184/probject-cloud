//package com.zhangbin.cloud.conf;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.servlet.Filter;
//
//import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
//import org.apache.shiro.mgt.DefaultSubjectDAO;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * ShiroConfig
// * 
// * @author admin
// *
// */
//@Configuration
//public class ShiroConfig {
//
//	/**
//	 * 
//	 * @param securityManager
//	 *            SecurityManager：管理所有subject，SecurityManager是shiro架构的核心，配合内部安全组件共同组成安全伞
//	 *            Realms：用于进行权限信息的验证，自己实现。Realm本质上是一个特定的安全DAO，它封装与数据源连接的细节，得到shiro所需的相关的数据。在配置shiro的时候，你必须指定至少一个realm来实现认证
//	 * @return
//	 */
//	@Bean
//	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//
// 		System.out.println("ShiroConfiguration.shirFilter()");
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		// 设置自定义的jwt过滤器
//		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
//		filters.put("jwt", new JwtFilter());
//		shiroFilterFactoryBean.setFilters(filters);
//		// 拦截器
//		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//		// 配置不会被拦截的链接，顺序判断
//		/**
//		 * anon：匿名拦截器，即不需要登录即可访问 logout：退出拦截器 authc:基于表单的拦截器，如果没有登录会跳转到相应的登录页面登录
//		 * roles:角色授权拦截器，验证用户是否拥有所有角色 perms:权限授权拦截器，验证用户是否拥有所有权限 port：端口拦截器
//		 */
//		filterChainDefinitionMap.put("/webjars/**", "anon");
//		filterChainDefinitionMap.put("/v2/api-docs", "anon");
//		filterChainDefinitionMap.put("/**/favicon.ico", "anon");
//		filterChainDefinitionMap.put("/swagger-resources/**", "anon");
//		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
//		filterChainDefinitionMap.put("/doc.html", "anon");
//		filterChainDefinitionMap.put("/druid/**", "anon");
//		filterChainDefinitionMap.put("/login", "anon");
//		// 配置退出，过滤器，其中的具体的退出代码shiro已经替我们实现了
//		filterChainDefinitionMap.put("/logout", "logout");
//		/**
//		 * 过滤器定义，从上向下顺序执行，一般将/**放在最为下边 authc：所有url都必须认证通过才可以访问；anon：所有url都可以匿名访问
//		 */
//		filterChainDefinitionMap.put("/**", "jwt");
//		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized/**");
//		// filterChainDefinitionMap.put("/**", "authc");
//		// 如果不设置默认会自动寻找web工程根目录下的/login页面
//		// 前后端分离中，登录界面跳转应由前端路由控制，后台仅返回json数据
////		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized/您暂无权限，请联系管理员");
//		// 登录成功后要跳转的链接
//		// shiroFilterFactoryBean.setSuccessUrl("/index");
//		// 未授权界面,无权限时跳转的url
//		// shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//		return shiroFilterFactoryBean;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	/*
//	 * @Bean public MyShiroRealm myShiroRealm() { MyShiroRealm myShiroRealm = new
//	 * MyShiroRealm(); return myShiroRealm; }
//	 */
//
//	/**
//	 * 
//	 * @return
//	 */
//	@Bean
//	public SecurityManager securityManager(MyShiroRealm myShiroRealm) {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		securityManager.setRealm(myShiroRealm);
//
//		/**
//		 * 关闭shiro自带的session，用自定义的jwt token做无状态登录校验
//		 */
//		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//		securityManager.setSubjectDAO(subjectDAO);
//
//		return securityManager;
//	}
//	
//	@Bean
//	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//		advisor.setSecurityManager(securityManager);
//		return advisor;
//	}
//	
//	/**
//	 * 跨域
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true); 
//	    config.addAllowedOrigin("*");
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("*");
//	    source.registerCorsConfiguration("/**", config); // CORS 配置对所有接口都有效
//	    
//	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source) );
//	    bean.setOrder(0);
//	    return bean;
//	}
//}
