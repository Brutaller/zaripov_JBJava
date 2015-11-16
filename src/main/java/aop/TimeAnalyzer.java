package aop;

import org.aspectj.lang.annotation.Aspect;

import java.util.Date;
import java.util.logging.Logger;

@Aspect
public class TimeAnalyzer {

    private long start;
    private long end;

    private static Logger log = Logger.getLogger(TimeAnalyzer.class.getName());

    public void before() throws Throwable {
        start = System.currentTimeMillis();
    }

    public void after() throws Throwable {
        end = System.currentTimeMillis();
        log.info("start: "+(new Date(start)));
        log.info("end: "+(new Date(end)));
        log.info("duration in ms: "+(end-start));
    }

}
