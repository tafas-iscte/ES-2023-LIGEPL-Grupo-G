package pt.iscte.gestao_de_horarios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class CsvReaderTest {

	@Test
	void testFile() throws IOException {
		CsvReader csv = new CsvReader();
		File f = new File("C:\\Users\\tiago\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\HorarioDeExemplo.csv");
		assertEquals("horarios.json", csv.convertToJson(f));
	}
	
	@Test
	void testNullFile() {
		CsvReader csv = new CsvReader();
		File f = null;
		assertThrows(NullPointerException.class, () -> CsvReader.carregarHorario(f));
		
	}
	
	@Test
	void testNonExistingFile() {
		CsvReader csv = new CsvReader();
		File f = new File("C:\\Users\\tiago\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\HorarioDeExempl.csv");
		assertThrows(FileNotFoundException.class, () -> CsvReader.carregarHorario(f));
		
	}
}