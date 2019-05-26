package com.xuecheng.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: houyong
 * @Date: 2019/3/5 15:08
 * @describe
 */
public class Test {
    public static void main(String[] args) throws Exception {
        final String queue = "hello world";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPassword("guest");
        connectionFactory.setUsername("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);


        Connection connection =
                connectionFactory.newConnection();
        Channel channel =
                connection.createChannel();


//        String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(queue, true, false, false, null);
        String body = "小明" + System.currentTimeMillis();

        /*String exchange:如果不指定交换机，会使用默认得交换机
         String routingKey:如果没有指定交换机，routingkey就得指定队列
          BasicProperties props, byte[] body*/
        channel.basicPublish("", queue, null, body.getBytes());
        System.out.println(body);
    }
}
