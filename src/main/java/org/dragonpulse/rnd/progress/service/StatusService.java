package org.dragonpulse.rnd.progress.service;

import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;

import java.util.List;

public interface StatusService {

    void saveStatus(PersonSavingStatus personSavingStatus);

    List<PersonSavingStatus> getAll();

    PersonSavingStatus getStatusByRequestId(String requestId);

    void deleteStatusByRequestId(String requestId);
}
