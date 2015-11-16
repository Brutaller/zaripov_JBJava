package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class CatchingExceptions {

    private static Logger log = Logger.getLogger(TimeAnalyzer.class.getName());

    public Object executionMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception: ");
            sb.append(joinPoint.getTarget());
            sb.append(" catched for arguments ");
            for (Object argument : joinPoint.getArgs()) {
                sb.append(argument.toString());
                sb.append(" ");
            }
            log.info(new String(sb));
        }
        return result;
    }
}
