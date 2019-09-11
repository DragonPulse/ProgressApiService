package org.dragonpulse.rnd.progress.aspect.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * The type Log time aspect.
 */
@Aspect
@Component
public class LogTimeAspect {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    /**
     * Log execution time object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("@annotation(org.dragonpulse.rnd.progress.aspect.logger.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Entering into " + joinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }
        long executionTime = System.currentTimeMillis() - start;
        log.info("Exiting from " + joinPoint.getSignature());
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}