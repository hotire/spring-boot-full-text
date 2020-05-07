package com.googlecode.hotire.annoation;

import com.googlecode.hotire.constants.MessageFieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Comparator;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FixedString {
	int value();
	MessageFieldType type();
	int order();

	Comparator<Field> FIELD_COMPARATOR = (o1, o2) -> {
		final int order1 = o1.getAnnotation(FixedString.class).order();
		final int order2 = o2.getAnnotation(FixedString.class).order();
		return order1 - order2;
	};
}
