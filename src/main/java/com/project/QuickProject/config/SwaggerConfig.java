package com.project.QuickProject.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 @author Jimmey-Jiang
  * @desc SwaggerConfig Swagger2配置
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.QuickProject"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("接口文档")
				.description("接口文档 1.0 操作文档</br>" +
						"<b style='color:red'>" +
						"其他说明" +
						"</b>")
				.version("1.0")
				.contact(new Contact("yy", "https://github.com/Jimmey-Jiang", "jimmey-jiang@foxmail.com"))
				.build();
	}

}
