package com.googlecode.hotire.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.googlecode.hotire.constants.MessageFieldType;

/**
 * 
 * @author : hoTire
 * @comment : Annotation (field type,length) 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FixedString {
	int value();
	MessageFieldType type();
}
