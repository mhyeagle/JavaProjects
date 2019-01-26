package springTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MultiThreadProcessService {
    public static final Logger logger = LoggerFactory.getLogger(MultiThreadProcessService.class);

    public void process() {
        logger.debug("thread: " + Thread.currentThread() + "...start");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            logger.debug(e.toString());
        }
        logger.debug("thread:" + Thread.currentThread() + "...end");
    }
}
