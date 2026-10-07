
import java.util.Scanner;

public class ValidaSenhaForte {

    public static String avaliarSenha(String senha) {

        // Regra 1: verificar o tamanho da senha
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no mínimo 8 caracteres.";
        }

        // Regra 2: verificar se existe pelo menos um número
        boolean temNumero = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isDigit(caractere)) {
                temNumero = true;
            }
        }

        if (!temNumero) {
            return "DICA: Adicione pelo menos um número à sua senha.";
        }

        // Regra 3: verificar se a senha é óbvia
        String[] senhasObvias = {
            "12345678", "senha123", "admin123"
        };

        for (int i = 0; i < senhasObvias.length; i++) {
            if (senha.equals(senhasObvias[i])) {
                return "ALERTA: Esta senha é muito comum ou óbvia.";
            }
        }

        // Regra 4: verificar se existe uma letra maiúscula
        boolean temMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isUpperCase(caractere)) {
                temMaiuscula = true;
            }
        }

        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiúscula à sua senha.";
        }

        // Se todas as regras forem atendidas
        return "SUCESSO: Sua senha passou nos critérios básicos!";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean aprovado = false;

        // Repetir até que a senha seja aprovada
        while (!aprovado) {

            System.out.print("Digite uma senha fictícia: ");
            String senha = scanner.nextLine();

            String resultado = avaliarSenha(senha);

            System.out.println(resultado);

            if (resultado.equals(
                "SUCESSO: Sua senha passou nos critérios básicos!")) {
                aprovado = true;
            }

            System.out.println();
        }
        scanner.close();
    }
} 
