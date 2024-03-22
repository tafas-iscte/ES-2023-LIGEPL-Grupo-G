package pt.iscte.gestao_de_horarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CsvReader {
	    public static List<Horario> carregarHorario(File file) {
	        List<Horario> horarios = new ArrayList<>();
	        String linha;
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            while ((linha = br.readLine()) != null) {
	            	
	                String[] dados = linha.split(";"); // Assume que a vírgula é o delimitador
	                
	                String[] dataWorked = new String[11];
	                
	                for(int i = 0; i < dados.length; i++) {
	                	dataWorked[i] = dados[i];
	                }
	               
	                	Horario horario = new Horario(dataWorked[0], dataWorked[1], dataWorked[2], dataWorked[3], dataWorked[4], dataWorked[5], dataWorked[6], dataWorked[7], dataWorked[8], dataWorked[9], dataWorked[10]);
	                	horarios.add(horario);
	                
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return horarios;
	    }
	    
	/*    public static void main(String[] args) {
	        // Caminho para o ficheiro CSV local
	        String caminhoFicheiro = "C:\\Users\\tiago\\Downloads\\HorarioDeExemplo.csv";
	        List<Horario> horarios = carregarHorario(caminhoFicheiro);
	        // Fazer algo com a lista de horários
	        
	        for(Horario h: horarios) {
	        	System.out.println(h);
	        }
	        
	        
	        Gson gson = new Gson();
	        String horariosJson = gson.toJson(horarios);

	        // Save the JSON string to a file
	        try (FileWriter fileWriter = new FileWriter("horarios.json")) {
	            fileWriter.write(horariosJson);
	            System.out.println("escreveu");
	        } catch (IOException e) {
	            e.printStackTrace();
	    } */
	        
	        
	    public String convertToJson(File file) {
	    	
		        List<Horario> horarios = carregarHorario(file);
		        // Fazer algo com a lista de horários
		        
		       /* for(Horario h: horarios) {
		        	System.out.println(h);
		        }*/
		        
		        
		        Gson gson = new Gson();
		        String horariosJson = gson.toJson(horarios);
		        String name = "horarios.json";
		        // Save the JSON string to a file
		        try (FileWriter fileWriter = new FileWriter("public/" + name)) {
		            fileWriter.write(horariosJson);
		            System.out.println("escreveu");
		        } catch (IOException e) {
		            e.printStackTrace();
		    }
		        return name;
	    }
}

