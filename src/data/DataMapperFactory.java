package data;

public class DataMapperFactory {
	private static DataMapper dataMapper = new DataMapper();
	
	public static DataMapper getDataMapper() {
		return dataMapper;
	}
}
