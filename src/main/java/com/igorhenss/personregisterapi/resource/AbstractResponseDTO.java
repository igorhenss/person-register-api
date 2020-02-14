package com.igorhenss.personregisterapi.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public abstract class AbstractResponseDTO {
	
	@JsonProperty("creation_timestamp")
	private LocalDateTime createdTimestamp;
	
	@JsonProperty("last_update_timestamp")
	private LocalDateTime updatedTimestamp;
	
	public AbstractResponseDTO() {}
	
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	
	public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	
}
