package org.dragonpulse.rnd.progress;

import org.dragonpulse.rnd.progress.config.AppConfig;
import org.dragonpulse.rnd.progress.service.config.ServiceConfig;
import org.dragonpulse.rnd.progress.web.documentation.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AppConfig.class, ServiceConfig.class, SwaggerConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
