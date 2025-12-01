package Comportamental;

// Cenário: Exportar texto para formatos diferentes
// Problema: Evitar ifs complexos (if type == xml...) ao salvar arquivos.

// Interface Strategy
interface ExportStrategy {
    void save(String text);
}

// Estratégias definidas
class JsonExportStrategy implements ExportStrategy {
    public void save(String text) {
        System.out.println("Exportando para JSON: { \"content\": \"" + text + "\" }");
    }
}

class XmlExportStrategy implements ExportStrategy {
    public void save(String text) {
        System.out.println("Exportando para XML: <text>" + text + "</text>");
    }
}

class PlainTextStrategy implements ExportStrategy {
    public void save(String text) {
        System.out.println("Salvando arquivo .txt simples: " + text);
    }
}


class TextEditor {
    private ExportStrategy strategy;

    // Define a estratégia padrão
    public TextEditor() {
        this.strategy = new PlainTextStrategy();
    }

    // faz com que seja possível trocar a estratégia
    public void setStrategy(ExportStrategy strategy) {
        this.strategy = strategy;
    }

    // entregar a tarefa para a estratégia atual
    public void saveFile(String content) {
        strategy.save(content);
    }
}

// main pra testar
public class TextExport {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        String meuTexto = "Olá Design Patterns";

        System.out.println(" clicou em Salvar "); // vai salvar como plaintext (.txt) que é o padrão
        editor.saveFile(meuTexto);

        System.out.println("\n config alterada para JSON ");
        editor.setStrategy(new JsonExportStrategy());
        editor.saveFile(meuTexto);

        System.out.println("\n config alterada para XML");
        editor.setStrategy(new XmlExportStrategy());
        editor.saveFile(meuTexto);
    }
}