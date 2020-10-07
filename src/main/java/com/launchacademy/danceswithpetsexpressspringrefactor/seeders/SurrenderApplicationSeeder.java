package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.SurrenderApplication;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetTypeRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.SurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class SurrenderApplicationSeeder {
  @Autowired private PetTypeRepository petTypeRepository;
  @Autowired private SurrenderApplicationRepository surrenderApplicationRepository;

  public void seed() {
    List<String> nameList = Arrays.asList("Dan Alberts");
    List<String> phoneNumberList = Arrays.asList("617-555-3286");
    List<String> emailList = Arrays.asList("danalberts@github.com");
    List<String> petNameList = Arrays.asList("Rocket");
    List<String> petImgUrlList = Arrays.asList("/img/pets/Rocket_01_450x600.jpg");
    List<String> petAgeList = Arrays.asList("7|2");
    List<Boolean> vaccinationStatusList = Arrays.asList(false);
    List<String> descriptionList = Arrays.asList("Rocket is a VERY intelligent raccoon.");
    List<String> adoptionStoryList = Arrays.asList("Rocket's a great guy, but he's just a bit too much to handle and kind of has an explosive personality.");
    List<String> applicationStatusList = Arrays.asList("pending");
    List<Integer> petTypeIdList = Arrays.asList(6);
    List<PetType> petTypes = Lists.newArrayList(petTypeRepository.findAll());

    for (int i = 0; i < nameList.size(); i++) {
      SurrenderApplication surrenderApplication = new SurrenderApplication();
      surrenderApplication.setName(nameList.get(i));
      surrenderApplication.setPhoneNumber(phoneNumberList.get(i));
      surrenderApplication.setEmail(emailList.get(i));
      surrenderApplication.setPetName(petNameList.get(i));
      surrenderApplication.setPetImgUrl(petImgUrlList.get(i));
      surrenderApplication.setPetAge(petAgeList.get(i));
      surrenderApplication.setVaccinationStatus(vaccinationStatusList.get(i));
      surrenderApplication.setDescription(descriptionList.get(i));
      surrenderApplication.setAdoptionStory(adoptionStoryList.get(i));
      surrenderApplication.setApplicationStatus(applicationStatusList.get(i));
      surrenderApplication.setPetType(petTypes.get(petTypeIdList.get(i)-1));
      surrenderApplicationRepository.save(surrenderApplication);
    }
  }
}
