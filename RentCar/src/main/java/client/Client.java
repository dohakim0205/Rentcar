package client;

import java.sql.Timestamp;

import client.controller.ClientDao;

public class Client {
	private String id;
	private String pw;
	private String name;
	private Timestamp registDate;

	public Client(String id, String pw, String name, Timestamp registDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.registDate = registDate;
	}
	
	public Client(ClientRequestDto clientDto) {
		ClientDao clientDao = ClientDao.getInstance();
		
		this.id = clientDto.getId();
		this.pw = clientDto.getPw();
		this.name = clientDto.getName();
		this.registDate = clientDto.getRegistDate();
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}
}
