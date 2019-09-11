package org.dragonpulse.rnd.progress.service;


import ch.qos.logback.classic.Logger;
import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.dragonpulse.rnd.progress.repository.CustomStatusRepository;
import org.dragonpulse.rnd.progress.web.controller.PersonController;
import org.slf4j.LoggerFactory;

import java.util.List;


public class DefaultStatusServiceImpl implements StatusService {

    ch.qos.logback.classic.Logger LOG = (Logger) LoggerFactory.getLogger(PersonController.class);

    CustomStatusRepository defaultCTStatusRepository;

    public DefaultStatusServiceImpl(CustomStatusRepository defaultCTStatusRepository) {
        super();
        this.defaultCTStatusRepository = defaultCTStatusRepository;
    }


    @Override
    public void saveStatus(PersonSavingStatus personSavingStatus) {
        defaultCTStatusRepository.saveStatus(personSavingStatus);
    }

    @Override
    public List<PersonSavingStatus> getAll() {
        return defaultCTStatusRepository.getAll();
    }

    @Override
    public PersonSavingStatus getStatusByRequestId(String requestId) {
        return defaultCTStatusRepository.getStatusByRequestId(requestId);
    }

    @Override
    public void deleteStatusByRequestId(String requestId) {
        defaultCTStatusRepository.deleteStatusByRequestId(requestId);
    }
}
