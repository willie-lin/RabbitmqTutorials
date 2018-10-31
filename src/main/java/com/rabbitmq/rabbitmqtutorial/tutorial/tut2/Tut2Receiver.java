package com.rabbitmq.rabbitmqtutorial.tutorial.tut2;

import jdk.nashorn.internal.runtime.regexp.joni.WarnCallback;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;
import sun.text.resources.cldr.chr.FormatData_chr;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut2
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 15:09
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */

@RabbitListener(queues = "work-queues")
public class Tut2Receiver {

    private final int instance;

    public Tut2Receiver(int i) {
        this.instance = i;
    }


    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance" + this.instance + " [x] Received '" + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance" + this.instance + " [x] Done in " + watch.getTotalTimeSeconds() + "s");
        
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch: in.toCharArray()){
            if (ch == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
