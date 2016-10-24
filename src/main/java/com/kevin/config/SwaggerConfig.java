package com.kevin.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger
public class SwaggerConfig {


    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * 自定义实现 customImplementation
     * @return
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?");
    }

    /**
     * title;
     description;
     terms of serviceUrl;
     contact email;
     license type;
     license url;
     * @return
     */
    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "标题 title",
                "描述 description",
                "termsOfServiceUrl",
                "联系邮箱 contact email",
                "许可证的类型 license type",
                "许可证的链接 license url"
        );
        return apiInfo;
    }
}
