package com.app.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sub_sub_categories")
@NoArgsConstructor
@Getter
@Setter
public class SubSubCategory extends BaseEntity{

  @Column(name="name",length = 20,unique = true)
  private String subSubCatName;

}