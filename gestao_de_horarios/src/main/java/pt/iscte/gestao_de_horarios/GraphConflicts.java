package pt.iscte.gestao_de_horarios;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphConflicts {
    public static void main(String[] args) {
        // Carregar os horários a partir do ficheiro CSV
        File file = new File("C:\\Users\\guede\\Desktop\\GitHub\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads\\HorarioDeExemplo2.csv");
        List<Horario> horarios = CsvReader.carregarHorario(file);

        // Visualizar as relações de conflitualidade
        //visualizarConflitualidade(horarios);
        visualizarConflitualidade2(horarios);
    }
    
    private static void visualizarConflitualidade2(List<Horario> horarios) {
        // Criar um novo grafo
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Adicionar as aulas como nós do grafo
        List<Object> nodes = new ArrayList<>();
        Map<String, Object> nodeMap = new HashMap<>(); // Mapeia a chave de aula para o nó correspondente
        graph.getModel().beginUpdate();
        try {
        	int z=0;
            for (Horario horario : horarios) {
            	if (z!=0) {
            		String aulaKey = horario.getCurso() + "/" + horario.getUc() + "/" + horario.getTurma();
            		if (!nodeMap.containsKey(aulaKey)) {
            			Object node = graph.insertVertex(parent, null, aulaKey, 20, 20, 80, 30);
            			nodes.add(node);
            			nodeMap.put(aulaKey, node);
            		}
            		
            	}
            	z = 1;
            }

            // Adicionar as relações de conflitualidade como arestas do grafo
            for (int i = 1; i < horarios.size(); i++) {
                for (int j = i + 1; j < horarios.size(); j++) {
                    Horario aula1 = horarios.get(i);
                    Horario aula2 = horarios.get(j);
                    // Verificar se as aulas têm conflito
                    if (temConflito(aula1, aula2)) {
                        String aula1Key = aula1.getCurso() + "/" + aula1.getUc() + "/" + aula1.getTurma();
                        String aula2Key = aula2.getCurso() + "/" + aula2.getUc() + "/" + aula2.getTurma();
                        Object node1 = nodeMap.get(aula1Key);
                        Object node2 = nodeMap.get(aula2Key);
                        graph.insertEdge(parent, null, "", node1, node2);
                    }
                }
            }
        } finally {
            graph.getModel().endUpdate();
        }

        // Configurar o layout do grafo
        mxCircleLayout layout = new mxCircleLayout(graph);
        layout.execute(parent);

        // Exibir o grafo em um JFrame
        JFrame frame = new JFrame("Diagrama de Rede de Conflitualidade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        frame.getContentPane().add(graphComponent, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    // Função para verificar se duas aulas têm conflito
    private static boolean temConflito(Horario aula1, Horario aula2) {
        // Aqui, podes definir a lógica para determinar se duas aulas têm um conflito
        // Por exemplo, se tiverem o mesmo dia e hora, consideramos que têm um conflito
        return aula1.getDia_da_semana().equals(aula2.getDia_da_semana()) &&
               aula1.getHora_init_aula().equals(aula2.getHora_init_aula()) &&
               aula1.getHora_fim_aula().equals(aula2.getHora_fim_aula());
        
    }

    private static void visualizarConflitualidade(List<Horario> horarios) {
        // Mapear as aulas e seus conflitos
        Map<String, String> conflitos = new HashMap<>();
        for (Horario aula : horarios) {
            String aulaKey = aula.getCurso() + "/" + aula.getUc() + "/" + aula.getTurma() + "/" + aula.getDia_da_semana();
            if (conflitos.containsKey(aulaKey)) {
                String conflito = conflitos.get(aulaKey);
                conflitos.put(aulaKey, conflito + ", " + aula.getTurno());
            } else {
                conflitos.put(aulaKey, aula.getTurno());
            }
        }

        // Criar um conjunto de dados para o gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String aula : conflitos.keySet()) {
            dataset.addValue(1, "Conflitualidade", aula);
        }

        // Criar o gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Relações de Conflitualidade",
                "Aula",
                "",
                dataset
        );

        // Mostrar o gráfico numa janela Swing
        JFrame frame = new JFrame("Relações de Conflitualidade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
