package org.dragonpulse.rnd.progress.service.config;


import org.dragonpulse.rnd.progress.repository.CustomStatusRepository;
import org.dragonpulse.rnd.progress.repository.config.RepositoryConfig;
import org.dragonpulse.rnd.progress.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class})
public class ServiceConfig {

    @Bean(name = "defaultStatusService")
    public StatusService defaultStatusService(@Qualifier("defaultStatusRepository") CustomStatusRepository defaultStatusRepository){
        return new DefaultStatusServiceImpl(defaultStatusRepository);
    }

    @Bean(name="defaultPersonService")
    public PersonService defaultPersonServiceImpl(){
        return new DefaultPersonServiceImpl();
    }

    @Bean(name="saveProgressUtility")
    public SaveProgressUtility defaultSaveProgressUtility(@Qualifier("defaultStatusService") StatusService defaultStatusService){
        return new SaveProgressUtility(defaultStatusService);
    }
}
