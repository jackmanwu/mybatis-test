package com.jackmanwu.mybatistest.common;

import org.joda.time.DateTime;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * Created by JackManWu on 2019/6/6.
 */
public class JavaTypeResolverImpl extends JavaTypeResolverDefaultImpl {
    public JavaTypeResolverImpl() {
        super();
        this.typeMap.put(Types.DATE, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(DateTime.class.getName())));
        this.typeMap.put(Types.TIME, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(DateTime.class.getName())));
        this.typeMap.put(Types.TIMESTAMP, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(DateTime.class.getName())));
    }
}
