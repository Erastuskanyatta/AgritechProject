package com.example.agritech.WebApp.Services;
import ExeptionHandler.emailAlreadyTakenException;
import com.example.agritech.WebApp.Entity.PasswordResetToken;
import com.example.agritech.WebApp.Entity.VerificationToken;
import com.example.agritech.WebApp.Model.AppUsers;
import com.example.agritech.WebApp.Repository.AppUsersRepo;
import com.example.agritech.WebApp.Repository.PasswordResetTokenRepo;

import com.example.agritech.WebApp.Repository.VerificationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    PasswordResetTokenRepo passwordResetTokenRepo;
    @Autowired
    public  final VerificationTokenRepo verificationTokenRepo;
    private final AppUsersRepo appUsersRepo;
    public UserService(VerificationTokenRepo verificationTokenRepo, AppUsersRepo appUsersRepo) {
        this.verificationTokenRepo = verificationTokenRepo;
        this.appUsersRepo = appUsersRepo;
    }
    public static List<AppUsers> allUser(AppUsers appUsers) {
        return allUser(appUsers);
    }
    public  AppUsers authenticate(String userName, String password){
        AppUsers appUsers = appUsersRepo.findUserByUsernameAndPassword(userName, password);
        return appUsers;
     }
     @Autowired
     public PasswordEncoder passwordEncoder;
    public AppUsers registerUser(AppUsers appUsers) throws emailAlreadyTakenException {
        // checking if email && UserName are already in use
        Optional<AppUsers> userOptional = appUsersRepo.findUserByEmail(appUsers.getEmail());
        Optional<AppUsers> userOptional1 = appUsersRepo.findUserByUsername(appUsers.getUsername());
        if (userOptional.isPresent()) {
            throw new emailAlreadyTakenException("The email " + appUsers.getEmail() + " " +
                    "is already taken.Please try a different email." );
        } else if (userOptional1.isPresent()) {
            throw new IllegalStateException("The username "  + appUsers.getUsername() + " " +
                    "is already taken. Please try another username ");
        }
        appUsers.password(passwordEncoder.encode(appUsers.getPassword()));
        return appUsersRepo.save(appUsers);
    }

// saving verification token to database
    public void saveVerificationTokenForUser(String token, AppUsers appUsers) {
        VerificationToken verificationToken
                = new VerificationToken(token,appUsers);
        verificationTokenRepo.save(verificationToken);
    }
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken
                = verificationTokenRepo.findByToken(token);
        if(verificationToken == null){
            return  "invalid";
        }
        AppUsers appUsers = verificationToken.getAppUsers();
        Calendar cal = Calendar.getInstance();
        if((verificationToken.getExpirationTime().getTime()
        -cal.getTime().getTime()) <= 0){
            verificationTokenRepo.delete(verificationToken);
            return "expired";
        }
        appUsers.setEnabled(true);
        appUsersRepo.save(appUsers);
        return "valid" ;
    }
    //new verification token
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken
                = verificationTokenRepo.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepo.save(verificationToken);
        return verificationToken;
    }
    public AppUsers findUserByEmail(String email) {
        return  appUsersRepo.findByEmail(email);
    }
// saving password reset token
    public void createPasswordResetTokenForUser(AppUsers appUsers, String token) {
        PasswordResetToken passwordResetToken
                = new PasswordResetToken(token, appUsers);
        passwordResetTokenRepo.save(passwordResetToken);
    }
    //Calculating expiry time
    public String validatePasswordReset(String token) {
        PasswordResetToken passwordResetToken
                = passwordResetTokenRepo.findByToken(token);
        if(passwordResetToken == null){
            return  "invalid";
        }
        AppUsers appUsers = passwordResetToken.getAppUsers();
        Calendar cal = Calendar.getInstance();

        if((passwordResetToken.getExpirationTime().getTime()
                -cal.getTime().getTime()) <= 0){
            passwordResetTokenRepo.delete(passwordResetToken);
            return "expired";
        }
        return "valid" ;
    }
    public Optional<AppUsers> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetTokenRepo.findByToken(token).getAppUsers());
    }
    public void changePassword(AppUsers appUsers, String newPassword) {
        appUsers.setPassword(passwordEncoder.encode(newPassword));
        appUsersRepo.save(appUsers);
    }
    public boolean checkIfOldPasswordIsValid(AppUsers appUsers, String oldPassword) {
        return passwordEncoder.matches(oldPassword, appUsers.getPassword());
    }
    public VerificationToken findByUser(String appUsers) {
        return verificationTokenRepo.findByAppUsers(appUsers);
    }
    public boolean userExists(String email) {
        return appUsersRepo.findByEmail(email) != null;
    }
    public List<AppUsers> getUserByUserName(String username) {
        return appUsersRepo.getUserByUserName(username);
    }
    public void updatePhoneNumber(AppUsers appUsers, String newPhoneNumber) {
        appUsers.setPhoneNumber(newPhoneNumber);
        appUsersRepo.save(appUsers);
    }
    public List<String> getPhoneNumberByEmail(String email) {
        return appUsersRepo.getPhoneNumberByEmail( email);
    }
}
