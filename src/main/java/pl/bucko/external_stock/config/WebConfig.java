package pl.bucko.external_stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/css/**",
                "/img/**",
                "/js/**",
                "/js/core/**",
                "/js/plugins/**",
                "/fonts/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/fonts/",
                        "classpath:/css/",
                        "classpath:/img/",
                        "classpath:/js/",
                        "classpath:/js/core/",
                        "classpath:/js/plugins/"
                        );

        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/js/core/**").addResourceLocations("classpath:/static/js/core/");
        registry.addResourceHandler("/js/plugins/**").addResourceLocations("classpath:/static/js/plugins/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/static/img/");

    }

}
