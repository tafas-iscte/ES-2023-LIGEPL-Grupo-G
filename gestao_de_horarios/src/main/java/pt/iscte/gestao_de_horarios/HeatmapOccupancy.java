package pt.iscte.gestao_de_horarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HeatmapOccupancy {

    private static List<Horario> horarios; // Lista para armazenar os horários carregados

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Carregar o horário inicialmente
            horarios = CsvReader.carregarHorario(new File("C:\\\\Users\\\\guede\\\\Desktop\\\\GitHub\\\\ES-2023-LIGEPL-Grupo-G\\\\gestao_de_horarios\\\\uploads\\\\HorarioDeExemplo2.csv"));
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Mapa de Ocupação das Salas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel controlPanel = createControlPanel();
        JPanel heatmapPanel = new JPanel(); // Painel para exibir o mapa de calor

        frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
        frame.getContentPane().add(heatmapPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();

        // Adiciona um rótulo para o filtro de data de início
        JLabel startDateLabel = new JLabel("Data de Início:");
        controlPanel.add(startDateLabel);

        // Adiciona um campo de texto para a data de início
        JTextField startDateField = new JTextField(10);
        startDateField.setText("01/03/2024"); // Data de exemplo
        controlPanel.add(startDateField);

        // Adiciona um rótulo para o filtro de data de fim
        JLabel endDateLabel = new JLabel("Data de Fim:");
        controlPanel.add(endDateLabel);

        // Adiciona um campo de texto para a data de fim
        JTextField endDateField = new JTextField(10);
        endDateField.setText("13/05/2024"); // Data de exemplo
        controlPanel.add(endDateField);

        // Adiciona um botão para gerar o mapa de calor
        JButton generateButton = new JButton("Gerar Mapa de Calor");
        generateButton.addActionListener(e -> {
            LocalDate startDate = LocalDate.parse(startDateField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate endDate = LocalDate.parse(endDateField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            generateHeatmap(startDate, endDate);
        });
        controlPanel.add(generateButton);

        return controlPanel;
    }

    private static void generateHeatmap(LocalDate startDate, LocalDate endDate) {
        // Gera um mapa de calor de ocupação das salas com base nos horários carregados
        SalaOccupancyHeatmap heatmap = new SalaOccupancyHeatmap(horarios, startDate, endDate);
    }
}