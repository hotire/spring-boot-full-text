package com.googlecode.hotire.utils;

import com.googlecode.hotire.annoation.Order;
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
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        this.sortFieldsByOrder(fields);
        return fields;
    }
	
	public void sortFieldsByOrder(List<Field> fields) {
		fields.sort((o1, o2) -> {
			Order order1 = o1.getAnnotation(Order.class);
			Order order2 = o2.getAnnotation(Order.class);
			return order1.value() - order2.value();
		});
	}
}
