package cn.sepiggy;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanInfoTest {

    @Test
    public void testWithoutBeanutils() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("peida");

        try {
            BeanInfoUtil.getProperty(userInfo, "userName");
            BeanInfoUtil.setProperty(userInfo, "userName");

            BeanInfoUtil.getProperty(userInfo, "userName");

            BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");

            BeanInfoUtil.getPropertyByIntrospector(userInfo, "userName");

            BeanInfoUtil.setProperty(userInfo, "age");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWithBeanutils() {
        UserInfo userInfo = new UserInfo();

        try {
            BeanUtils.setProperty(userInfo, "userName", "peida");

            System.out.println("set userName:" + userInfo.getUserName());

            System.out.println("get userName:" + BeanUtils.getProperty(userInfo, "userName"));

            BeanUtils.setProperty(userInfo, "age", 18);
            System.out.println("set age:" + userInfo.getAge());

            System.out.println("get age:" + BeanUtils.getProperty(userInfo, "age"));

            System.out.println("get userName type:" + BeanUtils.getProperty(userInfo, "userName").getClass().getName());
            System.out.println("get age type:" + BeanUtils.getProperty(userInfo, "age").getClass().getName());

            PropertyUtils.setProperty(userInfo, "age", 8);
            System.out.println(PropertyUtils.getProperty(userInfo, "age"));

            System.out.println(PropertyUtils.getProperty(userInfo, "age").getClass().getName());

            PropertyUtils.setProperty(userInfo, "age", "8");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBirthday() {
        UserInfo userInfo = new UserInfo();

        try {
            BeanUtils.setProperty(userInfo, "birthday.time", "111111");
            Object obj = BeanUtils.getProperty(userInfo, "birthday.time");
            System.out.println(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
