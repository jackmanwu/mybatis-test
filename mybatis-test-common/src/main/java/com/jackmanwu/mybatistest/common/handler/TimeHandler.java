package com.jackmanwu.mybatistest.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by JackManWu on 2019/6/7.
 */
public class TimeHandler extends BaseTypeHandler<DateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTime(i, new Time(dateTime.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Time time = resultSet.getTime(s);
        if (time != null) {
            return new DateTime(time.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Time time = resultSet.getTime(i);
        if (time != null) {
            return new DateTime(time.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Time time = callableStatement.getTime(i);
        if (time != null) {
            return new DateTime(time.getTime());
        }
        return null;
    }
}
