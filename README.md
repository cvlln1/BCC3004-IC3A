# Design Patterns: Gambiarras que todo mundo faz, oq faz não ser mais uma gambiarra

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

## Como executar
Como os arquivos contêm métodos main individuais para demonstração, compile e rode cada um separadamente:

```bash
    javac GameConfig.java && java GameConfig
```