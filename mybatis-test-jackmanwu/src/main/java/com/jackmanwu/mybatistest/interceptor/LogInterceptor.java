package com.jackmanwu.mybatistest.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by JackManWu on 2019/6/8.
 */
@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class LogInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("方法：{}", invocation.getMethod());
        Object target = invocation.getTarget();
        log.info("被拦截到的对象：{}", target);
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        log.info("方法全路径：{}", statement.getId());
        Object param = invocation.getArgs()[1];
        log.info("参数对象：{}", param);
        Class paramClazz = param.getClass();

        Field[] fields = paramClazz.getDeclaredFields();
        for (Field field : fields) {
           log.info("属性：{}" + field.getName());
           if("id".equals(field.getName())){
               String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
               log.info("方法名称：{}", getMethodName);
               Method method = paramClazz.getMethod(getMethodName);
               Object value = method.invoke(param);
               log.info("参数值：{}",value);
           }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        log.info("LogInterceptor 要包装的对象：{}", o);
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("插件配置信息：{}", properties);
    }
}
