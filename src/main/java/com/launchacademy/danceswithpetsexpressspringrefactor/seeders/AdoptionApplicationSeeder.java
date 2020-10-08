package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.AdoptionApplication;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.AdoptionApplicationRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetRepository;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class AdoptionApplicationSeeder {
  public void seed(AdoptionApplicationRepository adoptionApplicationRepository, PetRepository petRepository) {
    if(adoptionApplicationRepository.count() == 0) {
      List<String> nameList = Arrays.asList("Tom Murphy","Russ Moore","Brendan Montima","Dan Alberts","Patrick Whelan","Monica Gonzalez","Monica Gonzalez","Dan Alberts","Dan Alberts");
      List<String> phoneNumberList = Arrays.asList("707-555-8666","415-555-7877","617-555-2626","617-555-3286","617-555-7973","805-555-6466","805-555-6466","617-555-3286","617-555-3286");
      List<String> emailList = Arrays.asList("murphy-codes@github.com","wrmoore@github.com","bhmdev@github.com","danalberts@github.com","prophetsfall@github.com","mandm@cutepetexamples.com","mandm@cutepetexamples.com","danalberts@github.com","danalberts@github.com");
      List<String> homeStatusList = Arrays.asList("rent","rent","own","rent","own","rent","rent","rent","rent");
      List<String> applicationStatusList = Arrays.asList("pending","pending","pending","pending","pending","pending","pending","pending","pending");
      List<Integer> petIdList = Arrays.asList(5,2,1,6,7,3,4,6,8);
      List<Pet> pets = Lists.newArrayList(petRepository.findAll());

      for (int i = 0; i < nameList.size(); i++) {
        AdoptionApplication adoptionApplication = new AdoptionApplication();
        adoptionApplication.setName(nameList.get(i));
        adoptionApplication.setPhoneNumber(phoneNumberList.get(i));
        adoptionApplication.setEmail(emailList.get(i));
        adoptionApplication.setHomeStatus(homeStatusList.get(i));
        adoptionApplication.setApplicationStatus(applicationStatusList.get(i));
        adoptionApplication.setPet(pets.get(petIdList.get(i)-1));
        adoptionApplicationRepository.save(adoptionApplication);
      }
    }
  }
}