package com.zhangbin.cloud.controller.products;

import com.zhangbin.cloud.ProbjectCloudProductsApplicationTest;
import com.zhangbin.cloud.domain.Brand;
import com.zhangbin.cloud.repository.BrandMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BrandControllerTest extends ProbjectCloudProductsApplicationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void test(){
        System.out.println("hello");
        List<Brand> brands = brandMapper.selectList(null);
        System.out.println(brands);
        System.out.println("根据条件查询："+brandMapper.selectById(2l));
    }

    @Test
    public void test2(){
        String str1 ="通话";
        String str2 ="重地";
        System.out.println(String.format("str1:%d | str2:%d",str1.hashCode(),str2.hashCode()));
        System.out.println(String.format("str1:%s || str2:%s",str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

        System.out.println("Math:"+Math.round(-1.5));


        String str="i";
        String strr = new String("i");
        System.out.println("两个字符串equals："+str.equals(strr));
        System.out.println("两个字符串:"+(str==strr));


    }
}