package com.demo.airportmanagement.db;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GenericMongoAuditListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        Object obj = event.getSource();
        System.out.println(LocalDateTime.now() + " Saved Document " + obj);
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        Object obj = event.getSource();
        System.out.println(LocalDateTime.now() + " Deleted Document " + obj);
    }

}
