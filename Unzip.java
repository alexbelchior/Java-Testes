//Método contido dentro de um projeto, não funciona isoladamente

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void unzip2(String filePath){
		
			try{
				ZipInputStream in = new ZipInputStream (new BufferedInputStream(new FileInputStream(filePath)));
				ZipEntry entry = null;
				ZipFile zip = null;
				File zipFile = new File(filePath);
				File arquivo = null;
				String nome_original = null;
				while((entry = in.getNextEntry()) != null){
					int count;
					int buffer = 2048;
					byte data[] = new byte[buffer];
					
					zip = new ZipFile(zipFile);
					Enumeration e = zip.entries();
					while(e.hasMoreElements()){ 
						ZipEntry entrada = (ZipEntry) e.nextElement();
						nome_original = entrada.getName();//guardo o nome original do arquivo que está dentro do zip (FATURA.txt ou FATURA_2.txt)
						arquivo = new File(getPropertiesKey("arq_mailing"), "temp_" + entrada.getName());//Descompactação do arquivo zip com "temp_" no ínicio do nome do arquivo original (temp_FATURA.txt ou temp_FATURA_2.txt)
					}
					FileOutputStream out = new FileOutputStream(arquivo);
					while ((count = in.read(data,0,buffer)) != -1){
						out.write(data,0,count);
					}
					
					/**
					 * 
					 * 
					 * 
					 */
					Logger.getLogger(Util.class).info("----------------------------------");
					Logger.getLogger(Util.class).info("Descompactou " + filePath);
					
					File arquivo_sem_espaco = new File(getPropertiesKey("arq_mailing") + "/" + nome_original);//Criação do arquivo com o nome original (FATURA.txt ou FATURA_2.txt), que receberá o conteúdo do texto sem espaços em branco no final de cada linha
					BufferedReader input = new BufferedReader(new FileReader(arquivo));//
					FileWriter data2 = new FileWriter(arquivo_sem_espaco);//
					String line = "";//
					while((line = input.readLine()) != null){//
						data2.write(line.trim()+"\r\n");//
					}//
					Logger.getLogger(Util.class).info("Criou o arquivo txt sem os espacos " + arquivo_sem_espaco.getName());
					data2.close();//
					out.flush();
					input.close();//
					out.close();
					zip.close();
					arquivo.delete();//Exclusão do arquivo "temp_FATURA.txt ou temp_FATURA_2.txt" 
					Logger.getLogger(Util.class).info("Exclusao do arquivo: temp_" + arquivo_sem_espaco.getName());
					Logger.getLogger(Util.class).info("----------------------------------");
				}
				
				in.close();
				zipFile.delete(); //Exclusão do .zip
				
		 	}
			catch(Exception e){
				e.printStackTrace();
			}

}
	
