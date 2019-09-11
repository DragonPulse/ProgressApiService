package org.dragonpulse.rnd.progress.service;

import ch.qos.logback.classic.Logger;
import org.dragonpulse.rnd.progress.aspect.monitor.MonitorSaveProgress;
import org.dragonpulse.rnd.progress.repository.model.Person;
import org.dragonpulse.rnd.progress.web.controller.PersonController;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

public class DefaultPersonServiceImpl implements PersonService {

    Logger LOG = (Logger) LoggerFactory.getLogger(PersonController.class);

    @Override
    @MonitorSaveProgress
    public synchronized void method1(Person person) throws InterruptedException {
         // threadOne acquire the monitor for "this" and continue.

            try {

                LOG.info("Method #1 Execution started --- another chunk of work to do");

                this.wait(10000); // The threadOne already have the monitor for "this",
                //  just release the monitor and go and wait threadOne.

                LOG.info("Method  #1 Execution Ends and continue execution...");

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
    }

    @Override
    @MonitorSaveProgress
    public synchronized void method2(Person person) throws InterruptedException {
        try {

            LOG.info("Method #2 Execution started --- another chunk of work to do");

            this.wait(10000); // The threadOne already have the monitor for "this",
            //  just release the monitor and go and wait threadOne.

            LOG.info("Method  #2 Execution Ends and continue execution...");

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    @Override
    @MonitorSaveProgress
    public synchronized void method3(Person person) throws InterruptedException {
        try {

            LOG.info("Method #3 Execution started --- another chunk of work to do");

            this.wait(10000); // The threadOne already have the monitor for "this",
            //  just release the monitor and go and wait threadOne.

            LOG.info("Method  #3 Execution Ends and continue execution...");

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    @Override
    @MonitorSaveProgress
    public synchronized void method4(Person person) throws InterruptedException {
        try {

            LOG.info("Method #4 Execution started --- another chunk of work to do");

            this.wait(10000); // The threadOne already have the monitor for "this",
            //  just release the monitor and go and wait threadOne.

            LOG.info("Method  #4 Execution Ends and continue execution...");

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    @Override
    @MonitorSaveProgress
    public DeferredResult<Person> initiateCreation(Person person) throws Exception {
        DeferredResult<Person> responseResult = new DeferredResult<>();
        person.setRequestId(UUID.randomUUID().toString());
        ForkJoinPool.commonPool().submit(() -> {
            LOG.info("Processing in separate thread");
            try {
                method1(person);
                method2(person);
                method3(person);
                method4(person);
                LOG.info("Processing Done");
            } catch (InterruptedException e) {
            }
        });
        responseResult.setResult(person);
        return responseResult;
    }
}
