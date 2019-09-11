package org.dragonpulse.rnd.progress.web.controller;

import org.dragonpulse.rnd.progress.aspect.logger.LogExecutionTime;
import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.dragonpulse.rnd.progress.repository.StatusRepository;
import org.dragonpulse.rnd.progress.service.StatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.dragonpulse.rnd.progress.web.utils.AppUtils.generateUUID;

@RestController
@Api(tags = {"Person Saving Status"}, value = "person saving status", description = "Person Saving Status API")
@RequestMapping("/status")
public class StatusController {

    private final StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Resource
    @Qualifier("defaultStatusService")
    StatusService defaultStatusService;


    @LogExecutionTime
    @ResponseBody
    @GetMapping("/")
    @ApiOperation(value = "Get list of all saving Status", notes = "Returns list of person saving Status in Cache")
    public List<PersonSavingStatus> getAllRequestIds(){
        return defaultStatusService.getAll();
    }

    @LogExecutionTime
    @PostMapping("/")
    @ApiOperation(value = "Save the NEw Person Status ", notes = "Save the person saving status")
    public void  saveStatus(@RequestBody PersonSavingStatus personSavingStatus){
        if(StringUtils.isEmpty(personSavingStatus.getRequestId())){
            personSavingStatus.setRequestId(generateUUID());
        }
        defaultStatusService.saveStatus(personSavingStatus);
    }


    @LogExecutionTime
    @GetMapping("/{requestId}")
    @ApiOperation(value = "Get Person Saving Status by RequestID", notes = "Returns  Person Saving Status in Cache by RequestId")
    public PersonSavingStatus getStatusByRequestId(@PathVariable("requestId") String requestId){
    return defaultStatusService.getStatusByRequestId(requestId);
    }

    @LogExecutionTime
    @DeleteMapping("/{requestId}")
    @ApiOperation(value = "Delete Person Saving Status by RequestID", notes = "Delete  Person Saving Status in Cache by RequestId")
    public void deleteStatusByRequestID(@PathVariable("requestId") String requestId){
         defaultStatusService.deleteStatusByRequestId(requestId);
    }
}

