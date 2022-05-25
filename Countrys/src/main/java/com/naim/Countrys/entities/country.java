package com.naim.Countrys.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class country {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCountry;

@NotNull
@Size (min = 4,max = 15)
private String nomCountry;

public city getCity() {
	return city;
}
public void setCity(city city) {
	this.city = city;
}


@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateAjout;

@ManyToOne
private city city;
public country() {
super();
}


public Date getDateAjout() {
return dateAjout;
}
public void setDateAjout(Date dateAjout) {
this.dateAjout = dateAjout;
}
public Long getIdCountry() {
	return idCountry;
}
public void setIdCountry(Long idCountry) {
	this.idCountry = idCountry;
}


public String getNomCountry() {
	return nomCountry;
}
public void setNomCountry(String nomCountry) {
	this.nomCountry = nomCountry;
}
@Override
public String toString() {
	return "country [idCountry=" + idCountry + ", nomCountry=" + nomCountry + ", dateAjout=" + dateAjout + ", city="
			+ city + "]";
}


}
