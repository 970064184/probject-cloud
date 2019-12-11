package com.zhangbin.cloud.controller.products;

import com.zhangbin.cloud.domain.Brand;
import com.zhangbin.cloud.repository.BrandMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandMapper brandMapper;

   @GetMapping("/test")
   public String test(){
       return "test";
   }

    @GetMapping("/brand")
    public  List<Brand> brand(){
        List<Brand> brands = brandMapper.selectList(null);
        return brands;
    }

    public static void main(String[] args) {
        /*System.out.println(RandomStringUtils.randomNumeric(3));
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        System.out.println(RandomStringUtils.randomAlphanumeric(10));
        System.out.println(RandomStringUtils.randomAscii(10));
        System.out.println(RandomStringUtils.random(10,"ABCDE1234567890"));*/
    }

}
