package com.googlecode.hotire.utils;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.googlecode.hotire.annoation.FixedString;
import com.googlecode.hotire.constants.MessageFieldType;
import java.util.Objects;


/**
 * 
 * @author : hoTire
 * @comment : Parser (correct way)
 */
public class MessageParser {
	private MessageParser() {}

	public static String getMessage(Object parseObject) {
		List<Field> fields = TypeUtils.getInstance().getInheritedFields(parseObject.getClass());
		StringBuilder messageStr = new StringBuilder();
		for (Field field : fields) {
			try {
				FixedString fixedStringInfo = field.getAnnotation(FixedString.class);
				if (fixedStringInfo == null) {
					continue;
				}
				Object value = new PropertyDescriptor(field.getName(), parseObject.getClass()).getReadMethod()
						.invoke(parseObject);
				value = value == null ? "" : value;
				byte[] data = value.toString().getBytes();
				String valueString = new String(data, "euc-kr");
				int strLength = fixedStringInfo.value();
				String cutFieldValue = cutStringByByteLength(valueString, strLength);
			
				if (fixedStringInfo.type() == MessageFieldType.NUMERIC) {
					messageStr.append(fillBeforeZeroSpace(cutFieldValue, strLength));
				} else {
					messageStr.append(fillAfterSpace(cutFieldValue, strLength));
				}
			} catch (Exception e) {
				// ignore
			}
		}
		return messageStr.toString();
	}

	public static String parseMessage(String message, Object parseObject) {
		List<Field> fields = TypeUtils.getInstance().getInheritedFields(parseObject.getClass());
		int fieldIndex = 0;
		byte[] data = null;
		try {
			data = message.getBytes("euc-kr");
		} catch (UnsupportedEncodingException e1) {
			// ignore
		}

		for (Field field : fields) {
			try {
				FixedString fixedStringInfo = field.getAnnotation(FixedString.class);
				if (Objects.isNull(fixedStringInfo)) {
					continue;
				}
				int strLength = fixedStringInfo.value();
				byte[] fieldData = Arrays.copyOfRange(data, fieldIndex, fieldIndex + strLength);

				String value = new String(fieldData, "euc-kr");

				new PropertyDescriptor(field.getName(), parseObject.getClass()).getWriteMethod().invoke(parseObject,
						value);
				fieldIndex += strLength;
			} catch (Exception e) {
				// ignore
			}
		}
		if (message.length() <= fieldIndex) {
			return "";
		}
		return message.substring(fieldIndex);
	}

	private static String cutStringByByteLength(String s, int byteLimit) {

		byte[] data = s.getBytes();
		if (data.length <= byteLimit) {
			return s;
		}
		int n = Math.min(byteLimit - 1, s.length() - 1);
		do {
			s = s.substring(0, n--);
		} while (data.length > byteLimit);

		return s;
	}

	private static String fillAfterSpace(String s, int byteLimit) {
		StringBuilder builder = new StringBuilder();
		builder.append(s);
		int stringLen = 0;

		byte[] data = s.getBytes();
		stringLen = data.length;
		for (int i = 0; i < byteLimit - stringLen; i++) {
			builder.append(" ");
		}
		return builder.toString();
	}

	private static String fillBeforeZeroSpace(String s, int byteLimit) {
		StringBuilder builder = new StringBuilder();

		byte[] data = s.getBytes();
		int stringLen = data.length;
		for (int i = 0; i < byteLimit - stringLen; i++) {
			builder.append("0");
		}
		builder.append(s);
		return builder.toString();
	}
}
