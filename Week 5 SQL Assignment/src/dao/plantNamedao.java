package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Name;

public class plantNamedao {
	private Connection connection;
	private final String GET_PLANTS_QUERY = "SELECT * FROM plantname";
	private final String GET_PLANT_BY_ID_QUERY = "SELECT * FROM plantname WHERE id = ?";
	private final String CREATE_NEW_PLANT_QUERY = "INSERT INTO plantname(name) VALUES(?)";
	private final String DELETE_PLANT_BY_TYPE_QUERY = "DELETE FROM plantname WHERE id = ?";
	
	
	public plantNamedao() {
		connection = dbConnection.getConnection(); 
	}
	
	public List<Name> getPlants() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_PLANTS_QUERY).executeQuery();
		List<Name> plant = new ArrayList<Name>();
		
		while (rs.next()) {
			plant.add(populatePlant(rs.getInt(1), rs.getString(2)));
		}
		
		return plant;
	}
	
	public Name getPlantById(int pieId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLANT_BY_ID_QUERY);
		ps.setInt(1, pieId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePlant(rs.getInt(1), rs.getString(2)); 
	}
	
	public void createNewPlant(String plantType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PLANT_QUERY);
		ps.setString(1, plantType);
		ps.executeUpdate();
	}
	
	public void deletePlantById(int plantId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLANT_BY_TYPE_QUERY);
		ps.setInt(1, plantId);
		ps.executeUpdate();
	}
	
	private Name populatePlant(int plantId, String plantType) {
		return new Name(plantId, plantType); 
	}


	}



	

	
	

