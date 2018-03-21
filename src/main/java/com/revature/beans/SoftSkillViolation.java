package com.revature.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class SoftSkillViolation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCREENING_SEQUENCE")
	@SequenceGenerator(name="SCREENING_SEQUENCE",sequenceName="SCREENING_SEQUENCE")
	@Column(name="SCREENING_ID")
	private Integer softSkillVioationId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private Integer screeningId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VIOLATION_TYPE_ID")
	private Integer violationTypeId;
	
	@Column(name="TIME")
	private Date time;
	
	@Column(name="COMMENT")
	private String comment;

	public SoftSkillViolation() {
		super();
	}

	public SoftSkillViolation(Integer softSkillVioationId, Integer screeningId, Integer violationTypeId, Date time,
			String comment) {
		super();
		this.softSkillVioationId = softSkillVioationId;
		this.screeningId = screeningId;
		this.violationTypeId = violationTypeId;
		this.time = time;
		this.comment = comment;
	}

	public Integer getSoftSkillVioationId() {
		return softSkillVioationId;
	}

	public void setSoftSkillVioationId(Integer softSkillVioationId) {
		this.softSkillVioationId = softSkillVioationId;
	}

	public Integer getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}

	public Integer getViolationTypeId() {
		return violationTypeId;
	}

	public void setViolationTypeId(Integer violationTypeId) {
		this.violationTypeId = violationTypeId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "SoftSkillViolation [softSkillVioationId=" + softSkillVioationId + ", screeningId=" + screeningId
				+ ", violationTypeId=" + violationTypeId + ", time=" + time + ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
		result = prime * result + ((softSkillVioationId == null) ? 0 : softSkillVioationId.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((violationTypeId == null) ? 0 : violationTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftSkillViolation other = (SoftSkillViolation) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (softSkillVioationId == null) {
			if (other.softSkillVioationId != null)
				return false;
		} else if (!softSkillVioationId.equals(other.softSkillVioationId))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (violationTypeId == null) {
			if (other.violationTypeId != null)
				return false;
		} else if (!violationTypeId.equals(other.violationTypeId))
			return false;
		return true;
	}

}
