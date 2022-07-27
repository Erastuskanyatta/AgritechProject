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
