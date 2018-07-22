package guru.springframework.properties.examplebeans;

public class FakeDataSource {
	
	private String username;
	private String password;
	private String dbUrl;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	@Override
	public String toString() {
		return "FakeDataSource [username=" + username + ", password=" + password + ", dbUrl=" + dbUrl + "]";
	}
}
