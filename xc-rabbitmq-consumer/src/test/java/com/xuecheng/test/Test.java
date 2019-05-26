package com.xuecheng.test;

import com.rabbitmq.client.*;

import java.io.IOException;

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

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //            String consumerTag:消费者标签，如果不指定，会默认一个标签
                //            Envelope envelope, 消息内容包
                //            AMQP.BasicProperties properties, 消息得属性
                //            byte[] body 消息内容
                String exchange = envelope.getExchange();
                String routingKey = envelope.getRoutingKey();
                String string = new String(body, "utf-8");
                System.out.println(exchange);
                System.out.println(routingKey);
                System.out.println(string);
            }
        };

//        String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(queue, true, false, false, null);

//        String queue:监听队列
//        boolean autoAck;是否回复，表示消费者接受到消息，然后回复，让队列中删除该消息
//                           如果设置为true,表示消费者接受到消息自动回复，如果为false,需要程序员自己回复（channel.basicAck();）;
//        Consumer callback:回调，接受到消息后回调方法
        channel.basicConsume(queue,true,defaultConsumer);
    }
}
