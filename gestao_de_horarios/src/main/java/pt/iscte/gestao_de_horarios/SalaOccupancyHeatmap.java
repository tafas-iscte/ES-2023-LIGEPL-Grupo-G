package pt.iscte.gestao_de_horarios;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYZDataset;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SalaOccupancyHeatmap extends JFrame {

    private int[][] occupancyData;

    public SalaOccupancyHeatmap(List<Horario> horarios, LocalDate startDate, LocalDate endDate) {
        occupancyData = new int[15][7];
        generateOccupancyData(horarios, startDate, endDate);
        JFreeChart heatmapChart = createHeatmapChart();
        ChartPanel chartPanel = new ChartPanel(heatmapChart);

        setTitle("Mapa de Ocupação das Salas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(chartPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void generateOccupancyData(List<Horario> horarios, LocalDate startDate, LocalDate endDate) {
        for (Horario horario : horarios) {
            LocalDate dataAula = LocalDate.parse(horario.getData_aula(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (dataAula.isAfter(startDate.minusDays(1)) && dataAula.isBefore(endDate.plusDays(1))) {
                int dayIndex = dataAula.getDayOfWeek().getValue() - 1;
                int hourIndex = (horario.getHora_init_aula().charAt(0) - '0') * 2;
                if (horario.getHora_init_aula().charAt(3) == '3') {
                    hourIndex += 1;
                }
                occupancyData[hourIndex][dayIndex]++;
            }
        }
    }

    private JFreeChart createHeatmapChart() {
        DefaultXYDataset dataset = new DefaultXYDataset();

        for (int i = 0; i < occupancyData.length; i++) {
            for (int j = 0; j < occupancyData[i].length; j++) {
                double[][] data = {{j, i, occupancyData[i][j]}};
                dataset.addSeries("Data", data);
            }
        }

        JFreeChart chart = ChartFactory.createBubbleChart(
                "Mapa de Ocupação das Salas",
                "Dia da Semana",
                "Hora",
                (XYZDataset) dataset
        );

        return chart;
    }

    
}
