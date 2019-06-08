package com.jackmanwu.mybatistest.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by JackManWu on 2019/6/7.
 */
public class TimestampHandler extends BaseTypeHandler<DateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(i, new Timestamp(dateTime.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(s);
        if (timestamp != null) {
            return new DateTime(timestamp.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(i);
        if (timestamp != null) {
            return new DateTime(timestamp.getTime());
        }
        return null;
    }

    @Override
    public DateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        if (timestamp != null) {
            return new DateTime(timestamp.getTime());
        }
        return null;
    }
}
