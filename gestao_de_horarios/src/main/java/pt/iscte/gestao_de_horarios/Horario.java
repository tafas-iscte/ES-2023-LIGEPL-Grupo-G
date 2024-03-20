package pt.iscte.gestao_de_horarios;

import java.util.HashMap;

public class Horario {
	private String curso;
	private String uc;
	private String Turno;
	private String Turma; 
	private String Inscritos_no_turno;
	private String Dia_da_semana; 
	private String Hora_init_aula;
	private String Hora_fim_aula;
	private String Data_aula;
	private String Caracteristicas_sala_pedida;
	private String Sala_atribuida_aula;

	public Horario(String curso, String uc, String Turno, String Turma, String Inscritos_no_turno, String Dia_da_semana, String Hora_init_aula,
			String Hora_fim_aula,
			String Data_aula,
			String Caracteristicas_sala_pedida,
			String Sala_atribuida_aula) {
		
		
		
		this.curso = curso;
		this.uc = uc;
		this.Turno = Turno;
		this.Turma = Turma;
		this.Inscritos_no_turno = Inscritos_no_turno;
		this.Dia_da_semana = Dia_da_semana;
		this.Hora_init_aula = Hora_init_aula;
		this.Hora_fim_aula = Hora_fim_aula;
		this.Data_aula = Data_aula;
		this.Caracteristicas_sala_pedida = Caracteristicas_sala_pedida;
		this.Sala_atribuida_aula = Sala_atribuida_aula;
		
	}

	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getUc() {
		return uc;
	}
	public void setUc(String uc) {
		this.uc = uc;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public String getTurma() {
		return Turma;
	}
	public void setTurma(String turma) {
		Turma = turma;
	}
	public String getInscritos_no_turno() {
		return Inscritos_no_turno;
	}
	public void setInscritos_no_turno(String inscritos_no_turno) {
		Inscritos_no_turno = inscritos_no_turno;
	}
	public String getDia_da_semana() {
		return Dia_da_semana;
	}
	public void setDia_da_semana(String dia_da_semana) {
		Dia_da_semana = dia_da_semana;
	}
	public String getHora_init_aula() {
		return Hora_init_aula;
	}
	public void setHora_init_aula(String hora_init_aula) {
		Hora_init_aula = hora_init_aula;
	}
	public String getHora_fim_aula() {
		return Hora_fim_aula;
	}
	public void setHora_fim_aula(String hora_fim_aula) {
		Hora_fim_aula = hora_fim_aula;
	}
	public String getData_aula() {
		return Data_aula;
	}
	public void setData_aula(String data_aula) {
		Data_aula = data_aula;
	}
	public String getCaracteristicas_sala_pedida() {
		return Caracteristicas_sala_pedida;
	}
	public void setCaracteristicas_sala_pedida(String caracteristicas_sala_pedida) {
		Caracteristicas_sala_pedida = caracteristicas_sala_pedida;
	}
	public String getSala_atribuida_aula() {
		return Sala_atribuida_aula;
	}
	public void setSala_atribuida_aula(String sala_atribuida_aula) {
		Sala_atribuida_aula = sala_atribuida_aula;
	}
	
	@Override 
	public String toString() {
		String str = "{Curso:" + curso +", UC:" + uc + ", Turno:" + Turno + ", Turma:" + Turma + ", InscritosNoTurno:" + Inscritos_no_turno + ", DiaDaSemana:" + Dia_da_semana + ", HoraDeInicio:" + Hora_init_aula + ", HoraFim:" + Hora_fim_aula + ", dataAula:" + Data_aula + ", caracteristicasPedidas:" + Caracteristicas_sala_pedida + ", salaAtribuida:" + Sala_atribuida_aula + ",}"; 
		
		
		
		return str;
	}
	
}

