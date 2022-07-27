package com.example.agritech.WebApp.Model;

import lombok.Data;

@Data
public class PasswordReset {

    public String email;
    public String oldPassword;
    public String newPassword;

}
