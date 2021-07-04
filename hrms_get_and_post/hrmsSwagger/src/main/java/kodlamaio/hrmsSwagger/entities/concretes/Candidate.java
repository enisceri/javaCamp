package kodlamaio.hrmsSwagger.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@AllArgsConstructor

public class Candidate extends User{
	
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	*/
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nat_id")
	private String natId;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "birth_date", columnDefinition = "DATE")
	private Date birthDate;
    
    /*
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="cdate", columnDefinition="TIME WITHOUT TIME ZONE")
	private OffsetDateTime cdate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="udate", columnDefinition="TIME WITHOUT TIME ZONE")
	private OffsetDateTime udate;
	*/

}
