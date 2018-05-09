package com.googlecode.hotire.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.googlecode.hotire.annoation.Order;
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
        sortFieldsByOrder(fields);
        return fields;
    }
	
	public static void sortFieldsByOrder(List<Field> list) {
		Collections.sort(list, new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				Order order1 = o1.getAnnotation(Order.class);
				Order order2 = o2.getAnnotation(Order.class);
				return order1.value() - order2.value();
			}
		});
	}
}
