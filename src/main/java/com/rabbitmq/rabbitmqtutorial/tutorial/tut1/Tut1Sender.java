package com.rabbitmq.rabbitmqtutorial.tutorial.tut1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut1
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 9:38
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public class Tut1Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){

        String message = "Hello World!" + new Date();
        amqpTemplate.convertAndSend(queue.getName(), message);
        System.out.print(" [x] Sent '" + message + "'");

    }
}
