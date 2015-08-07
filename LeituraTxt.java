import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class LeituraTxt {

	public static void main(String[] args) {
		
		File novo = new File("data2.txt");
		File data = new File("C:/workspace/Alexandre/Alura/AluraPrimeirosPassosComJava/src/boletoteste.txt");
		try{

		BufferedReader input = new BufferedReader(new FileReader(data));
		FileWriter data2 = new FileWriter(novo);
		String line = "";
		char pegaChar;
		while((line = input.readLine()) != null){
			pegaChar = line.charAt(line.length()-1);
			String valida = String.valueOf(pegaChar);
			//verifica se a variavel valida contém o caractere "¨" e caso seja true, adiciona um espaço no lugar e pula uma linha
			if(valida.equals("¨")){
				data2.write(line.trim()+" "+"\r\n");
			}else{
				data2.write(line.trim()+"\r\n");
			}
			
		}
		data2.close();
		input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//--------------------------------------------------------------------//
		//----Rotina para pegar o último caracter                             //
		String teste = "Aahs askjdfhak jaskaoq dghaskj ahsjfha ajlf ¨";       //
		char validaTexto;                                                     //
		validaTexto = teste.charAt(teste.length()-1);                         //
		System.out.println(validaTexto);                                      //
		//--------------------------------------------------------------------//
	}

}
