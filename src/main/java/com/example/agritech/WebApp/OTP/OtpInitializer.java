<<<<<<< HEAD
package com.example.agritech.WebApp.OTP;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
@Configuration
public class OtpInitializer {
    private final static Logger LOGGER =
            LoggerFactory.getLogger(OtpInitializer.class);

    private final OtpConfiguration otpConfiguration;
    public OtpInitializer(OtpConfiguration otpConfiguration) throws URISyntaxException {
        this.otpConfiguration = otpConfiguration;
        Twilio.init(otpConfiguration.getAccountSid(), otpConfiguration.getAuthToken());
        LOGGER.info("Testing the Twilio functionality. account sid {} " , otpConfiguration.getAccountSid() );
}
}




=======
package com.example.agritech.WebApp.OTP;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
@Configuration
public class OtpInitializer {
    private final static Logger LOGGER =
            LoggerFactory.getLogger(OtpInitializer.class);

    private final OtpConfiguration otpConfiguration;
    public OtpInitializer(OtpConfiguration otpConfiguration) throws URISyntaxException {
        this.otpConfiguration = otpConfiguration;
        Twilio.init(otpConfiguration.getAccountSid(), otpConfiguration.getAuthToken());
        LOGGER.info("Testing the Twilio functionality. account sid {} " , otpConfiguration.getAccountSid() );
}
}




>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
