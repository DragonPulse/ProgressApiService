package org.dragonpulse.rnd.progress.web.controller;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dragonpulse.rnd.progress.repository.model.Person;
import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.dragonpulse.rnd.progress.service.StatusService;
import org.dragonpulse.rnd.progress.service.PersonService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/persons")
@Api(tags = {"Person Controller"}, value = "person controlelr", description = "person crud API")
public class PersonController {

    ch.qos.logback.classic.Logger LOG = (Logger) LoggerFactory.getLogger(PersonController.class);

    @Resource
    @Qualifier("defaultPersonService")
    PersonService defaultPersonService;

    @Resource
    @Qualifier("defaultStatusService")
    StatusService defaultStatusService;


    @PostMapping("/")
    @ApiOperation(value = "Save PErson Object", notes = "Save PErson Object")
    public DeferredResult<ResponseEntity<?>> createCostTrackingField()throws Exception{
        DeferredResult<ResponseEntity<?>> responseResult = new DeferredResult<>();
        Person person = new Person();
        person.setRequestId(UUID.randomUUID().toString());
        defaultStatusService.saveStatus(new PersonSavingStatus(person.getRequestId(),"0"));
        ForkJoinPool.commonPool().submit(() -> {
            LOG.info("Processing in separate thread");
            try {
                defaultPersonService.method1(person);
                defaultPersonService.method2(person);
                defaultPersonService.method3(person);
                defaultPersonService.method4(person);
                LOG.info("Processing Done");
            } catch (InterruptedException e) {
            }
        });
        responseResult.setResult(ResponseEntity.ok(person));
        return responseResult;
    }

}
