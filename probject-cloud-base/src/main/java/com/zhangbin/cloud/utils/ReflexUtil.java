package com.zhangbin.cloud.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 反射工具类
 *
 * @author jun
 */
public class ReflexUtil {

    
    /**
     * 获取对象的所有Field，包含所有超类
     * @param clazz
     * @return
     */
    public static List<Field> allField(Class<?> clazz){
    	Set<Field> rsList = new LinkedHashSet<>();
    	Field[] fields = clazz.getDeclaredFields();
    	if(fields!=null&&fields.length>0){
    		for(Field f:fields){
    			rsList.add(f);
    		}
    	}
    	superField(clazz,rsList);
    	
    	List<Field> rs = new LinkedList<>();
    	rs.addAll(rsList);
    	return rs;
    }
    
    private static void superField(Class<?> clazz,Set<Field> rsList){
    	Set<Field> tempSet = new LinkedHashSet<>();
    	Class<?> superClass = clazz.getSuperclass();
    	Field[] superFields = superClass.getDeclaredFields();
    	if(superFields!=null&&superFields.length>0){
    		for(Field f:superFields){
    			tempSet.add(f);
    		}
    		tempSet.addAll(rsList);
    		rsList.removeAll(rsList);
    		rsList.addAll(tempSet);
    		superField(superClass,rsList);
    	}
    }
    
    /**
     * 将model对象属性的值赋给vo对象同属性名的属性
     * @param model 接收值的对象
     * @param vo 值的对象
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T,B> T modelFromVo(T model, B vo) throws IllegalArgumentException, IllegalAccessException {
        List<Field> voFileds = allField(vo.getClass());
        List<Field> modelFileds = allField(model.getClass());

        BeanUtil.conpyField((B) vo, (T) model, voFileds, modelFileds);

        return model;
    }

}
