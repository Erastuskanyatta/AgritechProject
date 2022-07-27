package com.example.agritech.WebApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpDao {
    public Integer UserId;

    public String email;

    private @NotNull  String otp;
    private  @NotNull Date expirationTime;

}
