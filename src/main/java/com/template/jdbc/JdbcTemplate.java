package com.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:10
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values){
        try {
            //获取连接
            Connection connection = this.getConnection();
            //创建语句集
            PreparedStatement preareStatement = this.createPreareStatement(connection, sql);
            //执行语句
            ResultSet resultSet = this.executeQuery(preareStatement, values);
            //处理结果集
            List<?> result = this.parseResultSet(resultSet,rowMapper);
            //关闭结果集
            this.closeResultSet(resultSet);
            //关闭语句集
            this.closePrepareStatement(preareStatement);
            //关闭连接
            this.closeConnection(connection);

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    final void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    final void closePrepareStatement(PreparedStatement preareStatement) throws Exception {
         preareStatement.close();
    }

    final void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    /**
     * 处理结果集
     * @param resultSet
     * @param rowMapper
     * @return
     * @throws SQLException
     */
    final List<?> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int num = 1;
        while(resultSet.next()){
            result.add(rowMapper.mapRow(resultSet,num ++));
        }
        return result;
    }

    /**
     * 执行语句集
     * @param preareStatement
     * @param values
     * @return
     * @throws Exception
     */
    private ResultSet executeQuery(PreparedStatement preareStatement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            preareStatement.setObject(i,values[i]);
        }
        return preareStatement.executeQuery();
    }

    /**
     * 创建语句集
     * @param connection
     * @param sql
     * @return
     * @throws Exception
     */
    final PreparedStatement createPreareStatement(Connection connection,String sql) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    final Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }
}
