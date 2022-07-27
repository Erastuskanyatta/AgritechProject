package com.example.agritech.WebApp.Event;
import com.example.agritech.WebApp.Model.AppUsers;
import lombok.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Getter
@Setter

public class RegistrationCompleteEvent<t extends ApplicationEvent> extends ApplicationEvent {
    private AppUsers appUsers;
    private  String applicationUrl;

    public RegistrationCompleteEvent( AppUsers appUsers , String applicationUrl) {
        super(appUsers);
        this.appUsers = appUsers;
        this.applicationUrl = applicationUrl;
    }

}
