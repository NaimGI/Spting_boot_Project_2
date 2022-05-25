package com.naim.Countrys.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class city {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCity;
private String nomCity;
private String descriptionCity;
@JsonIgnore
@OneToMany(mappedBy = "city")
private List<country> countrys;
public city() {
	}

public city(String nomCity, String descriptionCity, List<country> countrys) {
	super();
	this.nomCity = nomCity;
	this.descriptionCity = descriptionCity;
	this.countrys = countrys;
}


public Long getIdCity() {
	return idCity;
}

public void setIdCity(Long idCity) {
	this.idCity=idCity;
}
public String getNomCity() {
	return nomCity;
}
public void setNomCity(String nomCity) {
	this.nomCity=nomCity;
}
public String getDescriptionCity() {
	return descriptionCity;
	
}
public void setDescriptionCity(String descriptionCity) {
	this.descriptionCity=descriptionCity;
}

@Override
public String toString() {
	return "city [idCity=" + idCity + ", nomCity=" + nomCity + ", descriptionCity=" + descriptionCity + ", countrys="
			+ countrys + "]";
}





}
