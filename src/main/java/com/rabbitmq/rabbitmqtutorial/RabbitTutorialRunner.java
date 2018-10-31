package com.rabbitmq.rabbitmqtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import sun.applet.Main;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package: com.rabbitmq.rabbitmqtutorial
 * @auther: YuAn
 * @Date: 2018/10/31
 * @Time: 10:30
 * @Project_name: RabbitmqTutorial
 * To change this template use File | Settings | File Templates.
 * @Description:
 */
public class RabbitTutorialRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        ctx.close();

    }
}
