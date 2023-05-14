package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import java.io.File;

@Configuration
public class SpringFileAdaptorIntegration {

    //channel
    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000"))
    public FileReadingMessageSource fileReadingMessageSource(){

        //configure a filter
        CompositeFileListFilter<File> filter=new CompositeFileListFilter<>();
        filter.addFilters(new SimplePatternFileListFilter("*.jpg"));

        FileReadingMessageSource reader=new FileReadingMessageSource();
        reader.setDirectory(new File("/home/raj/Desktop/source"));
        reader.setFilter(filter);
        return  reader;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler fileWritingMessageHandler=
                new FileWritingMessageHandler(new File("/home/raj/Desktop/dest"));

        fileWritingMessageHandler.setAutoCreateDirectory(true);
        fileWritingMessageHandler.setExpectReply(false);

        return  fileWritingMessageHandler;
    }
}





