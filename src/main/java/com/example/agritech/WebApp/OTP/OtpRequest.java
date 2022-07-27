<<<<<<< HEAD
package com.example.agritech.WebApp.OTP;
import com.example.agritech.WebApp.Model.AppUsers;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class OtpRequest {

    private final String phoneNumber;
    private final AppUsers appUsers;
    @Autowired
    public OtpRequest(@JsonProperty("phoneNumber") String phoneNumber, AppUsers appUsers) {
        this.phoneNumber = phoneNumber;
        this.appUsers = appUsers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public String toString() {
        return "OtpRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
=======
package com.example.agritech.WebApp.OTP;
import com.example.agritech.WebApp.Model.AppUsers;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class OtpRequest {

    private final String phoneNumber;
    private final AppUsers appUsers;
    @Autowired
    public OtpRequest(@JsonProperty("phoneNumber") String phoneNumber, AppUsers appUsers) {
        this.phoneNumber = phoneNumber;
        this.appUsers = appUsers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public String toString() {
        return "OtpRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
