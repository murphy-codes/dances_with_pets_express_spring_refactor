package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetTypeRepository;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class PetTypeSeeder {
  public void seed(PetTypeRepository petTypeRepository) {
//    List<String> classificationTypeList = Arrays.asList("domesticated","exotic","mythical");
//    List<String> classificationList = Arrays.asList(classificationTypeList.get(0),classificationTypeList.get(0),classificationTypeList.get(0),classificationTypeList.get(0),classificationTypeList.get(0),classificationTypeList.get(1),classificationTypeList.get(1),classificationTypeList.get(2),classificationTypeList.get(2),classificationTypeList.get(2));
    List<String> classificationList = Arrays.asList("domesticated","domesticated","domesticated","domesticated","domesticated","exotic","exotic","mythical","mythical","mythical");
//    List<String> typeList = Arrays.asList("cat","dog","raccoon","tiger","phoenix","dragon","taco monkey");
//    List<String> nameTypeList = Arrays.asList(typeList.get(0),typeList.get(0),typeList.get(0),typeList.get(1),typeList.get(1),typeList.get(2),typeList.get(3),typeList.get(4),typeList.get(5),typeList.get(6));
    List<String> typeList = Arrays.asList("cat","cat","cat","dog","dog","raccoon","tiger","phoenix","dragon","taco monkey");
    List<String> breedList = Arrays.asList("domestic short hair","domestic medium hair","domestic long hair","german shepherd","maltipoo","upper mississippi valley raccoon","siberian tiger","greek phoenix","slavic dragon","banana taco monkey");
    List<String> breedImgUrlList = Arrays.asList("/img/types/domestic-short-hair.jpg","/img/types/domestic-medium-hair.jpg","/img/types/domestic-long-hair.jpg","/img/types/german-shepherd.jpg","/img/types/maltipoo.jpg","/img/types/upper-mississippi-valley.jpg","/img/types/siberian-tiger.jpg","/img/types/greek-phoenix.jpg","/img/types/slavic-dragon.jpg","/img/types/taco-monkey.jpg");
    List<String> descriptionList = Arrays.asList("A cat of mixed ancestry, thus not belonging to any particular recognized cat breed, possessing a coat of short fur.","A fluffy and docile cat, the domestic medium-hair is the perfect hybrid of his domestic short- and longhair relatives.","A cat of mixed ancestry, thus not belonging to any particular recognised cat breed, possessing a coat of semi-long to long fur.","The German Shepherd is a breed of medium to large-sized working dog that originated in Germany.","The Maltipoo is a popular cross of the Maltese and Poodle, known for their fun-loving and affectionate nature.","The Procyon lotor hirtus, is an exceptionally large raccoon with a buff coat that has colonized the American Midwest.","The Siberian tiger is a tiger from a specific population of the Panthera tigris tigris subspecies that is native to the Russian Far East, Northeast China, and possibly North Korea.","A bird that can live for a long time and also be reborn from the ashes of its predecessor.","A Slavic dragon is any dragon in Slavic mythology, including the Russian zmei, the Slovak drak and sarkan, Czech drak, Polish zmij, the Serbian and Croatian zmaj, the Macedonian zmey.","The rare and ellusive taco monkey is a coveted pet amongst the Launchers. Legends say that if you catch one it'll tell you what's on a system check. The banana species of taco monkeys also eat bananas.");

    for (int i = 0; i < breedList.size(); i++) {
      if(!petTypeRepository.existsByBreed(breedList.get(i))) {
        PetType petType = new PetType();
        petType.setClassification(classificationList.get(i));
        petType.setType(typeList.get(i));
        petType.setBreed(breedList.get(i));
        petType.setBreedImgUrl(breedImgUrlList.get(i));
        petType.setDescription(descriptionList.get(i));
        petTypeRepository.save(petType);
      }
    }
  }
}