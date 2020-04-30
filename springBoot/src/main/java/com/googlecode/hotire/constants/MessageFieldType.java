package com.googlecode.hotire.constants;


import static com.googlecode.hotire.utils.MessageParser.fillAfterSpace;
import static com.googlecode.hotire.utils.MessageParser.fillBeforeZeroSpace;

public enum MessageFieldType {
	NUMERIC {
		@Override
		public String fill(final String text, final int byteLimit) {
			return fillBeforeZeroSpace(text, byteLimit);
		}
	},
	ALPHABET {
		@Override
		public String fill(final String text, final int byteLimit) {
			return fillAfterSpace(text, byteLimit);
		}
	};

	public abstract String fill(final String text, final int byteLimit);
}
