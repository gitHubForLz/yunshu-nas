package top.itning.yunshu.yunshunas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.itning.yunshu.yunshunas.config.properties.NasAuthProperties;


@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private NasAuthProperties nasProperties;

    //    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //registry.addViewController("/").setViewName("index");
//    }
//如果资源下有很多index页面,localhost:8080跳转可能会跳船到错误index页面
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
                registry.addRedirectViewController("/","/home");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/home.html").setViewName("home");
            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源  springboot已经做好了映射不需要再配置
                if (!nasProperties.isEnable())
                    return;
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns(
                                "/",
                                "/login",
                                "/user/login",
                                "/index.html",
                                "/**/*.js",
                                "/**/*.css",
                                "/**/*.woff",
                                "/**/*.ttf",
                                "/**/*.jpg"
                        );
            }
        };
        return adapter;
    }

}
