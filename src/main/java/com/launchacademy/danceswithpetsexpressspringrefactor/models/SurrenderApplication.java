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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="surrender_applications")
@Getter
@Setter
@NoArgsConstructor
public class SurrenderApplication {
  @Id
  @SequenceGenerator(name="surrender_application_generator", sequenceName="surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="surrender_application_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull(message = "Please input a name")
  @NotBlank(message = "Names cannot be blank")
  @Size(max=50)
  @Column(name="name", nullable=false)
  private String name;

  @NotNull(message = "Please input a phone number")
  @NotBlank(message = "Phone numbers cannot be blank")
  @Size(max=20)
  @Column(name="phone_number", nullable=false)
  private String phoneNumber;

  @NotNull(message = "Please input a email")
  @NotBlank(message = "Emails cannot be blank")
  @Email
  @Column(name="email", nullable=false)
  private String email;

  @NotNull(message = "Please input a pet name")
  @NotBlank(message = "Pet names cannot be blank")
  @Size(max=50)
  @Column(name="pet_name", nullable=false)
  private String petName;

  @NotNull(message = "Please input a url for this pet's photo")
  @NotBlank(message = "Photo URLs cannot be blank")
  @URL(message = "The photo URL must be a valid URL")
  @Column(name="pet_img_url", nullable=false)
  private String petImgUrl;

  @NotNull(message = "Please input a pet age")
  @NotBlank(message = "Pet ages cannot be blank")
  @Size(max=12, message = "Pet age is too large")
  @Column(name="pet_age", nullable=false)
  private String petAge;

  @NotNull(message = "You must designate a vaccination status")
  @Column(name="vaccination_status", nullable=false)
  private Boolean vaccinationStatus;

  @Column(name="description")
  private String description;

  @NotNull(message = "Please input an adoption story")
  @NotBlank(message = "Adoption stories cannot be blank")
  @Column(name="adoption_story", nullable=false)
  private String adoptionStory;

  @NotNull(message = "Please input a application status")
  @NotBlank(message = "Application status cannot be blank")
  @Size(max=8)
  @Column(name="application_status", nullable=false)
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name="pet_type_id", nullable = false)
  private PetType petType;

  public void setPetType(PetType petType) { this.petType = petType; }
}
