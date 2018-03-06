package com.javarticles.spring.integration.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.PollableChannel;

public class SpringIntegrationJmsExample {
    private JmsTemplate jmsTemplate;
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringIntegrationJmsExample springIntExample = (SpringIntegrationJmsExample) context.getBean("springIntExample");
        springIntExample.sendEmployee();
    }
    
    public void sendEmployee() {
        Employee emp = new Employee(1, "Joe", 37);
        System.out.println("Queue employee " + emp + " for processing");
        getJmsTemplate().convertAndSend("empQueue", emp);
    }
    
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void processEmployee(Employee emp) {
        System.out.println("Employee: " + emp + " processed");
    }
}
