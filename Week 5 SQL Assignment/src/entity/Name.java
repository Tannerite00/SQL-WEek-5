package entity;



public class Name {
	
	private int plantNameId;
	private String name;
	
	
	public Name(int plantNameId, String name) {
		this.setPlantNameId(plantNameId);
		this.setName(name);	
	}


	public int getPlantNameId() {
		return plantNameId;
	}

	public void setPlantNameId(int plantNameId) {
		this.plantNameId = plantNameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
