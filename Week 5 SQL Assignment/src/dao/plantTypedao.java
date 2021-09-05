package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Type;


public class plantTypedao {
	private Connection connection;
	private plantNamedao plantNameDao;
	private final String GET_TYPES_QUERY = "select * from planttypes";
	private final String GET_TYPE_BY_ID_QUERY = "select * from planttypes where id = ?";
	public plantTypedao() {
		connection = dbConnection.getConnection();
	}
	
	private Type populateTypes(int plantTypeId, String type) throws SQLException {
		
		return new Type(plantTypeId, type, plantNameDao.getNamesByTypeId(plantTypeId));
	}

	public List<Type> getTypes() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TYPES_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Type> types = new ArrayList<Type>();
		
		
		while (rs.next()) {
			types.add(populateTypes(rs.getInt(1), rs.getString(2)));
			
		}
		return types;    
	}

	public Type getTypeById(int plantTypeId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TYPE_BY_ID_QUERY);
		ps.setInt(1, plantTypeId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTypes(rs.getInt(1), rs.getString(2));
	}
	

}
