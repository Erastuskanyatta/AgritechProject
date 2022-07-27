<<<<<<< HEAD
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
=======
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
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
