package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import com.google.inject.internal.util.Lists;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class PetSeeder {
  @Autowired private PetTypeRepository petTypeRepository;
  @Autowired private PetRepository petRepository;

  public void seed() {
    List<String> nameList = Arrays.asList("Fiona","Midnight","Mimosa","Merlot","Shadow","Cooper","Felix","Pon Rerlman");
    List<String> petImgUrlList = Arrays.asList("/img/pets/Fiona_01_450x600.png","/img/pets/Midnight_01_450x600.jpg","/img/pets/Mimosa_01_450x600.jpg","/img/pets/Merlot_01_450x600.jpg","/img/pets/Shadow_01_450x600.jpg","/img/pets/Cooper_01_450x600.jpg","/img/pets/Felix_01_450x600.jpg","/img/pets/Pon-Rerlman_01_450x600.jpg");
    List<String> ageList = Arrays.asList("12|2","20|0","1|4","2|3","1|10","0|4","1185|11","421|0");
    List<Boolean> vaccinationStatusList = Arrays.asList(true,true,true,true,true,false,false,false);
    List<String> descriptionList = Arrays.asList("She's a princess.","She's a queen.","She's a ferocious cuddler.","He's a little angel.","He's handsome goofball.","Perhaps the cutest trash panda you'll ever meet!","In Soviet Russia, pet outlives you!","A TacoMonkey, what more can you ask for?");
    List<String> adoptionStoryList = Arrays.asList("Fiona is a cute and sleepy ball of fluff and cuddles. She deserves a good home!","Midnight is fabulous and photogenic. If you're looking for the next #meowdel, look no further!","Mimosa loves to sleep and play. She is feisty and has a super cute, kittenesque face!","Merlot is an extremely affectionate kitty that loves to cuddle. Be prepared to have your heart captured!","Boundless energy and joy accompanies this puppy! If you want a hiking buddy, then Shadow is the pup for you!","Cooper is a cute little fluffball with claws. He loves cheese and Cheetos!","Believed to only be on this 3rd life, Felix is quite young. Felix the phoenix is guaranteed to bring light and joy into your life for generations!","Pon Rerlman, sometimes known as Pon Pon, is the life of the party. He will steal your heart and your tacos!");
    List<Boolean> adoptionStatusList = Arrays.asList(false,false,false,false,false,false,false,false);
    List<Integer> petTypeIdList = Arrays.asList(5,1,2,1,4,6,8,10);
    List<PetType> petTypes = Lists.newArrayList(petTypeRepository.findAll());

    for (int i = 0; i < nameList.size(); i++) {
      if(!petRepository.existsByName(nameList.get(i))) {
        Pet pet = new Pet();
        pet.setName(nameList.get(i));
        pet.setPetImgUrl(petImgUrlList.get(i));
        pet.setAge(ageList.get(i));
        pet.setVaccinationStatus(vaccinationStatusList.get(i));
        pet.setDescription(descriptionList.get(i));
        pet.setAdoptionStory(adoptionStoryList.get(i));
        pet.setAdoptionStatus(adoptionStatusList.get(i));
        pet.setPetType(petTypes.get(petTypeIdList.get(i)-1));
        petRepository.save(pet);
      }
    }
  }
}
