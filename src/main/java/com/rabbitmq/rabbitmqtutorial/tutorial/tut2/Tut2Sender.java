package com.rabbitmq.rabbitmqtutorial.tutorial.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import sun.awt.geom.AreaOp;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut2
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 15:11
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */


public class Tut2Sender {


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    int dots = 0;
    int count = 0;


    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        StringBuilder builder = new StringBuilder("hello");
        if (dots++ ==3){
            dots = 1;
        }

        for (int i = 0; i < dots ; i++) {
            builder.append(',');
        }

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] sent '" + message + "'");
    }
}
