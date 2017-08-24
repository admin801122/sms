package com.hxs.sms.util.mail;

import com.hxs.sms.EmailInfoDTO;
import com.hxs.sms.util.ContextUtils;
import com.hxs.sms.web.HttpContext;
import com.hxs.sms.util.log.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class SendMailUtil {

  private static final String SERVER_EMAIL_ADDR = "server.email.addr";

  public static final String MAIL_SUBJECT = "mail.subject";

  public static final String MAIL_CONTENT = "mail.content";


  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private TaskExecutor taskExecutor;


  public static void send(EmailInfoDTO emailInfo) {
    ApplicationContext context = HttpContext.getApplicationContext();
    SendMailUtil sendMailUtil = context.getBean(SendMailUtil.class);
    sendMailUtil.sendEmail(emailInfo);
  }

  public void sendEmail(final EmailInfoDTO emailInfo) {
    taskExecutor.execute(new Runnable() {
      public void run() {
        try {
          // 建立邮件消息
          SimpleMailMessage mailMessage = new SimpleMailMessage();
          String[] sendTos = emailInfo.getSendTo();
          String[] toCc = emailInfo.getToCc();
          mailMessage.setTo(sendTos);
          mailMessage.setFrom(ContextUtils.getProperty(SERVER_EMAIL_ADDR));
          mailMessage.setCc(toCc);
          mailMessage.setSubject(emailInfo.getSubject());
          mailMessage.setText(emailInfo.getContent());
          mailSender.send(mailMessage);
          LoggerUtil.info(SendMailUtil.class, "邮件发送成功，邮件详细信息【" + mailMessage.toString() + "】");
        }
        catch (Exception e) {
          e.printStackTrace();
          LoggerUtil.error(SendMailUtil.class, e.getMessage());
        }
      }
    });
  }
}
