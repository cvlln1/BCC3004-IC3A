package Criacional;

// Cenário: Gerenciador de Configurações de um Jogo
// Problema: Garantir que alterações no volume em uma tela reflitam em todas as outras.

class GameSettings {

    private static GameSettings instance;
    

    private int volume;
    private String resolution;


    private GameSettings() {

        this.volume = 50;
        this.resolution = "1920x1080";
        System.out.println("> Sistema de Configuração inicializado");
    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void showSettings() {
        System.out.println("<Config Atual> Volume: " + volume + " | Resolução: " + resolution);
    }
}

// main para testar

public class GameConfig {
    public static void main(String[] args) {
        System.out.println("teste Singleton: Configurações de Jogo");

        GameSettings s1 = GameSettings.getInstance();
        s1.showSettings();

        System.out.println("\nAlterando volume na instância s1 para 90...");
        s1.setVolume(90);

        GameSettings s2 = GameSettings.getInstance();
        
        System.out.print("Lendo configurações da instância s2: ");
        s2.showSettings();

        // Prova real
        if (s1 == s2) {
            System.out.println("\nRESULTADO: s1 e s2 são o MESMO objeto em memória.");
        }
    }
}