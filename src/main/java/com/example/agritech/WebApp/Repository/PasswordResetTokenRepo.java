<<<<<<< HEAD
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepo extends JpaRepository< PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
=======
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepo extends JpaRepository< PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
