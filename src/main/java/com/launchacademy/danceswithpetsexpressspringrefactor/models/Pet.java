package com.launchacademy.danceswithpetsexpressspringrefactor.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {
  @Id
  @SequenceGenerator(name="pet_generator", sequenceName="pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull(message = "Please input a name")
  @NotBlank(message = "Names cannot be blank")
  @Size(max=50)
  @Column(name="name", nullable=false)
  private String name;

  @NotNull(message = "Please input a url for this pet's photo")
  @NotBlank(message = "Photo URLs cannot be blank")
//  @URL(message = "The photo URL must be a valid URL")
  @Column(name="pet_img_url", nullable=false)
  private String petImgUrl;

  @NotNull(message = "Please input an age")
  @NotBlank(message = "Ages cannot be blank")
  @Size(max=12, message = "Age is too large")
  @Column(name="age", nullable=false)
  private String age;

  @NotNull(message = "You must designate a vaccination status")
  @Column(name="vaccination_status", nullable=false)
  private Boolean vaccinationStatus;

  @Column(name="description")
  private String description;

  @NotNull(message = "Please input an adoption story")
  @NotBlank(message = "Adoption stories cannot be blank")
  @Column(name="adoption_story", nullable=false)
  private String adoptionStory;

  @NotNull(message = "You must designate an adoption status")
  @Column(name="adoption_status", nullable=false)
  private Boolean adoptionStatus;

  @ManyToOne
  @JoinColumn(name="pet_type_id", nullable = false)
  @JsonIgnoreProperties("pets")
  private PetType petType;

  public void setPetType(PetType petType) { this.petType = petType; }

  @OneToMany(mappedBy = "pet")
  @JsonIgnoreProperties
  private List<AdoptionApplication> adoptionApplications = new ArrayList<>();
}