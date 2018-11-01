package com.rabbitmq.rabbitmqtutorial.tutorial.tut4;

import jdk.nashorn.internal.ir.debug.PrintVisitor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut4
 * @auther: YuAn
 * @Date: 2018/11/1
 * @Time: 15:33
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    private int index;

    private int count;

    private final String[] keys = {"orange", "black", "green" };

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == 3) {
            this.index = 0;
        }

        String key = keys[this.index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++this.count));
        String message = builder.toString();
        template.convertAndSend(direct.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
