package net.xdclass.shopmanager.config;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
@Data
@ConfigurationProperties("swagger")
@EnableOpenApi
public class SwaggerConfiguration {

    /**
     * 是否开启swagger，⽣产环境⼀般关闭，所以这⾥定义⼀个变量
     */
    private Boolean enable;
    /**
     * 项⽬应⽤名
     */
    private String applicationName;
    /**
     * 项⽬版本信息
     */
    private String applicationVersion;
    /**
     * 项⽬描述信息
     */
    private String applicationDescription;


    @Bean
    public Docket docket() {
        System.out.println(enable);
        return new Docket(DocumentationType.OAS_30)  //3.0版本
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制，线上关闭
                .enable(enable)
                //配置api⽂档元信息
                .apiInfo(apiInfo())
                // 选择哪些接⼝作为swagger的doc发布
                .select()
                //apis() 控制哪些接⼝暴露给swagger，
                //RequestHandlerSelectors.any() 所有都暴露
                //RequestHandlerSelectors.basePackage("net.xdclass.*") 指定包位置
                //withMethodAnnotation(ApiOperation.class)标记有这个注解 ApiOperation
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     *  新版访问路径（和旧版的不⼀样）
     *  http://localhost:8081/swagger-ui/index.html
     *  注意：如果访问不成功，记得看是否有拦截器拦截了相关资源，配置不拦截即可
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(applicationName)
                .description(applicationDescription)
                .contact(new Contact("pangzhihao", "xxx", "xxx@qq.com"))
                .version(applicationVersion)
                .build();
    }

}

