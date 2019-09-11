package org.dragonpulse.rnd.progress.service;

import ch.qos.logback.classic.Logger;
import org.dragonpulse.rnd.progress.repository.model.Person;
import org.dragonpulse.rnd.progress.repository.model.PersonSavingStatus;
import org.dragonpulse.rnd.progress.web.controller.PersonController;
import com.google.common.base.Preconditions;
import org.slf4j.LoggerFactory;

import static org.dragonpulse.rnd.progress.constants.Progress.getProgressPercentByMethodName;
import static org.dragonpulse.rnd.progress.constants.Progress.isMethodNameExists;

/**
 *
 */
public class SaveProgressUtility {

    ch.qos.logback.classic.Logger LOG = (Logger) LoggerFactory.getLogger(PersonController.class);

    StatusService statusService;

    public SaveProgressUtility(StatusService statusService) {
        this.statusService = statusService;
    }


    /**
     * Business logic for updating the progress base don the team discussion
     * @param objectArray
     */
    public void updateProgress(Object[] objectArray,String methodName){
        for(Object object: objectArray){
            if(object instanceof Person && isMethodNameExists(methodName)){
                statusService.saveStatus(buildProgressRequest((Person) object, getProgressPercentByMethodName(methodName)));
            }
        }
    }

    private PersonSavingStatus buildProgressRequest(Person person, String progressPercentage){
        Preconditions.checkNotNull(person.getRequestId(), "Request ID is null");
        Preconditions.checkNotNull(progressPercentage, "Progress Percentage should not be null");
        return new PersonSavingStatus(person.getRequestId(),progressPercentage);
    }
}
