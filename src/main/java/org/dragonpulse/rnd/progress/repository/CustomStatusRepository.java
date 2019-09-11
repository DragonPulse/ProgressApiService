package org.dragonpulse.rnd.progress.repository;

import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;

import java.util.List;

public interface CustomStatusRepository {

    void saveStatus(PersonSavingStatus personSavingStatus);

    PersonSavingStatus findByRequestId(String requestId);

    void deleteStatusByRequestId(String requestId);

    List<PersonSavingStatus> getAll();

    PersonSavingStatus getStatusByRequestId(String requestId);


}
