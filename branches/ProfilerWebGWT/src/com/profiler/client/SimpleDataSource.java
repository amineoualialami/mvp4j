package com.profiler.client;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.profiler.shared.UserGWT;


public class SimpleDataSource implements TableDataSource{
	
	private String[] headers;
	private String[][] data;
	
//	public SimpleDataSource(UserGWT[] users) {
//         
//		//ici on peut utiliser la reflection pour recuperer les fields de l'object User qui doit etre de type Object
//		String[] headers = {"Nom","Profil","Phone","Mail"};
//		this.headers=headers;
//		
//		this.data=new String[users.length][4];{
//            for(int i = 0;i<users.length; i++){
//            	UserGWT user = users[i];
//            	this.data[i][0] = user.getName();
//            	//this.data[i][1] = user.getProfil().toString();
//            	this.data[i][2] = user.getPhone().toString();
//            	this.data[i][3] = user.getMail();
//            	
//            }
//		}
//	}
	
	public SimpleDataSource(List<UserGWT> users) {
        
		//ici on peut utiliser la reflection pour recuperer les fields de l'object User qui doit etre de type Object
		String[] headers = {"Nom","Profil","Phone","Mail"};
		this.headers=headers;
		if(users==null){
			Log.info("users is null");
		}
		else{
			Log.info("users is not null");
		this.data=new String[users.size()][4];{
            for(int i = 0;i<users.size(); i++){
            	UserGWT user = users.get(i);
            	this.data[i][0] = user.getName();
//            	this.data[i][1] = user.getProfil().toString();
            	this.data[i][1] = "nothing";
            	this.data[i][2] = user.getPhone().toString();
            	this.data[i][3] = user.getMail();
            	
            }
		}
		for(int i=0; i<data.length;i++){
			Log.info("name : " +data[i][0]+ "phone : "+data[i][2]+" mail : "+data[i][3]);
		}
		}
	}

	@Override
	public String[] getHeaderRow() {
		return headers;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public String[] getRow(int row) {
		return data[row];
	}

}
