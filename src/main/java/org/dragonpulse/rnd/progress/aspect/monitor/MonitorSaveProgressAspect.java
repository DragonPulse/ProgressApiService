package org.dragonpulse.rnd.progress.aspect.monitor;

import ch.qos.logback.classic.Logger;
import org.dragonpulse.rnd.progress.service.SaveProgressUtility;
import org.dragonpulse.rnd.progress.web.controller.PersonController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Aspect
@Component
public class MonitorSaveProgressAspect {

    ch.qos.logback.classic.Logger LOG = (Logger) LoggerFactory.getLogger(PersonController.class);


    @Resource
    @Qualifier("saveProgressUtility")
    SaveProgressUtility saveProgressUtility;

    /**
     * Log execution time object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("@annotation(org.dragonpulse.rnd.progress.aspect.monitor.MonitorSaveProgress)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("Entering into " + joinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Object[] signatureArgs = joinPoint.getArgs();
        saveProgressUtility.updateProgress(signatureArgs, ((MethodSignature) joinPoint.getSignature()).getMethod().getName());
        long executionTime = System.currentTimeMillis() - start;
        LOG.info("Exiting from " + joinPoint.getSignature());
        LOG.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        LOG.info("************************************");
        LOG.info("");
        return proceed;
    }
}