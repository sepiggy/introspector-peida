package cn.sepiggy;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {

    public static void setProperty(UserInfo userInfo, String userName) throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(userName, UserInfo.class);
        Method methodSetUserName = propertyDescriptor.getWriteMethod();
        methodSetUserName.invoke(userInfo, "wong");
        System.out.println("set userName:" + userInfo.getUserName());
    }

    public static void getProperty(UserInfo userInfo, String userName) throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(userName, UserInfo.class);
        Method methodGetUserName = propertyDescriptor.getReadMethod();
        Object objUserName = methodGetUserName.invoke(userInfo);
        System.out.println("get userName:" + objUserName.toString());
    }

    public static void setPropertyByIntrospector(UserInfo userInfo, String userName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null && propertyDescriptors.length > 0) {
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(userName)) {
                    Method methodSetUserName = propertyDescriptor.getWriteMethod();
                    methodSetUserName.invoke(userInfo, "alan");
                    System.out.println("set userName:" + userInfo.getUserName());
                    break;
                }
            }
        }
    }

    public static void getPropertyByIntrospector(UserInfo userInfo, String userName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null && propertyDescriptors.length > 0) {
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(userName)) {
                    Method methodGetUserName = propertyDescriptor.getReadMethod();
                    Object objUserName = methodGetUserName.invoke(userInfo);
                    System.out.println("get userName:" + objUserName.toString());
                    break;
                }
            }
        }
    }
}
