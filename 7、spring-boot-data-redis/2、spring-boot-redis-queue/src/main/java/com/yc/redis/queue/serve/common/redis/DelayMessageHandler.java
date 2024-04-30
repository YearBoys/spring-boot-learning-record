package com.yc.redis.queue.serve.common.redis;

import com.yc.redis.queue.serve.domain.DelayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DelayMessageHandler {
    
    public static SimpleDateFormat dateTimeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DelayQueue delayQueue;

    /**
     * 处理已到期的消息(轮询)
     */
    @Scheduled (fixedDelay = 1000)
    public void handleExpiredMessages() {
        String currentTime = getCurrentTime();
//      1 : 扫描任务，并将需要执行的任务加入到任务队列中
        List<DelayMessage> messages = delayQueue.getExpiredMessages();
        List<DelayMessage> messages_2 = delayQueue.getExpiredMessages();
        System.out.println(currentTime + " 待处理消息数量：" + messages.size());
//      2 : 开始处理消息
        if (!messages.isEmpty()) {
            for (DelayMessage message : messages) {
                    System.out.println(message.getId() + " --> 消息开始处理");
                    try {
//                      2.1.1 : 模拟睡眠3秒,任务的处理时间(实际可能会更长)
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(message.getId() + " --> 消息处理结束");
//                2.2 : 处理完消息,删除消息
                    delayQueue.remove(message);
            }
        }
    }

    /**
     * 获取到的当前时分秒
     *
     * @return
     */
    public static String getCurrentTime() {
        String format = dateTimeFormater.format(new Date());
        return format;
    }
}
