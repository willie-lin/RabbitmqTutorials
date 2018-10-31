package com.rabbitmq.rabbitmqtutorial.tutorial.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Created with IntelliJ IDEA.
 *
 * @author YuAn
 * @Package: com.rabbitmq.rabbitmqtutorial.tutorial.tut1
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 9:49
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */


@Profile({"tut1", "hello-world"})
@Configuration
public class Tut1Config {

    /**
     *  定义一个 queue，名字为 hello-world
     * @return
     */

    @Bean
    public Queue queue() {
//    public Queue hello() {
//        return new Queue("hello");
        return new Queue("hello-world");
    }

    @Profile("receiver")
    @Bean
    public Tut1Receiver receive(){
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender() {
        return new Tut1Sender();
    }

}
