package com.launchacademy.danceswithpetsexpressspringrefactor.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="pet_types")
public class PetType {
  @Id
  @SequenceGenerator(name="pet_type_generator", sequenceName="pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_type_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull(message = "Please input a classification")
  @NotBlank(message = "Classifications cannot be blank")
  @Size(max=50)
  @Column(name="classification", nullable=false)
  private String classification;

  @NotNull(message = "Please input a type")
  @NotBlank(message = "Types cannot be blank")
  @Size(max=50)
  @Column(name="type", nullable=false)
  private String type;

  @NotNull(message = "Please input a breed")
  @NotBlank(message = "Breeds cannot be blank")
  @Size(max=50)
  @Column(name="breed", nullable=false, unique=true)
  private String breed;

  @NotNull(message = "Please input a url for this breed's photo")
  @NotBlank(message = "Photo URLs cannot be blank")
  @URL(message = "The photo URL must be a valid URL")
  @Column(name="breed_img_url", nullable=false)
  private String breedImgUrl;

  @Column(name="description")
  private String description;

  @OneToMany(mappedBy = "pet_type")
  private List<Pet> pets = new ArrayList<>();
}
