package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AspectV1 {

    //hello.aop.order 패키지와 하위 패키지
    @Around("execution(* hello.aop.order..*(..))") // @Around 는 pointcut
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{ // doLog 는 Advice
        log.info("[log] {}", joinPoint.getSignature()); // join point 시그니처
        return joinPoint.proceed() ;
    }
}
