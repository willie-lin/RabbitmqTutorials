package com.rabbitmq.rabbitmqtutorial.tutorial.tut1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut1
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 9:47
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */

//@RabbitListener(queues = "hello")
@RabbitListener(queues = "hello-world")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in){
        System.out.println(" [x] Received '" + in + "'");
    }


}
