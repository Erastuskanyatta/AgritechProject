<<<<<<< HEAD
package com.example.agritech.WebApp.OTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class OtpSender {
@Autowired
private final OTPServices otpServices;
@Autowired
    private final OtpConfiguration otpConfiguration;

    public OtpSender(@Qualifier("twilio") OTPServices otpSender, OtpConfiguration otpConfiguration) {
        this.otpServices = otpSender;
        this.otpConfiguration = otpConfiguration;
    }
    public void sendOtp(OtpRequest otpRequest){
        otpServices.sendOTp(otpRequest);
    }
}



=======
package com.example.agritech.WebApp.OTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class OtpSender {
@Autowired
private final OTPServices otpServices;
@Autowired
    private final OtpConfiguration otpConfiguration;

    public OtpSender(@Qualifier("twilio") OTPServices otpSender, OtpConfiguration otpConfiguration) {
        this.otpServices = otpSender;
        this.otpConfiguration = otpConfiguration;
    }
    public void sendOtp(OtpRequest otpRequest){
        otpServices.sendOTp(otpRequest);
    }
}



>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
