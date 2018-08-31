
/**
 * Implementação de Fila Sequencial Circular de forma estruturada.
 *
 * Utiliza o critério FIFO
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Tamanho máximo da fila.
     */
    private static final int TAMANHO_FILA = 10;
    /**
     * Final da fila.
     */
    private static int fim = 0;

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Adiciona um novo nó no final da fila.
     *
     * Também chamado de Enqueue.
     *
     * @param _fila Fila onde será inserido o novo elemento.
     * @param _valor Valor a ser inserido na fila.
     * @return verdadeiro ou falso se conseguiu enfileirar
     */
    public static boolean enfileirar(int[] _fila, int _valor) {
        //Verifica se a fila tem posições disponíveis para enfileirar        
        if (fim < TAMANHO_FILA) {
            //Insere o novo valor na posição k.
            _fila[fim] = _valor;
            //Incrementa a quantidade de elementos
            fim = fim + 1;
            return true;
        } else {
            System.out.println("Fila Cheia!");
            return false;
        }
    }

    /**
     * Acessa o primeiro nó da fila sem removê-lo.
     *
     * Também chamado de Peek.
     *
     * @param _fila Fila que contem os nós.
     * @param _fim Quantidade de nós na fila.
     * @return o valor ou -1 se não conseguiu acessar.
     */
    public static int acessarInicio(int[] _fila, int _fim) {
        //Verifica se a fila não está vazia
        if (_fim != 0) {
            return _fila[0];
        } else {
            System.out.println("Fila Vazia");
            return -1;
        }
    }

    /**
     * Altera o dado primeiro nó da fila.
     *
     * @param _fila Fila que contem os nós.
     * @param _fim Quantidade de nós na fila.
     * @param _valor Novo valor para o primeiro nó.
     * @return verdadeiro ou falso se conseguiu alterar.
     */
    public static boolean alterarInicio(int[] _fila, int _fim, int _valor) {
        //Verifica se a fila não está vazia
        if (_fim != 0) {
            //Atribui o novo valor para o início da fila
            _fila[0] = _valor;
            return true;
        } else {
            System.out.println("Fila Vazia");
            return false;
        }
    }

    /**
     * Remove um nó do inicio da fila.
     *
     * Também chamado de Dequeue.
     *
     * @param _fila fila que contêm os nós.
     * @return O nó que foi desemfileirado.
     */
    public static int desenfileirar(int[] _fila) {
        //Verifica se a fila não está vazia
        if (fim != 0) {
            //Guarda o valor do início da fila antes de retirar
            int valor = _fila[0];
            //Desloca os Nós do fim até a posição 0 da fila.
            for (int i = 0; i < fim; i++) {
                _fila[i] = _fila[i + 1];
            }
            //Decrementa a quantidade de Nós da lista.
            fim = fim - 1;
            return valor;
        } else {
            System.out.println("Fila Vazia");
            return -1;
        }
    }

    /**
     * Lista os dados da fila.
     *
     * @param _fila Fila para exibir os dados.
     * @param _fim Final da fila.
     */
    public static void listar(int[] _fila, int _fim) {
        String temp = "";
        for (int i = 0; i < _fim; i++) {
            temp = temp + (i) + "-" + _fila[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Listagem \n" + temp);
    }

    /**
     * Retorna se a fila está cheia.
     *
     * @return Verdadeiro ou falso se a fila está cheia.
     */
    public static boolean estaCheia() {
        return fim == TAMANHO_FILA;
    }

    /**
     * Retorna se a fila esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public static boolean estaVazia() {
        return fim == 0;
    }

    /**
     * Retorna a quantidade de elementos da fila.
     *
     * @return A quantidade de elementos da fila.
     */
    public static int quantidadeFila() {
        return fim;
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Declaração da fila
        int fila[] = new int[TAMANHO_FILA];
        //Quantidade incial de elementos na fila
        fim = 0;
        // Controla o menu da fila
        int opcao = -1;
        //Menu para controle da fila
        while (opcao != 9) {	//Monta o menu de opcoes
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Fila Sequencial Circular ###\n"
                    + "Selecione a opção desejada:\n"
                    + "1 - Enfileirar\n"
                    + "2 - Consultar Inicio\n"
                    + "3 - Alterar Inicio\n"
                    + "4 - Desenfileirar\n"
                    + "5 - Está cheia?\n"
                    + "6 - Está vazia?\n"
                    + "7 - Tamanho da Fila\n"
                    + "8 - Listar\n"
                    + "9 - Sair"));
            switch (opcao) {
                case 1: {
                    if (enfileirar(fila, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Valor emfileirado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não emfileirado!");
                    }
                    break;
                }
                case 2: {
                    int valor = acessarInicio(fila, fim);
                    JOptionPane.showMessageDialog(null, "O valor do início é " + valor);
                    break;
                }
                case 3: {
                    if (alterarInicio(fila, fim, leitura())) {
                        JOptionPane.showMessageDialog(null, "Alteração do início realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alteração do início não realizada!");
                    }
                    break;
                }
                case 4: {
                    int valor = desenfileirar(fila);
                    if (valor != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor + " foi desenfileirado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila vazia, Valor não desenfileirado!");
                    }
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Está cheia : " + estaCheia());
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, "Está vazia : " + estaVazia());
                    break;
                }
                case 7: {
                    JOptionPane.showMessageDialog(null, "Quantidade de elementos na fila : " + quantidadeFila());
                    break;
                }
                case 8: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        listar(fila, fim);
                    }
                    break;
                }
                default:
                    break;
            }
        }//Fim While
    }
}
