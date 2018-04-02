package com.googlecode.hotire.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author : hoTire
 * @comment : Lookup own and inherited fields   
 * Singleton holder pattern
 */
public class TypeUtils {
	private TypeUtils() {}
	private final static class SingletonHolder {
		private final static TypeUtils instance = new TypeUtils();
	}
	public static TypeUtils getInstance() {
		return SingletonHolder.instance;
	}
	public List<Field> getInheritedFields(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
}
