package com.example.agritech.WebApp.APIs;
import ExeptionHandler.emailAlreadyTakenException;
import com.example.agritech.WebApp.Email.EmailSenderServices;
import com.example.agritech.WebApp.Entity.VerificationToken;
import com.example.agritech.WebApp.Event.RegistrationCompleteEvent;
import com.example.agritech.WebApp.Model.AppUsers;
import com.example.agritech.WebApp.Model.PasswordReset;
import com.example.agritech.WebApp.Model.PhoneNumberUpdateDuringOTPVerification;
import com.example.agritech.WebApp.OTP.OTPServices;
import com.example.agritech.WebApp.OTP.OtpRepo;

import com.example.agritech.WebApp.Repository.AppUsersRepo;
import com.example.agritech.WebApp.Services.UserService;
import com.example.agritech.WebApp.ValidationHandler.ValidationHandler;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;
@Transactional
@Slf4j
@RestController
@Controller
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private  final   AppUsersRepo appUsersRepo;
    @Autowired
    private  final OtpRepo otpRepo;

    @Autowired
    private  final EmailSenderServices emailSenderServices;

    @Autowired
    private final OTPServices otpServices;
    private final AppUsers appUsers;

    private final UserService userService;
    ValidationHandler validationHandler;

    @Autowired
    private ApplicationEventPublisher publisher;
    public UserController(AppUsersRepo appUsersRepo, OtpRepo otpRepo,
                          EmailSenderServices emailSenderServices, OTPServices otpServices,
                          AppUsers appUsers, UserService userService) {
        this.appUsersRepo = appUsersRepo;
        this.otpRepo = otpRepo;
        this.emailSenderServices = emailSenderServices;

        this.otpServices = otpServices;
        this.appUsers =appUsers;
        this.userService = userService;
    }
    //Registering a new user
    @SneakyThrows
    @PostMapping("/register")
    public  ResponseEntity<?> register(@Valid @RequestBody AppUsers appUsers, final
    HttpServletRequest request) throws emailAlreadyTakenException {
        Map<String, Object> registerNewUser = new HashMap<>();
        AppUsers register = userService.registerUser(appUsers);
        registerNewUser.put("status_code", HttpStatus.CREATED.value());
        registerNewUser.put("Message", " Please click on the link in your email account to verify your account.");
        registerNewUser.put("Data", register);
//        registerNewUser.put("Date: ", new Date());
        registerNewUser.put("Content-Type:", ContentType.APPLICATION_JSON);
        registerNewUser.put("Connection:", JConsoleContext.ConnectionState.CONNECTED);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(appUsers.getPassword());
        String encodePassword = encoder.encode(appUsers.getConfirmPassword());
        appUsers.setPassword(encodedPassword);
        appUsers.setConfirmPassword(encodePassword);

        publisher.publishEvent(new RegistrationCompleteEvent<>(
                appUsers,
                applicationUrl(request)
        ));

        return new ResponseEntity<>(registerNewUser, HttpStatus.CREATED);
    }

    // Sending Verification Token via Email during Registration
    @ResponseBody
    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "user verified.. user will verify his/her phone number her." +
                    " The user will give a code from his/her phone in this page";
        }
        return "InValid Link! ";
    }

    //Resending Verification Token via Email during Registration
    @ResponseBody
    @GetMapping("/resendVerifyToken")
    public String resendVerificationEmail(@RequestParam("token") String oldToken,
                                          HttpServletRequest request) {
        VerificationToken verificationToken =
                userService.generateNewVerificationToken(oldToken);

        AppUsers appUsers = verificationToken.getAppUsers();

        resendVerificationTokenEmail(appUsers, applicationUrl(request), verificationToken);
        return "Verification Link sent!";
    }
    private void resendVerificationTokenEmail(AppUsers user, String applicationUrl,
                                              VerificationToken verificationToken) {
        String url =
                applicationUrl
                        + "/verifyRegistration?token="
                        + verificationToken.getToken();
//         TO DO SEND EMAIL HERE

        log.info("Click the link to verify your account: {}", url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

    // Allow User to Login
    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody AppUsers appUsers) {
        Map<String, Object> log = new HashMap<>();

        AppUsers Authenticate = userService.authenticate(appUsers.username, appUsers.password);
        log.put("status_code", HttpStatus.CREATED.value());
        log.put("Message", " Login Successful ✨ 🎉 👓 !");
        log.put("Data", Authenticate);
        return new ResponseEntity<>(log, HttpStatus.CREATED);
    }



    //List of Registered Users
    @ResponseBody
    @GetMapping("/registered/users")
 public Map<String, Object> allUsers(){
        Map<String, Object> listOfUsers = new HashMap<>();
        List<AppUsers> registeredUsers = appUsersRepo
                .findAll()
                .stream()
                .collect(Collectors.toList());
        listOfUsers.put("Status_Code:", HttpStatus.CREATED.value());
        listOfUsers.put("Connection:", JConsoleContext.ConnectionState.CONNECTED);
        listOfUsers.put("Date: ", new Date());
        listOfUsers.put("Content-Type:", ContentType.APPLICATION_JSON);
        listOfUsers.put("Status_Code:", HttpStatus.CREATED.value());
        listOfUsers.put("Message:", "This is the list of registered users:");
        listOfUsers.put("Data:", registeredUsers);
        return  listOfUsers;
    }

    // listing a single user by username
    @GetMapping("/userDetails/{username}")
    public Map<String, Object> singleUser(@PathVariable String username){
        Map<String, Object> userDetails = new HashMap<>();
        List<AppUsers> listingUser = userService.getUserByUserName(username);
        userDetails.put("Date:", new Date());
        userDetails.put("Status:", HttpStatus.CREATED.value());
        userDetails.put("Data:", listingUser );
        userDetails.put("Message:", "User Details retrieved successfully");
        userDetails.put("Connection:", JConsoleContext.ConnectionState.CONNECTED);
        return  userDetails;
    }

    //Token To ResetPassword to be sent via email
    @PostMapping("/resetPassword")
    public String resetPassword(@Valid @RequestBody PasswordReset passwordReset, HttpServletRequest request) {
        AppUsers appUsers = userService.findUserByEmail(passwordReset.getEmail());
        String url = "";
        if(appUsers !=null){
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(appUsers,token);
            url = passwordResetTokenMail(appUsers,applicationUrl(request), token);
        }
        return url;
    }
    //updating User details
    //Saving Reset password Apis
    @PostMapping("/savingPassword")
    public String savePassword(@Valid @RequestParam("token")String token,
                               @RequestBody PasswordReset passwordReset){
        String result = userService.validatePasswordReset(token);
        if (!result.equalsIgnoreCase("valid")){
            return "invalid Token";
        }
        Optional<AppUsers> appUsers = userService.getUserByPasswordResetToken(token);
        if(appUsers.isPresent()){
            userService.changePassword(appUsers.get(),
                    passwordReset.getNewPassword());
            return  "password Reset Done!";
        } else {
            return "Invalid token";
        }
    }
    // changePassword for the user
    @PostMapping("/changePassword")
    public  String changePassword(@Valid @RequestBody PasswordReset passwordReset){
        AppUsers appUsers = userService.
                findUserByEmail(passwordReset.getEmail());
        if(!userService.checkIfOldPasswordIsValid(appUsers,passwordReset.getOldPassword())){
            return "That password Does Not Exist!";
        }
        //saving password goes here
        userService.changePassword(appUsers,passwordReset.getNewPassword());
        return  "Password Changed Successfully!";
    }

    // sending resetPassword Token to user via email
    private String passwordResetTokenMail(AppUsers appUsers, String applicationUrl, String token) {
        String url =
                applicationUrl
                        + "/resetPassword?token="
                        + token;
        // TO DO SEND EMAIL HERE
        String ResetEmail = url;
        emailSenderServices.sendEmail(
                appUsers.getEmail(),
                "Password Reset:",
                "Dear, " + appUsers.username + " You have requested to have your password reset for your account at Agritech.Please visit this link to reset your password: " + ResetEmail
                        + " Please ignore this email if you have not requested to change your password!"
        );
        return url;
    }

    private class UserAlreadyExistException extends Throwable {
        public UserAlreadyExistException(@NotBlank(message = "Email cannot be empty!") @Email String s) {
        }
    }

   //  Updating Phone Number during OTP Verification
    @PutMapping("/updatePhoneNumber")
    public  String updatePhoneNumber(@Valid @RequestBody PhoneNumberUpdateDuringOTPVerification phoneNumberUpdateDuringOTPVerification){
        AppUsers appUsers = userService.findUserByEmail(phoneNumberUpdateDuringOTPVerification.getEmail());
        userService.updatePhoneNumber(appUsers, phoneNumberUpdateDuringOTPVerification.getNewPhoneNumber());
        return "Nice work! Phone Number Updated. ";
    }

    // FetchingPhone number for the user during OTP verification
    @GetMapping("/displayUserPhone/{email}")
    public  Map<String, Object> userPhoneNumber(@PathVariable String email){
        Map<String, Object>  phoneNumber = new HashMap<>();
        List<String> displayUsersPhoneNumber = userService.getPhoneNumberByEmail(email);
        phoneNumber.put("message:", "Use this number to verify your account." + " " + "/ Change your Phone number");
        phoneNumber.put("Data:", displayUsersPhoneNumber);
        return  phoneNumber;
    }
}




