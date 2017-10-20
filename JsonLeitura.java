package br.com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonLeitura {

	public static void main(String[] args) {
		
		JSONObject jsonObject;
		
		//cria o parse de tratamento
		JSONParser parser = new JSONParser();
		
		//variaveis que irão armazenar os dados do arquivo JSON
		
		String nome;
		String sobrenome;
		String estado;
		String pais;
		
		try{
			//salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader("arquivo.json"));
			
			//Salva nas variaveis os dados retirados do arquivo
			nome = (String) jsonObject.get("Nome");
			sobrenome = (String) jsonObject.get("Sobrenome");
			estado = (String) jsonObject.get("Estado");
			pais = (String) jsonObject.get("País");
			
			System.out.printf("Nome: %s\nSobrenome: %s\nEstado: %s\nPais: %s\n" , nome, sobrenome, estado, pais);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ParseException e){
			e.printStackTrace();
		}
	}

}
