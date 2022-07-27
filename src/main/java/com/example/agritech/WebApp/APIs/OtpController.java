<<<<<<< HEAD
package com.example.agritech.WebApp.APIs;

import com.example.agritech.WebApp.DTO.OtpDao;
import com.example.agritech.WebApp.Model.AppUsers;

import com.example.agritech.WebApp.OTP.OTP;
import com.example.agritech.WebApp.OTP.OTPServices;
import com.example.agritech.WebApp.OTP.OtpRequest;
import com.example.agritech.WebApp.OTP.OtpSender;

import com.example.agritech.WebApp.Repository.AppUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("api/v3/OTP")

public class OtpController {
    @Autowired
    public final OTPServices otpServices;
    @Autowired
    private final OtpSender otpSender;
    @Autowired
    private AppUsersRepo appUsersRepo;

    public OtpController(@Qualifier("twilio") OTPServices otpServices, OtpSender otpSender) {

        this.otpServices = otpServices;
        this.otpSender = otpSender;
    }
    // Sending and RESENDING OTP To the user VIA SMS
    @PostMapping("/sendingOTP")
    public ResponseEntity<?> sendOtp(@Valid @RequestBody OtpRequest otpRequest, OtpDao otpDao){

        AppUsers appUsers = appUsersRepo.getUserByEmail(otpDao.getUserId());
        OTP otp =  new OTP();
        otp.setOtp(otpDao.getOtp());
        otp.setExpirationTime(otpDao.getExpirationTime());
        otp.setAppUsers(appUsers);
        Map<String, Object> SendingOTPToUser= new HashMap<>();
        OtpRequest OTP = otpServices.sendOTp(otpRequest);
        SendingOTPToUser.put("Message: ", " We have sent an OTP code to " + otpRequest.getPhoneNumber());
        return new ResponseEntity<>(SendingOTPToUser,HttpStatus.CREATED);
    }

    //OTP Verification
}

=======
package com.example.agritech.WebApp.APIs;

import com.example.agritech.WebApp.DTO.OtpDao;
import com.example.agritech.WebApp.Model.AppUsers;

import com.example.agritech.WebApp.OTP.OTP;
import com.example.agritech.WebApp.OTP.OTPServices;
import com.example.agritech.WebApp.OTP.OtpRequest;
import com.example.agritech.WebApp.OTP.OtpSender;

import com.example.agritech.WebApp.Repository.AppUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("api/v3/OTP")

public class OtpController {
    @Autowired
    public final OTPServices otpServices;
    @Autowired
    private final OtpSender otpSender;
    @Autowired
    private AppUsersRepo appUsersRepo;

    public OtpController(@Qualifier("twilio") OTPServices otpServices, OtpSender otpSender) {

        this.otpServices = otpServices;
        this.otpSender = otpSender;
    }
    // Sending and RESENDING OTP To the user VIA SMS
    @PostMapping("/sendingOTP")
    public ResponseEntity<?> sendOtp(@Valid @RequestBody OtpRequest otpRequest, OtpDao otpDao){

        AppUsers appUsers = appUsersRepo.getUserByEmail(otpDao.getUserId());
        OTP otp =  new OTP();
        otp.setOtp(otpDao.getOtp());
        otp.setExpirationTime(otpDao.getExpirationTime());
        otp.setAppUsers(appUsers);
        Map<String, Object> SendingOTPToUser= new HashMap<>();
        OtpRequest OTP = otpServices.sendOTp(otpRequest);
        SendingOTPToUser.put("Message: ", " We have sent an OTP code to " + otpRequest.getPhoneNumber());
        return new ResponseEntity<>(SendingOTPToUser,HttpStatus.CREATED);
    }

    //OTP Verification
}

>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
