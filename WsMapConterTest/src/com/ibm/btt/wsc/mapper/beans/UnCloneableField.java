package com.ibm.btt.wsc.mapper.beans;

import java.util.UUID;

public class UnCloneableField {
	private UUID uuid = UUID.randomUUID();

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String toString() {
		return uuid.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof UnCloneableField))
			return false;

		return uuid.equals(((UnCloneableField) o).getUuid());
	}
}
