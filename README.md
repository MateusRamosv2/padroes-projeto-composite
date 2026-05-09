# Padrões de Projeto - Composite

---

## Estrutura do Projeto

- **Componente Abstrato (Base):** `Atividade` → Define o contrato comum para todos os elementos da árvore. Contém os atributos básicos (como a descrição) e o método abstrato `getDetalhes()`, garantindo que folhas e galhos sejam tratados de forma uniforme pelo cliente.
- **Objeto Folha (Leaf):** `Tarefa` → Representa a extremidade da árvore, ou seja, a unidade de trabalho que não possui filhos. Implementa `getDetalhes()` para retornar o seu próprio esforço estimado (horas).
- **Objeto Composto (Composite):** `Fase` → Representa os nós ou "galhos" da árvore. Uma Fase contém uma lista de objetos do tipo `Atividade` (que podem ser Tarefas individuais ou até mesmo outras Fases menores). Ao chamar `getDetalhes()`, ela percorre sua lista interna invocando o mesmo método de seus filhos de forma recursiva.
- **Classe Cliente (Contexto):** `Cronograma` → Mantém a referência para a `Atividade` raiz (o escopo principal do projeto). Quando o escopo é solicitado, o cronograma aciona o topo da árvore, desencadeando a leitura completa do projeto.
- **Testes:** `CronogramaTest` → Valida utilizando JUnit a correta montagem da hierarquia (Fases contendo Tarefas e Fases contendo outras Fases). Também garante a segurança da aplicação ao disparar `NullPointerException` caso tente ler um cronograma vazio.

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O destaque absoluto deste padrão é a relação de **Agregação** onde a classe `Fase` possui uma lista de `Atividade`. Como `Fase` também herda de `Atividade`, cria-se a estrutura recursiva que permite agrupar objetos em hierarquias de partes-todo de forma ilimitada.

<img width="635" height="616" alt="Diagrama - Composite" src="https://github.com/user-attachments/assets/95cfedb4-bdaa-4361-b867-e2c4bd17beb1" />

