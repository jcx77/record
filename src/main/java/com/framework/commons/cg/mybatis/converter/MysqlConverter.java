package com.framework.commons.cg.mybatis.converter;

import java.math.BigInteger;
import java.util.Date;

public class MysqlConverter implements DBConverter {
	public Class<?> dbTypeToJavaType(String type, int size, int precision) {
		if ("VARCHAR".equals(type)) {
			return String.class;
		} else if ("CHAR".equals(type)) {
			return String.class;
		} else if ("DATE".equals(type)) {
			return Date.class;
		} else if ("DATETIME".equals(type)) {
			return Date.class;
		} else if ("INT".equals(type)) {
			return Integer.class;
		} else if ("BIGINT".equals(type)) {
			return Long.class;
		} else if ("TEXT".equals(type)) {
			return String.class;
		}else if ("DECIMAL".equals(type)) {
			return BigInteger.class;
		} else {
			throw new RuntimeException("无法对[" + type + "]类型进行转换");
		}
	}
}