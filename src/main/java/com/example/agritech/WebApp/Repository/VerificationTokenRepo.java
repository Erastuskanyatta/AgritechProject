<<<<<<< HEAD
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByAppUsers(String appUsers);
}
=======
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByAppUsers(String appUsers);
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
