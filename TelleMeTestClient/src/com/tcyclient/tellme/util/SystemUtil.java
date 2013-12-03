package com.tcyclient.tellme.util;



import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("appContext")
@Scope("singleton")
public class SystemUtil implements ApplicationContextAware {

	private static ApplicationContext context;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context = applicationContext;
		
		
	}

	
	public static ApplicationContext getContext() {
		return context;
	}
	
	public static  Object getBean(String name) {
		return context.getBean(name);
	}
	
	public static Object findBean(String name) {
		return context.getBean(name);
	}
}
