package com.wingwang.chapter2.service;

import com.wingwang.chapter2.model.Customer;
import com.wingwang.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 提供客户数据服务
 *
 * 标准的MVC架构中是没有服务层的, 我们将该层作为衔接控制器层与数据库层之间的桥梁, 可以使用接口和实现类来表达,
 * 在简单情况下, 无需使用接口, 直接使用类就可以了.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static{
        Properties conf = PropsUtil.loadProps("config.properties");

        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     *  1. 在CustomerService类中读取config。properties文件，这是不合理的，毕竟将来还有很多其他的service类需要做同样的事情，
     *  我们最好能将这些公共性的代码提取出来
     *  2.执行一条select语句需要编写一大堆代码，而且还必须使用try...catch...finally结构，开发效率明显不高
     */
    @Deprecated
    public List<Customer> getCustomerListOldFun(/*String keyword*/){

        Connection conn = null;

        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM customer";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
             LOGGER.error("execute sql failure", e);
        } finally {
            if (null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("close connection failure", e);
                }
            }
        }
        return null;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        // TODO
        return null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap){
        // TODO
        boolean retVal = false;

        return  retVal;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        // TODO
        boolean retVal = false;

        return retVal;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        // TODO
        boolean retVal = false;

        return retVal;
    }
}
