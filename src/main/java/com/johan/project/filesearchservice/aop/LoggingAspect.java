package com.johan.project.filesearchservice.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

  @Before("execution(* com.johan.project.filesearchservice..*.*(..)) && !@target(com.johan.project.filesearchservice.aop.NoLogging)")
  public void logBefore(final JoinPoint joinPoint) {
    final StringJoiner joiner = new StringJoiner(",");
    final Object[] signatureArgs = joinPoint.getArgs();
    if(signatureArgs == null) {
      return;
    }
    for(final Object signatureArg : signatureArgs) {
      if(signatureArg != null) {
        joiner.add(signatureArg.toString());
      }
    }
    log.info("Executing method [{}] with args=[{}]", joinPoint.getSignature().getName(), joiner);
  }
}
