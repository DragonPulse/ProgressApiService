package org.dragonpulse.rnd.progress.repository;

import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultStatusRepositoryImpl implements CustomStatusRepository {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public void saveStatus(PersonSavingStatus personSavingStatus) {
        statusRepository.save(personSavingStatus);
    }

    @Override
    public PersonSavingStatus findByRequestId(String requestId) {
        return statusRepository.findById(requestId).get();
    }

    @Override
    public void deleteStatusByRequestId(String requestId) {
        statusRepository.deleteById(requestId);
    }

    @Override
    public List<PersonSavingStatus> getAll() {
        return (List<PersonSavingStatus>) statusRepository.findAll();
    }

    @Override
    public PersonSavingStatus getStatusByRequestId(String requestId) {
        return statusRepository.findById(requestId).get();
    }
}
