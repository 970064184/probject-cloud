package com.zhangbin.cloud.controller.products;

import com.zhangbin.cloud.ProbjectCloudProductsApplicationTest;
import org.junit.Test;

public class BrandControllerTest extends ProbjectCloudProductsApplicationTest {

//    @Autowired
//    private RestTemplate restTemplate;


/*    @Autowired
    private TbBrandMapper brandMapper;

    @Test
    public void test(){
        System.out.println("hello");
        List<TbBrand> brands = brandMapper.selectList(null);
        System.out.println("所有记录："+brands);
        System.out.println("根据条件查询："+brandMapper.selectById(2l));

        PageBean pageBean = new PageBean();
        IPage<TbBrand> page = new Page<>(pageBean.getPage(),pageBean.getLimit());

        Map<SqlKeyword,Map<String,Object>> map = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("brand_ch_name","test");
        map.put(SqlKeyword.AND,param);
        QueryWrapper<TbBrand> queryWrapper = QueryWrapperUtils.getQueryWrapper(map);

//        queryWrapper.likeRight("brand_ch_name","test").orderByDesc("created_time");
        IPage<TbBrand> tbBrandIPage = brandMapper.selectPage(page, queryWrapper);
        System.out.println("分页："+tbBrandIPage);
        System.out.println("分页查询："+tbBrandIPage.getRecords());
    }*/
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

    @Test
    public void test3(){
        int i = 2 << 3;
        String s = "3232";
        System.out.println(s.length());
        int[] arr = {1,12};
        System.out.println(arr.length);
        System.out.println(i);

        System.out.println("当前路径："+System.getProperty("user.dir"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());

    }

    public static void main(String[] args) {
        //当前路径：C:\probject-cloud
//        当前路径：C:\probject-cloud\probject-cloud\probject-cloud-products

        System.out.println("当前路径："+System.getProperty("user.dir"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());

    }


}
