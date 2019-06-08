package com.jackmanwu.mybatistest.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by JackManWu on 2019/6/7.
 */
public class DateHandler extends BaseTypeHandler<DateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setDate(i,new Date(dateTime.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = resultSet.getDate(s);
        if(date!=null){
            return new DateTime(date.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Date date = resultSet.getDate(i);
        if(date!=null){
            return new DateTime(date.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = callableStatement.getDate(i);
        if(date!=null){
            return new DateTime(date.getTime());
        }
        return null;
    }
}
