<<<<<<< HEAD
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
=======
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
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
