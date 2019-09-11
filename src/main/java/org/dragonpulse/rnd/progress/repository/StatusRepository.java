package org.dragonpulse.rnd.progress.repository;

import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.springframework.data.hazelcast.repository.HazelcastRepository;


public interface StatusRepository extends HazelcastRepository<PersonSavingStatus, String> {

}

