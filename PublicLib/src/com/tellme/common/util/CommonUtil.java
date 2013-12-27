package com.tellme.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.json.JSONObject;

import com.tellme.common.entity.TellMeMessageData;

public class CommonUtil {
	public void name() {

	}

	public static <T> Object JSONObjectToBean(JSONObject jsonObject, Class<T> cl) {
		Field[] fields = cl.getFields();
		Object object = (Object) getObj(cl);
		for (Field f : fields) {
            String fieldName=f.getName();   
            String stringLetter=fieldName.substring(0, 1).toUpperCase();
            String getName="get"+stringLetter+fieldName.substring(1);   
            String setName="set"+stringLetter+fieldName.substring(1); 
            try {
				Method getMethod=cl.getMethod(getName, new Class[]{});
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
            try {
				Method setMethod=cl.getMethod(setName, new Class[]{f.getType()});
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.getType();
			Object defobObject=jsonObject.opt(f.getName());
			if(object==null)
			{
				
			}

		}
		Object beandata = (Object) net.sf.json.JSONObject
				.toBean(jsonObject, cl);
		return beandata;
	}

	public static Object getObj(Class clazz) {
		try {
			Constructor con = clazz.getConstructor();
			return con.newInstance();

		} catch (Exception e) {
			return null;

		}

	}
	public Object setFieldValue(Object obj,String setName,Object value,Class<?> type)
	{
        try {
			Method setMethod=obj.getClass().getMethod(setName,type);
		      try {  
		    	  setMethod.invoke(obj, value);
		    	  return obj;
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	public Object getFieldValue(Object obj,String getName)
	{
        try {
			Method getMethod=obj.getClass().getMethod(getName, new Class[]{});
			try {
				Object value=getMethod.invoke(obj, new Object[]{});
				return value;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch ( InvocationTargetException e) {
			// TODO: handle exception
		}
		return null;
	}

}
