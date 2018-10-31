package com.rabbitmq.rabbitmqtutorial.tutorial.tut3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut3
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 17:00
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public class Tut3Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiver1(String in) throws InterruptedException {
        receiver(in,1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiver2(String in) throws InterruptedException {
        receiver(in,2);
    }

    private void receiver(String in, int receiver) throws InterruptedException {

        StopWatch watch = new StopWatch();

        watch.start();

        System.out.println("instance" +  receiver + " [x] Received '" + in + "'");

        doWork(in);

        watch.stop();

        System.out.println("instance" + receiver + " [x] Done in" + watch.getTotalTimeSeconds() + "s");

    }

    private void doWork(String in) throws InterruptedException {

        for (char ch : in.toCharArray()) {
            if (ch == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
