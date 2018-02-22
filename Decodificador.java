import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.swing.JOptionPane;

//Decodifica base 64 para arquivo zip

public class Decodificador {

	public static void main(String[] args) throws IOException {
		
		String arquivo64 = javax.swing.JOptionPane.showInputDialog("digite aqui");
		
		/* Testar encode 64
		File originalFile = new File("c:/xmlbvp/original.zip");
		String encodedBase64 = null;
		try {
		    FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
		    byte[] bytes = new byte[(int)originalFile.length()];
		    fileInputStreamReader.read(bytes);
		    encodedBase64 = new String(Base64.getEncoder().encode(bytes));
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		System.out.println(encodedBase64);
		*/
		
		File diretorio = new File("C:\\xmlbvp");
		if(!diretorio.exists()){
			diretorio.mkdir();
		}

		if(!arquivo64.isEmpty()){
				byte[] arquivoDecodificado = Base64.getDecoder().decode(arquivo64);
				System.out.println(arquivoDecodificado);

				FileOutputStream fos = new FileOutputStream("c:/xmlbvp/teste.zip");
				fos.write(arquivoDecodificado);
				fos.close();
		}else {
			JOptionPane.showMessageDialog(null, "Por favor digite algo, o campo não pode estar em branco");
		}


	}

}
