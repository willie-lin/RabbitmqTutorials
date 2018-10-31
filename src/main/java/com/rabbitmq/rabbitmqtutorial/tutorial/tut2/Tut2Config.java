package com.rabbitmq.rabbitmqtutorial.tutorial.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut2
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 15:03
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */


@Profile({"tut2", "work-queues"})
@Configuration
public class Tut2Config {

    @Bean
    public Queue hello(){
        return new Queue("work-queues");
    }

    @Profile("receiver")
    private static class ReceiverConfig{

        @Bean
        public Tut2Receiver receiver1(){
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public Tut2Sender sender(){
        return new Tut2Sender();
    }
}
