package pt.iscte.gestao_de_horarios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SalasReaderTest {
	@Test
	void testFile() throws IOException {
		SalasReader sala = new SalasReader();
		File f = new File("C:\\Users\\guede\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\CaracterizacaoDasSalas.csv");
		assertEquals("salas.json", sala.convertToJson(f));
	}
	@Test
	void testNullFile() {
		SalasReader sala = new SalasReader();
		File f = null;
		assertThrows(NullPointerException.class, () -> SalasReader.carregarSalas(f));
		
	}
	@Test
	void testNonExistingFile() {
		SalasReader sala = new SalasReader();
		File f = new File("C:\\Users\\guede\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\HorarioDeExemp.csv");
		assertThrows(FileNotFoundException.class, () -> SalasReader.carregarSalas(f));
		
	}
	@Test
	void testNullFileBrowser() {
		SalasReader sala = new SalasReader();
		File f = null;
		assertThrows(NullPointerException.class, () -> SalasReader.openBrowserWindow(f));
		
	}
	@Test
	void testNonExistingFileBrowser() {
		SalasReader sala = new SalasReader();
		File f = new File("C:\\Users\\guede\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\HorarioDeExemp.csv");
		assertThrows(FileNotFoundException.class, () -> SalasReader.openBrowserWindow(f));
		
	}

}
