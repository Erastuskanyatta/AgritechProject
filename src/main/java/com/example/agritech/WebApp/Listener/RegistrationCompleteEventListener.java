package com.example.agritech.WebApp.Listener;
import com.example.agritech.WebApp.Email.EmailSenderServices;
import com.example.agritech.WebApp.Event.RegistrationCompleteEvent;
import com.example.agritech.WebApp.Model.AppUsers;
import com.example.agritech.WebApp.OTP.OTPServices;
import com.example.agritech.WebApp.OTP.OtpRequest;
import com.example.agritech.WebApp.OTP.OtpSender;
import com.example.agritech.WebApp.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.UUID;
@Component
@Slf4j
public class RegistrationCompleteEventListener  implements ApplicationListener<RegistrationCompleteEvent>  {

    private JavaMailSender javaMailSender;
    @Qualifier("twilio")
    @Autowired
    private final OTPServices otpServices;

    private  final OtpSender otpSender;
    @Autowired
    private UserService userService;
    private final static Logger LOGGER = LoggerFactory.getLogger(com.example.agritech.WebApp.Email.EmailSenderServices.class);
    public final EmailSenderServices EmailSenderServices;
    private JavaMailSender mailSender;
    private String email;

    public RegistrationCompleteEventListener(@Qualifier("twilio") OTPServices otpServices, OtpSender otpSender, com.example.agritech.WebApp.Email.EmailSenderServices emailSenderServices) {
        this.otpServices = otpServices;
        this.otpSender = otpSender;
        this.EmailSenderServices = emailSenderServices;
    }
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        String token = UUID.randomUUID().toString();
        AppUsers appUsers = event.getAppUsers();
        userService.saveVerificationTokenForUser(token, appUsers);

        // code to SEND EMAIL to the registered user email account
         String Activate = " http://localhost:4040/verifyRegistration?token=" + token;
        EmailSenderServices.sendEmail(
                appUsers.getEmail(),
                "Confirm your Email",
                "Dear, " + appUsers.username +
                        ". Thank you for registering. "  +
                        " Please click on this link to activate your account: " + Activate +
                        ". This link will be expire within 20min. "
                        + " If you received this email in error, you can safely ignore this email."
                );
    }


}




