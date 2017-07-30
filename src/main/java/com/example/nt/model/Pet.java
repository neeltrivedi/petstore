package com.example.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {

	@Id
	@GeneratedValue
    private Long id;

    private String name;
    private String photourl;
    private String status;
  //  private PetCategory category;
    public Pet() {

    }

    public String getPhotoUrl() {
		return photourl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photourl = photoUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public PetCategory getCategory() {
//		return category;
//	}
//
//	public void setCategory(PetCategory category) {
//		this.category = category;
//	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String text) {
        this.name = text;
    }

}