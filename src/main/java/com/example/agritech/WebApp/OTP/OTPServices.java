<<<<<<< HEAD
package com.example.agritech.WebApp.OTP;
import com.example.agritech.WebApp.Event.RegistrationCompleteEvent;
import com.example.agritech.WebApp.Model.AppUsers;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class OTPServices implements OTPServicesImp {

    public  RegistrationCompleteEvent registrationCompleteEvent;
    @Autowired
    private final OtpRepo otpRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(OtpSender.class);
    @Autowired
    private final OtpConfiguration otpConfiguration;
    public OTPServices(OtpRepo otpRepo, OtpConfiguration otpConfiguration) {
        this.otpRepo = otpRepo;
        this.otpConfiguration = otpConfiguration;
    }

    @Override
    public OtpRequest sendOTp( OtpRequest otpRequest) {
        // saving OTP and sending it to user  🤔 🤦 ‍♂️
        AppUsers appUsers = otpRequest.getAppUsers();
           String OTP = generateOtp(len);
           SaveOtpForUser(OTP, appUsers);

        PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(otpConfiguration.getTrialNumber());
        String otpMessage = "Welcome to Your Agritech Farm. Your activation OTP is: " + generateOtp(len) + " This code is valid for 15 min " + ". Please" +
                " DO NOT SHARE THIS PIN WITH ANYONE. ✔";
        MessageCreator creator = Message
                .creator(to, from, otpMessage);
        creator.create();
        LOGGER.info(otpMessage);

        return otpRequest;
    }

      // Logic for sending SMS
    private void SendSms(String OTP, String phoneNumber, String otpMessage) {
        LOGGER.info(OTP,phoneNumber,otpMessage);
    }

    // function `generateOtp(int len)` to generate OTp
    int len = 6;
    public String generateOtp(int len) {
        // type of character to be generated
        String str = "0123456789";
        int n = str.length();
        // creating a string to hold the generated OTP
        String OTP = "";
        for (int i = 1; i <= len; i++)
            OTP += (str.charAt((int) ((Math.random() * 10) % n)));
        return OTP;
    }

    // saving OTP To the database
    public void SaveOtpForUser(String otp, AppUsers appUsers) {
        OTP otp1 = new OTP(otp, appUsers);
        otpRepo.save(otp1);
    }

=======
package com.example.agritech.WebApp.OTP;
import com.example.agritech.WebApp.Event.RegistrationCompleteEvent;
import com.example.agritech.WebApp.Model.AppUsers;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class OTPServices implements OTPServicesImp {

    public  RegistrationCompleteEvent registrationCompleteEvent;
    @Autowired
    private final OtpRepo otpRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(OtpSender.class);
    @Autowired
    private final OtpConfiguration otpConfiguration;
    public OTPServices(OtpRepo otpRepo, OtpConfiguration otpConfiguration) {
        this.otpRepo = otpRepo;
        this.otpConfiguration = otpConfiguration;
    }

    @Override
    public OtpRequest sendOTp( OtpRequest otpRequest) {
        // saving OTP and sending it to user  🤔 🤦 ‍♂️
        AppUsers appUsers = otpRequest.getAppUsers();
           String OTP = generateOtp(len);
           SaveOtpForUser(OTP, appUsers);

        PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(otpConfiguration.getTrialNumber());
        String otpMessage = "Welcome to Your Agritech Farm. Your activation OTP is: " + generateOtp(len) + " This code is valid for 15 min " + ". Please" +
                " DO NOT SHARE THIS PIN WITH ANYONE. ✔";
        MessageCreator creator = Message
                .creator(to, from, otpMessage);
        creator.create();
        LOGGER.info(otpMessage);

        return otpRequest;
    }

      // Logic for sending SMS
    private void SendSms(String OTP, String phoneNumber, String otpMessage) {
        LOGGER.info(OTP,phoneNumber,otpMessage);
    }

    // function `generateOtp(int len)` to generate OTp
    int len = 6;
    public String generateOtp(int len) {
        // type of character to be generated
        String str = "0123456789";
        int n = str.length();
        // creating a string to hold the generated OTP
        String OTP = "";
        for (int i = 1; i <= len; i++)
            OTP += (str.charAt((int) ((Math.random() * 10) % n)));
        return OTP;
    }

    // saving OTP To the database
    public void SaveOtpForUser(String otp, AppUsers appUsers) {
        OTP otp1 = new OTP(otp, appUsers);
        otpRepo.save(otp1);
    }

>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
}