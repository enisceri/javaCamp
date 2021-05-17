package kodlamaio.hrms.entities.concretes;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class Job {
	
	@Id
	@GeneratedValue
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
    
    public Job()
    {
    	
    }

	public Job(int id, String name, OffsetDateTime cdate, OffsetDateTime udate) {
		super();
		this.id = id;
		this.name = name;
		this.cdate = cdate;
		this.udate = udate;
	}
    

	

}
