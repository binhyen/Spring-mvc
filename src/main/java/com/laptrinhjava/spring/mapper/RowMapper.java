package com.laptrinhjava.spring.mapper;

import java.sql.ResultSet;

public interface RowMapper<E> {
	E mapRow(ResultSet rs);
}
