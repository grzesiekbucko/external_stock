package pl.bucko.external_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.bucko.external_stock.service.CacheService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
public class ExternalStockApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExternalStockApplication.class);
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ExternalStockApplication.class, args);

	}
}
