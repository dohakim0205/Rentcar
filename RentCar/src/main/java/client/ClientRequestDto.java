package client;

import java.sql.Timestamp;

public class ClientRequestDto {
	private String id;
	private String pw;
	private String name;
	private Timestamp registDate;

	public ClientRequestDto(String id, String pw, String name, Timestamp registDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.registDate = registDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}
}
