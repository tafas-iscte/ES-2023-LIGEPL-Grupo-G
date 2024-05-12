package pt.iscte.gestao_de_horarios;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class SalasReader {
	
	    public static List<Sala> carregarSalas(File file) {
	        List<Sala> salas = new ArrayList<>();
	        String linha;
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            while ((linha = br.readLine()) != null) {
	            	
	                String[] dados = linha.split(";"); // Assume que a vírgula é o delimitador
	                
	                String[] dataWorked = new String[35];
	                
	                for(int i = 0; i < dados.length; i++) {
	                	dataWorked[i] = dados[i];
	                }
	               
	                	Sala sala = new Sala(dataWorked[0], dataWorked[1], dataWorked[2], dataWorked[3], dataWorked[4], dataWorked[5], dataWorked[6], dataWorked[7], dataWorked[8], dataWorked[9], dataWorked[10],dataWorked[11], dataWorked[12], dataWorked[13], dataWorked[14], dataWorked[15], dataWorked[16], dataWorked[17], dataWorked[18], dataWorked[19], dataWorked[20], dataWorked[21],dataWorked[22], dataWorked[23], dataWorked[24], dataWorked[25], dataWorked[26], dataWorked[27], dataWorked[28], dataWorked[29], dataWorked[30], dataWorked[31], dataWorked[32],dataWorked[33], dataWorked[34]);
	                	salas.add(sala);
	                
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return salas;
	    }
	    
	    
	    public static void main(String Args[]) {
	    	 String folderPath = "C:\\Users\\tiago\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads";

	         // Create a File object representing the folder
	         File folder = new File(folderPath);
	         while (true) {

	             // Check if the folder exists
	             if (folder.exists() && folder.isDirectory()) {
	                 // Get the list of files and directories inside the folder
	                 File[] files = folder.listFiles();

	                 // Check if the array is not null and has elements
	                 if (files != null && files.length > 0) {
	                     SalasReader file = new SalasReader();
	                     String jsonFileName = file.convertToJson(files[0]);
	                 } else {
	                     System.out.println("The folder is empty.");
	                 }
	             } else {
	                 System.out.println("The specified folder does not exist or is not a directory.");
	             }
	         }
	    }
	    
	    void openBrowserWindow(String url) throws FileNotFoundException {
	        try {
	            Desktop.getDesktop().browse(java.net.URI.create(url));
	        }catch(NullPointerException e) {
                e.printStackTrace();
                throw new NullPointerException();
            }catch (IOException e) {
	            e.printStackTrace();
	            throw new FileNotFoundException();
            }
            
	    }
	    
	    
	    
	    
	    public String convertToJson(File file) {
	    	
	        List<Sala> salas = carregarSalas(file);
	        // Fazer algo com a lista de horários
	        
	       /* for(Horario h: horarios) {
	        	System.out.println(h);
	        }*/
	        
	        
	        Gson gson = new Gson();
	        String salasJson = gson.toJson(salas);
	        String name = "salas.json";
	        // Save the JSON string to a file
	        try (FileWriter fileWriter = new FileWriter("public/" + name)) {
	            fileWriter.write(salasJson);
	            System.out.println("escreveu");
	            return name;
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
	        return name;
    }
	    
	    
	   /* public static void salasToCsv(List<Sala> salas, String filePath) {
            try (FileWriter writer = new FileWriter(filePath)) {
                // Escrever o cabeçalho do CSV
                writer.write("Edificio,NomeSala,CapacidadeNormal,CapacidadeExame,NumeroCaracteristicas,AnfiteatroAulas,ApoioTecnicoEventos,Arq1,Arq2,Arq3,Arq4,Arq5,Arq6,Arq9,Byod,FocusGroup,HorariosSalasPortalPublico,LaboratorioArq1,LaboratorioArq2,LaboratorioEng,LaboratorioEletro,LaboratorioInfor,LaboratorioJorna,LaboratorioRedes1,LaboratorioRedes2,LaboratorioTelec,Mestrado,MestradoPlus,Nee,Provas,Reunioes,Arquitetura,Normal,Videoconferencia,Trio\n");

                // Iterar sobre cada sala na lista
                for (Sala sala : salas) {
                    // Escrever a linha CSV correspondente à sala atual
                    writer.write(sala.toCsv() + "\n");
                }
                System.out.println("CSV gerado com sucesso em: " + filePath);
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
                e.printStackTrace();
            }
        }*/
}

