package com.jackmanwu.mybatistest.common;

import com.jackmanwu.mybatistest.common.handler.DateHandler;
import com.jackmanwu.mybatistest.common.handler.TimeHandler;
import com.jackmanwu.mybatistest.common.handler.TimestampHandler;
import org.joda.time.DateTime;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;

import java.sql.Types;

/**
 * Created by JackManWu on 2019/6/6.
 */
public class IntrospectedColumnImpl extends IntrospectedColumn {
    @Override
    public void setFullyQualifiedJavaType(FullyQualifiedJavaType fullyQualifiedJavaType) {
        super.setFullyQualifiedJavaType(fullyQualifiedJavaType);
        if (DateTime.class.getName().equals(fullyQualifiedJavaType.getFullyQualifiedName())) {
            switch (this.getJdbcType()) {
                case Types.DATE:
                    this.typeHandler = DateHandler.class.getName();
                    break;
                case Types.TIME:
                    this.typeHandler = TimeHandler.class.getName();
                    break;
                case Types.TIMESTAMP:
                    this.typeHandler = TimestampHandler.class.getName();
                    break;
                default:
                    break;
            }
        }
    }
}
