<<<<<<< HEAD
package com.example.agritech.WebApp.APIs;
import com.example.agritech.WebApp.DTO.AdsDao;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Repository.AdsRepo;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Services.AdsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v3/ads")
public class AdsController {
    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
    public AdsServices aboutAdsServices;
    @Autowired
    public AdsRepo aboutAdsRepo;

    // Creating about AD
    @PostMapping("/createAd")
    public ResponseEntity<?> createAds(@Valid  @RequestBody AdsDao aboutAdsDao ){
        // getting category
        Category category = categoryRepo.getCategoriesById(aboutAdsDao.getCategoryId());
        com.example.agritech.WebApp.Model.Ads aboutAds =new com.example.agritech.WebApp.Model.Ads();
        aboutAds.setLocation(aboutAdsDao.getLocation());
        aboutAds.setPhoto(aboutAdsDao.getPhoto());
        aboutAds.setTitle(aboutAdsDao.getTitle());
        aboutAds.setDescription(aboutAdsDao.getDescription());
        aboutAds.setPrice(aboutAdsDao.getPrice());
        aboutAds.setQuantity(aboutAdsDao.getQuantity());
        aboutAds.setCategory(category);
        Map<String , Object> creatingNewAd = new HashMap<>();
        com.example.agritech.WebApp.Model.Ads createAboutAds = aboutAdsServices.createNewAd(aboutAds);
        creatingNewAd.put("Message: ", "Ad uploaded Successfully!");
        creatingNewAd.put("data: ", createAboutAds);

        return  new ResponseEntity<>(creatingNewAd, HttpStatus.CREATED);
    }

}

=======
package com.example.agritech.WebApp.APIs;
import com.example.agritech.WebApp.DTO.AdsDao;
import com.example.agritech.WebApp.Model.Category;
import com.example.agritech.WebApp.Repository.AdsRepo;
import com.example.agritech.WebApp.Repository.CategoryRepo;
import com.example.agritech.WebApp.Services.AdsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v3/ads")
public class AdsController {
    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
    public AdsServices aboutAdsServices;
    @Autowired
    public AdsRepo aboutAdsRepo;

    // Creating about AD
    @PostMapping("/createAd")
    public ResponseEntity<?> createAds(@Valid  @RequestBody AdsDao aboutAdsDao ){
        // getting category
        Category category = categoryRepo.getCategoriesById(aboutAdsDao.getCategoryId());
        com.example.agritech.WebApp.Model.Ads aboutAds =new com.example.agritech.WebApp.Model.Ads();
        aboutAds.setLocation(aboutAdsDao.getLocation());
        aboutAds.setPhoto(aboutAdsDao.getPhoto());
        aboutAds.setTitle(aboutAdsDao.getTitle());
        aboutAds.setDescription(aboutAdsDao.getDescription());
        aboutAds.setPrice(aboutAdsDao.getPrice());
        aboutAds.setQuantity(aboutAdsDao.getQuantity());
        aboutAds.setCategory(category);
        Map<String , Object> creatingNewAd = new HashMap<>();
        com.example.agritech.WebApp.Model.Ads createAboutAds = aboutAdsServices.createNewAd(aboutAds);
        creatingNewAd.put("Message: ", "Ad uploaded Successfully!");
        creatingNewAd.put("data: ", createAboutAds);

        return  new ResponseEntity<>(creatingNewAd, HttpStatus.CREATED);
    }

}

>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
