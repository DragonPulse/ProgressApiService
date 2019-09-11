package org.dragonpulse.rnd.progress.service;

import org.dragonpulse.rnd.progress.repository.model.Person;
import org.springframework.web.context.request.async.DeferredResult;

public interface PersonService {

    void method1(Person person) throws InterruptedException;
    void method2(Person person) throws InterruptedException;
    void method3(Person person) throws InterruptedException;
    void method4(Person person) throws InterruptedException;

    DeferredResult<Person> initiateCreation(Person person) throws Exception;
}
