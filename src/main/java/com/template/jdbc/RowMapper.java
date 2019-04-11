package com.template.jdbc;

import java.sql.ResultSet;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:08
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int row) throws Exception;

}
