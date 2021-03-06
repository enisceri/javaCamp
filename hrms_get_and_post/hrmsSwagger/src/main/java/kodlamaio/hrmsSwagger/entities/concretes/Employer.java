package kodlamaio.hrmsSwagger.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employers")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends User{

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;
	
}
