package springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MultiTask implements Runnable {
    @Autowired
    private MultiThreadProcessService multiThreadProcessService;

    public void setMultiThreadProcessService(MultiThreadProcessService multiThreadProcessService) {
        this.multiThreadProcessService = multiThreadProcessService;
    }

    @Override
    public void run() {
        //System.out.println("thread");
        multiThreadProcessService.process();
    }
}
