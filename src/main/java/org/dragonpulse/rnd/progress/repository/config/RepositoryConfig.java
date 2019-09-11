package org.dragonpulse.rnd.progress.repository.config;

import org.dragonpulse.rnd.progress.repository.CustomStatusRepository;
import org.dragonpulse.rnd.progress.repository.DefaultStatusRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean(name = "defaultStatusRepository")
    CustomStatusRepository defaultStatusRepo(){
        return new DefaultStatusRepositoryImpl();
    }

}
