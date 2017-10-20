package br.com.json;

import java.io.*;
import org.json.simple.JSONObject;

public class JsonEscrita {
	
	@SuppressWarnings("unchecked")
	public static void main(String[]args){
		
		//cria objeto JSON
		JSONObject jsonObject = new JSONObject();
		
		FileWriter writeFile = null;
		
		//Armazena os dados em um objeto JSON
		jsonObject.put("Nome", "Alexandre");
		jsonObject.put("Sobrenome", "Belchior");
		jsonObject.put("País", "Brasil");
		jsonObject.put("Estado", "RJ");
		
		try{
			writeFile = new FileWriter("arquivo.json");
			//Escreve no arquivo JSON
			writeFile.write(jsonObject.toJSONString());
			writeFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println(jsonObject);
		
		
	}
}
