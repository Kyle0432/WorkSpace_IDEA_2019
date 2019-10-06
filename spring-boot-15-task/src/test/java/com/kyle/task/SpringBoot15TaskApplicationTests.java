package com.kyle.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot15TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("通知今晚开会");
        simpleMailMessage.setText("今晚7点开会");
        simpleMailMessage.setTo("249693842@qq.com");
        simpleMailMessage.setFrom("3320400948@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void test02() throws Exception{
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        //邮件设置
        mimeMessageHelper.setSubject("通知今晚开会");
        mimeMessageHelper.setText("<h2 style='color:red'>今晚7点开会</h2>",true);
        mimeMessageHelper.setTo("249693842@qq.com");
        mimeMessageHelper.setFrom("3320400948@qq.com");
        //上传附件图片等等
        mimeMessageHelper.addAttachment("1.jpg",new File("\u202AC:\\Users\\Think\\Pictures\\TIM图片20190524194015.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("\u202AC:\\Users\\Think\\Pictures\\Kyle.jpg"));

        mailSender.send((MimeMessagePreparator) mimeMessageHelper);
    }

}
