package com.zhangbin.cloud.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@Configuration
@ConditionalOnProperty(prefix = "api", name = "docs", havingValue = "enable", matchIfMissing = false)
@Import({ Swagger2DocumentationConfiguration.class })
public class Swagger2Conf {
	@Bean
	public Docket createRestApi() {
		
		  return new Docket(DocumentationType.SWAGGER_2)
		  /*.globalOperationParameters(Lists.newArrayList(new ParameterBuilder().name("")
		  .modelRef(new ModelRef("string")).parameterType("header").build()))*/
				  .select()
		  
				  .apis(RequestHandlerSelectors.basePackage("com.zhangbin.cloud"))// controller包的路径 
				  .paths(PathSelectors.any()).build();
		 

		/*return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zhangbin.cloud"))// controller包的路径
				.paths(PathSelectors.any()).build();*/
	}

	/*private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("某某项目相关api文档").description("简单优雅的restful风格的API文档")
				.termsOfServiceUrl("http://www.baidu.com").version("1.0").build();
	}*/

}
