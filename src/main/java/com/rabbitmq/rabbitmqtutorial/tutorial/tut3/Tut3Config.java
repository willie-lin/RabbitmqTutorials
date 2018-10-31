package com.rabbitmq.rabbitmqtutorial.tutorial.tut3;

import com.rabbitmq.rabbitmqtutorial.tutorial.tut1.Tut1Sender;
import com.rabbitmq.rabbitmqtutorial.tutorial.tut2.Tut2Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.awt.event.FocusAdapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut3
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 16:39
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */


@Profile({"tut3", "pub-sub"})
@Configuration
public class Tut3Config {

    /**
     * 定义一个 Exchange
     * @return
     */

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("tut.fanout");
    }

    /**
     * 消费者一端的配置：queues、bindings
     */

    @Profile("receiver")
    private static class ReceiverConfig{

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1){

            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2){

            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public Tut3Receiver receiver(){
            return new Tut3Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut3Sender sender(){
        return new Tut3Sender();
    }

}
