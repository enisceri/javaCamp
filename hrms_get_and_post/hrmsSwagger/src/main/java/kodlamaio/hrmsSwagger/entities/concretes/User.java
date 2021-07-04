package kodlamaio.hrmsSwagger.entities.concretes;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="msisdn")
	private String msisdn;
	
	@Column(name="password")
	private String password;
	
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="cdate", columnDefinition="TIME WITHOUT TIME ZONE")
	private OffsetDateTime cdate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="udate", columnDefinition="TIME WITHOUT TIME ZONE")
	private OffsetDateTime udate;
    


}
