package com.example.test_actuator.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class WebSocketLogAppender extends ch.qos.logback.core.UnsynchronizedAppenderBase<ILoggingEvent> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketLogAppender.class);

    private SimpMessagingTemplate messagingTemplate;

    public WebSocketLogAppender() {
        // Required for Logback to instantiate the appender
    }

    public WebSocketLogAppender(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    protected void append(ILoggingEvent event) {
        if (messagingTemplate != null) {
            String logMessage = event.getFormattedMessage();
            messagingTemplate.convertAndSend("/topic/logs", logMessage);
        } else {
            logger.warn("SimpMessagingTemplate is null. Cannot send log message.");
        }
    }
}



