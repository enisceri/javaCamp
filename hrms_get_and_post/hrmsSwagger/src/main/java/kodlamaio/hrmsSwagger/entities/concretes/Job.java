package kodlamaio.hrmsSwagger.entities.concretes;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@NoArgsConstructor
@AllArgsConstructor
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int id;
	
	@Column(name="job_name")
	private String name;
	
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="cdate", columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private OffsetDateTime cdate;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="udate", columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private OffsetDateTime udate;


}
