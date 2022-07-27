<<<<<<< HEAD
package com.example.agritech.WebApp.Services;

import com.example.agritech.WebApp.Model.Ads;
import com.example.agritech.WebApp.Repository.AdsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsServices {
    @Autowired
    public AdsRepo aboutAdsRepo;
    public Ads createNewAd(Ads aboutAds) {
     return  aboutAdsRepo.save(aboutAds);
    }
}
=======
package com.example.agritech.WebApp.Services;

import com.example.agritech.WebApp.Model.Ads;
import com.example.agritech.WebApp.Repository.AdsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsServices {
    @Autowired
    public AdsRepo aboutAdsRepo;
    public Ads createNewAd(Ads aboutAds) {
     return  aboutAdsRepo.save(aboutAds);
    }
}
>>>>>>> 5489e3d3c6d0fd72014af5e4c4f78d0c1a54a3d2
