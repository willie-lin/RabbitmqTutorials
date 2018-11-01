package com.rabbitmq.rabbitmqtutorial.tutorial.tut4;

import javafx.scene.paint.Stop;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;
import sun.text.resources.cldr.chr.FormatData_chr;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut4
 * @auther: YuAn
 * @Date: 2018/11/1
 * @Time: 15:31
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */

public class Tut4Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) throws InterruptedException {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) throws InterruptedException {
        receive(in, 2);
    }


    public void receive(String in, int receiver) throws InterruptedException {

        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] Received'" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance" + receiver + " [x] Done in" + watch.getTotalTimeSeconds() + " s");
    }

    private void doWork(String in) throws InterruptedException {

        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }


}
