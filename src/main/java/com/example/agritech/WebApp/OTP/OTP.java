package com.example.agritech.WebApp.OTP;
import com.example.agritech.WebApp.Model.AppUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OTP")
public class OTP {
    private static  final int  Expiration_Time = 3;
    @Id
    @SequenceGenerator(
            name = "sequence-Name"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long otpId;
    private String otp;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId",
              nullable = false ,
              foreignKey = @ForeignKey(name = "FK_USER_OTP_NUMBER"))

    private AppUsers appUsers;
    public OTP(String otp, AppUsers appUsers) {
        super();
        this.otp = otp;
        this.appUsers = appUsers;
        this.expirationTime = calculateExpirationTime(Expiration_Time);
    }


    // calculating expiration time
    private Date calculateExpirationTime(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }


}


