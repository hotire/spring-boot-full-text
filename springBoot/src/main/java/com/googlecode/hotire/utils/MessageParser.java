package com.googlecode.hotire.utils;

import com.googlecode.hotire.annoation.FixedString;
import org.springframework.core.annotation.AnnotationUtils;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


public class MessageParser {
	private MessageParser() {}

	public static String getMessage(final Object parseObject) {
		final StringBuilder messageStr = new StringBuilder();
		Arrays.stream(parseObject.getClass().getDeclaredFields())
			  .filter(field -> Objects.nonNull(AnnotationUtils.findAnnotation(field, FixedString.class)))
			  .sorted(FixedString.FIELD_COMPARATOR)
			  .forEach(field -> {
			  	try {
					final FixedString fixedStringInfo = field.getAnnotation(FixedString.class);
					final Object value = Optional.ofNullable(new PropertyDescriptor(field.getName(), parseObject.getClass()).getReadMethod().invoke(parseObject))
												 .orElse("");

					final byte[] data = value.toString().getBytes();
					final String valueString = new String(data, "euc-kr");
					final int strLength = fixedStringInfo.value();
					final String cutFieldValue = cutStringByByteLength(valueString, strLength);

					messageStr.append(fixedStringInfo.type().fill(cutFieldValue, strLength));
				} catch (Exception e) {
			  		// ignore
				}
			  });
		return messageStr.toString();
	}

	public static String parseMessage(String message, Object parseObject) {
		final AtomicInteger fieldIndex = new AtomicInteger();

		Arrays.stream(parseObject.getClass().getDeclaredFields())
			  .filter(field -> Objects.nonNull(AnnotationUtils.findAnnotation(field, FixedString.class)))
			  .sorted(FixedString.FIELD_COMPARATOR)
			  .forEach(field -> {
				  try {
					  final FixedString fixedStringInfo = field.getAnnotation(FixedString.class);
					  final byte[] data = message.getBytes("euc-kr");
					  final int strLength = fixedStringInfo.value();
					  final byte[] fieldData = Arrays.copyOfRange(data, fieldIndex.get(), fieldIndex.get() + strLength);
					  final String value = new String(fieldData, "euc-kr");

					  new PropertyDescriptor(field.getName(), parseObject.getClass()).getWriteMethod().invoke(parseObject, value);
					  fieldIndex.set(fieldIndex.get() + strLength);
				  } catch (Exception e) {
					  // ignore
				  }
			  });

		if (message.length() <= fieldIndex.get()) {
			return "";
		}

		return message.substring(fieldIndex.get());
	}

	public static String cutStringByByteLength(String s, int byteLimit) {

		int n = Math.min(byteLimit - 1, s.length() - 1);

		while (s.getBytes().length > byteLimit) {
			s = s.substring(0, n--);
		}

		return s;
	}

	public static String fillAfterSpace(String s, int byteLimit) {
		final StringBuilder builder = new StringBuilder();
		builder.append(s);

		final int stringLen = s.getBytes().length;
		for (int i = 0; i < byteLimit - stringLen; i++) {
			builder.append(" ");
		}

		return builder.toString();
	}

	public static String fillBeforeZeroSpace(String s, int byteLimit) {
		final StringBuilder builder = new StringBuilder();
		final int stringLen = s.getBytes().length;

		for (int i = 0; i < byteLimit - stringLen; i++) {
			builder.append("0");
		}

		builder.append(s);
		return builder.toString();
	}
}
