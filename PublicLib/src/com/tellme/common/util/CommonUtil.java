package com.tellme.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class CommonUtil {
	private static final Logger logger = Logger.getLogger(CommonUtil.class);

	public static <T> Object JSONObjectToBean(JSONObject jsonObject, Class<T> cl) {
		Field[] fields = cl.getFields();
		Object object = (Object) getObj(cl);
		if (object == null) {
			return null;
		}
		for (Field f : fields) {
			String fieldName = f.getName();
			Class<?> ftype = f.getType();
			String stringLetter = fieldName.substring(0, 1).toUpperCase();
			String getName = "get" + stringLetter + fieldName.substring(1);
			String setName = "set" + stringLetter + fieldName.substring(1);
			Object newvalue = jsonObject.opt(f.getName());
			if (newvalue != null) {
				Method method = getMethod(object, setName, ftype);
				if (method == null) {
					continue;
				}
				try {
					String value = String.valueOf(newvalue);
					String fieldType = f.getType().getSimpleName();
					if ("String".equals(fieldType)) {
						method.invoke(object, newvalue);
					} else if ("Date".equals(fieldType)) {
						Date temp = parseDate(String.valueOf(newvalue));
						method.invoke(object, temp);
					} else if ("Integer".equals(fieldType)
							|| "int".equals(fieldType)) {
						Integer intval = Integer.parseInt(value);
						method.invoke(object, intval);
					} else if ("Long".equalsIgnoreCase(fieldType)) {
						Long temp = Long.parseLong(value);
						method.invoke(object, temp);
					} else if ("Double".equalsIgnoreCase(fieldType)) {
						Double temp = Double.parseDouble(value);
						method.invoke(object, temp);
					} else if ("Boolean".equalsIgnoreCase(fieldType)) {
						Boolean temp = Boolean.parseBoolean(value);
						method.invoke(object, temp);
					} else {
						logger.info("not supper type" + fieldType);
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// setFieldValue(object, setName, newvalue, ftype);
			}

		}
		return object;
	}

	public static Object getObj(Class clazz) {
		try {
			Constructor con = clazz.getConstructor();
			return con.newInstance();

		} catch (Exception e) {
			return null;

		}

	}

	public static Method getMethod(Object obj, String setName, Class<?> type) {
		Method setMethod = null;
		;
		try {
			setMethod = obj.getClass().getMethod(setName, type);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return setMethod;
	}

	public static Object setFieldValue(Object obj, String setName,
			Object value, Class<?> type) {
		try {
			Method setMethod = obj.getClass().getMethod(setName, type);
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
			// e.printStackTrace();
		}
		return null;
	}

	public static Object getFieldValue(Object obj, String getName) {
		try {
			Method getMethod = obj.getClass()
					.getMethod(getName, new Class[] {});
			try {
				Object value = getMethod.invoke(obj, new Object[] {});
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
		} catch (InvocationTargetException e) {
			// TODO: handle exception
		}
		return null;
	}

	public static Date parseDate(String datestr) {
		if (null == datestr || "".equals(datestr)) {
			return null;
		}
		try {
			String fmtstr = null;
			if (datestr.indexOf(':') > 0) {
				fmtstr = "yyyy-MM-dd HH:mm:ss";
			} else {

				fmtstr = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(fmtstr,
					Locale.getDefault());
			return sdf.parse(datestr);
		} catch (Exception e) {
			return null;
		}
	}

	public JSONArray getJSONArray(InputStream in) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.readFromStream(in);
		return JSONArray.fromObject(json);
	}

	public JSONArray getJSONArray(String xml) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xml);
		return JSONArray.fromObject(json);
	}

	public String getXML(JSONObject json) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setRootName("xml");
		return xmlSerializer.write(json);
	}

	public String getXML(Object object, String root) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setRootName(root);
		Class cl = object.getClass();
		Field[] fields = cl.getFields();
		return null;
	}

	public static String fromJavaToXML(Serializable object,String root) {
		XStream xs = new XStream();
		String xml=xs.toXML(object);
		String oldroot=object.getClass().getName();
		xml=xml.replaceAll(oldroot, root);
		System.out.println(oldroot);
		return xml;
	}

	/**
	 * Convert from XML to object
	 * 
	 * @param xml
	 * @return
	 */
	public static Object fromXMLToJava(String xml) {
		XStream xs = new XStream();
		return xs.fromXML(xml);
	}

	/**
	 * not work
	 * @param in
	 * @return
	 */
	public  Object fromStreamToJava(InputStream in) {
		XStream xs = new XStream();
		return xs.fromXML(in);
	}
	public  Document fromInStream(InputStream in)
	{
		SAXReader reader = new SAXReader();
		Document doc=null;
		try {
			doc = reader.read(in);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
		
	}
	public static Document fromString(String xml)
	{
		SAXReader reader = new SAXReader();
		Document doc=null;
		try {
			try {
				doc = reader.read(new ByteArrayInputStream(xml.getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
		
	}

}
