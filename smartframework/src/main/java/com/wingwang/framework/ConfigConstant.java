package com.wingwang.framework;

/**
 * 提供相关配置项常量
 */
public interface ConfigConstant {
    String CONFIG_FILE = "smart.properties";

    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    String JDBC_URL = "smart.framework.jdbc.url";
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    // 项目基础包名
    String APP_BASE_PACKAGE = "smart.framework.app.base_package";
    // JSP基础路径
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    // 静态资源的基础路径，如JS，CSS，图片等
    String APP_ASSERT_PATH = "smart.framework.app.assert_path";
}
