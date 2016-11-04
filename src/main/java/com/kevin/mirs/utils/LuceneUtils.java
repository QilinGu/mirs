package com.kevin.mirs.utils;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;

import javax.annotation.Resource;

public class LuceneUtils {

    @Resource
    Document document;

    //将JavaBean转成Document对象
    public static Document javabean2document(Object obj) throws Exception{
        //创建Document对象
        Document document = new Document();
        //获取obj引用的对象字节码
        Class clazz = obj.getClass();
        //通过对象字节码获取私有的属性
        java.lang.reflect.Field[] reflectFields = clazz.getDeclaredFields();
        //迭代
        for(java.lang.reflect.Field reflectField : reflectFields){
            //反射
            reflectField.setAccessible(true);
            //获取字段名
            String name = reflectField.getName();
            //获取字段值
            String value = reflectField.get(obj).toString();
            //加入到Document对象中去，这时javabean的属性与document对象的属性相同
            document.add(new Field(name, value, TextField.TYPE_STORED));
        }
        //返回document对象
        return document;
    }

    //将Document对象转换成JavaBean对象
    public static <T> T document2javabean(Document document,Class<T> clazz) throws Exception{
        T obj = clazz.newInstance();
        java.lang.reflect.Field[] reflectFields = clazz.getDeclaredFields();
        for(java.lang.reflect.Field reflectField : reflectFields){
            reflectField.setAccessible(true);
            String name = reflectField.getName();
            String value = document.get(name);
            BeanUtils.setProperty(obj, name, value);
        }
        return obj;
    }

}
