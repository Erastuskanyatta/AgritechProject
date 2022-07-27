package com.example.agritech.WebApp.Entity;
import com.example.agritech.WebApp.Model.AppUsers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "PasswordResetToken")
public class PasswordResetToken {
    private static final int EXPIRATION_TIME = 9;
    @Id
    @SequenceGenerator(
            name = "sequence-Name"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long TokenId;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_PASSWORD_TOKEN"))

    private AppUsers appUsers;
    public PasswordResetToken(String token, AppUsers appUsers) {
        super();
        this.token = token;
        this.appUsers = appUsers;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }
    public PasswordResetToken(String token){
        super();
        this.token = token;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }
    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar  = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
