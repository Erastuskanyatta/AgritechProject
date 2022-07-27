package com.example.agritech.WebApp.Model;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@ToString
@Component
@Data
@NoArgsConstructor
@Entity
@Table(name="AppUsers")
public class AppUsers {
      @Id
      @SequenceGenerator(
              name = "sequence-name"

      )
      @GeneratedValue(
              strategy = GenerationType.IDENTITY
      )

    public Integer UserId;
    @NotNull
    @NotBlank(message = "FirstName cannot be empty!")
    public String firstName;
    @NonNull
    @NotBlank(message = "SecondName cannot be empty!")
    public String secondName;
    @NotNull
    @NotBlank(message = "Email cannot be empty!")
    @Email
    public String email;
    @NotNull
    @NotBlank(message = "Username cannot be empty!")
    public String username;
    @NotNull
    @Column(length = 60)
    @Size(min = 4, message = "Password Must have more than 8 characters!")
    @NotBlank(message = "Password cannot be empty!")
    public String password;
    @NotNull
    @NotBlank(message = "ConfirmPassword cannot be empty!")
    public String confirmPassword;
//    @Pattern(regexp = "^\\d{10}$" ,message = "invalid mobile number")
    public String phoneNumber;
    @NotNull
    public String role;
    public boolean enabled = false;
    public boolean isPresent;
    public void password(String encode) {
    }
//    public Integer getUser() {
//        return UserId;
//    }

}


