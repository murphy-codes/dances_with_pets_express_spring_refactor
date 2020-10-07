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
import javax.validation.constraints.Email;

@Entity
@Table(name="adoption_applications")
@Getter
@Setter
@NoArgsConstructor
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name="adoption_application_generator", sequenceName="adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="adoption_application_generator")
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

  @NotNull(message = "Please input a home status")
  @NotBlank(message = "Home status cannot be blank")
  @Size(max=5)
  @Column(name="home_status", nullable=false)
  private String homeStatus;

  @NotNull(message = "Please input a application status")
  @NotBlank(message = "Application status cannot be blank")
  @Size(max=8)
  @Column(name="application_status", nullable=false)
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name="pet_id", nullable = false)
  @JsonIgnoreProperties
  private Pet pet;

  public void setPet(Pet pet) { this.pet = pet; }
}
