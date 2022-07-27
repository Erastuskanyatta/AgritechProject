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



