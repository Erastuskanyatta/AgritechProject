<<<<<<< HEAD
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.AppUsers;
import com.example.agritech.WebApp.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUsersRepo  extends JpaRepository<AppUsers, Integer> {

//    Optional<User> findUserByUsernameAndPassword(String userName, String password);

    AppUsers findByEmail(String email);
    @Query("SELECT i FROM AppUsers  i WHERE  i.username = :username")
    List<AppUsers> getUserByUserName(@Param("username") String username);

    Optional<AppUsers> findUserByEmail(@NotBlank(message = "Email cannot be empty!") @Email String email);

    Optional<AppUsers> findUserByUsername(@NotBlank(message = "UserName cannot be empty!") String username);

    @Query("SELECT i.phoneNumber from  AppUsers i WHERE i.email = :email")
    List<String> getPhoneNumberByEmail(String email);

    AppUsers findUserByUsernameAndPassword(String userName, String password);
    @Query("Select i from AppUsers i where i.email = :email")
    AppUsers getUserByEmail(@Param("email") Integer userId);
}
//    @Query("select e.name, e.city from Employee e" )
=======
package com.example.agritech.WebApp.Repository;

import com.example.agritech.WebApp.Model.AppUsers;
import com.example.agritech.WebApp.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUsersRepo  extends JpaRepository<AppUsers, Integer> {

//    Optional<User> findUserByUsernameAndPassword(String userName, String password);

    AppUsers findByEmail(String email);
    @Query("SELECT i FROM AppUsers  i WHERE  i.username = :username")
    List<AppUsers> getUserByUserName(@Param("username") String username);

    Optional<AppUsers> findUserByEmail(@NotBlank(message = "Email cannot be empty!") @Email String email);

    Optional<AppUsers> findUserByUsername(@NotBlank(message = "UserName cannot be empty!") String username);

    @Query("SELECT i.phoneNumber from  AppUsers i WHERE i.email = :email")
    List<String> getPhoneNumberByEmail(String email);

    AppUsers findUserByUsernameAndPassword(String userName, String password);
    @Query("Select i from AppUsers i where i.email = :email")
    AppUsers getUserByEmail(@Param("email") Integer userId);
}
//    @Query("select e.name, e.city from Employee e" )
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
//    List<Employee> getNameAndCityOnly();