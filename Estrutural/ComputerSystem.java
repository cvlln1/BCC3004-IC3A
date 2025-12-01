package Estrutural;

// Cenário: Ligar um computador (esconder a complexidade do hardware)
// Problema: O usuário não quer saber a ordem técnica de inicialização dos componentes.

// Lógicas complexas para um usuário manusear   |
//                                              |
//                                              v

class CPU {
    public void freeze() { System.out.println("1. CPU: Congelada para setup."); }
    public void execute() { System.out.println("4. CPU: Executando instruções..."); }
}

class Memory {
    public void load(long position, String data) {
        System.out.println("2. Memória: Carregando '" + data + "' no endereço " + position);
    }
}

class HardDrive {
    public String readBootSector() {
        System.out.println("3. HD: Lendo setor de boot...");
        return "Linux Kernel";
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    // O método simples que esconde a bagunça

    public void startComputer() {
        System.out.println("--- Iniciando Computador (via Facade) ---");
        cpu.freeze();
        String os = hd.readBootSector();
        ram.load(0x00, os);
        cpu.execute();
        System.out.println("--- Computador ligado com sucesso ---");
    }
}

// main para testar
public class ComputerSystem {
    public static void main(String[] args) {

        // O usuário interage apenas com a fachada limpa

        ComputerFacade pc = new ComputerFacade();
        pc.startComputer();
    }
}