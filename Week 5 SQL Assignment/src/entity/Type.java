package entity;

import java.util.List;

public class Type {
	
	private int plantTypeId;
	private String type;
	private List<Name> names;
	
	public Type(int plantTypeId, String type, List<Name> names) {
		this.setPlantTypeId(plantTypeId);
		this.setType(type);
		this.setNames(names);
	}

	public int getPlantTypeId() {
		return plantTypeId;
	}

	public void setPlantTypeId(int plantTypeId) {
		this.plantTypeId = plantTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Name> getNames() {
		return names;
	}

	public void setNames(List<Name> names) {
		this.names = names;
	}
	
	
}
