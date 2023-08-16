package com.app.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sub_categories")
@NoArgsConstructor
@Getter
@Setter
public class SubCategory  extends BaseEntity{

  @Column(name="name",length = 20,unique = true)
  private String subCatName;
  
  @OneToMany
  @JoinColumn(name="sub_sub_category_id")
  private List<SubSubCategory> subSubCategory;
}