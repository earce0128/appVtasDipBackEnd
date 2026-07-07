package mx.com.mxds.appvtas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"mx.com.mxds, qtx.externo"})
public class AppVentasDipBkSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppVentasDipBkSpringApplication.class, args);
	}

}
