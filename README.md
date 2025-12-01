# Design Patterns: Gambiarras que todos fazem, o que as tornam um padrão

Este repositório apresenta implementações pequenas de três Design Patterns essenciais: Criacional, Estrutural e Comportamental.

> **Referência Oficial:** Os conceitos e estruturas teóricas seguem o catálogo do [Refactoring Guru](https://refactoring.guru/pt-br/design-patterns). Todos os créditos reservados a eles.

> **Uso de IA:** As implementações de código e explicações deste repositório foram geradas com o auxílio do modelo de linguagem **Google Gemini**.

---

## 1. Padrão Criacional: Singleton

### O Padrão
O **Singleton** garante que uma classe tenha apenas uma única instância e provê um ponto de acesso global a ela.

### O Problema (Configuração de Jogo)
Em um jogo, você tem configurações de áudio e brilho. Se você criar múltiplos objetos de configuração, pode ter inconsistências (uma parte do jogo acha que o som está mudo, outra acha que está no máximo). É necessário garantir que o objeto "Configurações" seja único em toda a execução.

### A Solução (/Criacional/GameConfig.java)
Implementamos a classe GameSettings definindo seu construtor como private, o que impede que qualquer outra classe utilize o operador new para criar novas instâncias. Disponibilizamos o acesso através do método estático getInstance(), que verifica se a instância já existe: se não, ele a cria; se sim, retorna a existente. Isso assegura que todo o jogo compartilhe o mesmo estado de volume e resolução.

-----

## 2. Padrão Estrutural: Facade

### O Padrão
O design **Facade** fornece uma interface simplificada para uma biblioteca, um framework ou um conjunto complexo de classes.

### O Problema (Inicializar de Computador)
Ligar um computador envolve uma sequência complexa: a CPU precisa congelar, a memória RAM precisa ser carregada, o disco rígido precisa ser lido... Um usuário não quer chamar cpu.freeze(), ram.load(), hd.read(), ele quer apenas apertar o botão "ligar".*

### A Solução (/Estrutural/ComputerSystem.java)
Criamos uma classe ComputerFacade que encapsula as instâncias de lógicas complexas (CPU, Memory e HardDrive). Esta fachada expõe apenas um método simplificado ao usuário, o startComputer(), que internamente manipula as chamadas técnicas na ordem correta (congelar CPU, ler HD, carregar RAM), isolando o cliente da complexidade de inicialização do hardware.

----


## 3. Padrão Comportamental: Strategy

### O Padrão
O design **Strategy** permite que você defina uma família de algoritmos, coloque-os em classes separadas e faça os objetos deles intercambiáveis.

### O Problema (Exportar de Texto)
Imagine um editor de texto. O usuário digita algo e quer "Salvar". Ele pode querer salvar como .txt (padrão), como .json (formatado) ou .xml. Em vez de fazer um if (tipo == "json") gigante, criamos estratégias de exportação

### A Solução (/Comportalmental/TextExport.java)
Definimos uma interface comum ExportStrategy e criamos classes separadas para cada algoritmo de formatação (JsonExportStrategy, XmlExportStrategy e PainTextExportStrategy). A classe principal TextEditor deixa de conter a lógica de salvamento e passa a ter um campo do tipo da interface, delegando a execução para a estratégia configurada, Isso faz com que seja possível alterar o formato de exportação durante a execução do editor sem modificar o código dele.

----

## Como executar
Como os arquivos contêm métodos main individuais para demonstração, compile e rode cada um separadamente:

```bash
    javac GameConfig.java && java GameConfig
    javac ComputerSystem.java && java ComputerSystem
    javac TextExport.java && java TextExport
```