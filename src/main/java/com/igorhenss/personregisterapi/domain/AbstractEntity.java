package com.igorhenss.personregisterapi.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

public class AbstractEntity {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private UUID id = UUID.randomUUID();
	
	@Column(name = "created_timestamp", nullable = false)
	private LocalDateTime createdTimestamp = LocalDateTime.now();
	
	@Column(name = "updated_timestamp", nullable = false)
	private LocalDateTime updatedTimestamp = LocalDateTime.now();
	
	protected AbstractEntity() {}
	
	protected void update() {
		this.updatedTimestamp = LocalDateTime.now();
	}
	
	public UUID getId() {
		return id;
	}
	
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	
}
