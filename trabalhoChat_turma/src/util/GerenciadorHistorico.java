package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class GerenciadorHistorico {

    private static File obterArquivo(String usuario) {
        String nomeLimpo = usuario.replaceAll("[^a-zA-Z0-9_-]", "_");
        return new File("historico_" + nomeLimpo + ".txt");
    }

    public static void salvarLinha(String usuario, String linha) {
        if (usuario == null || usuario.isBlank()) {
            return;
        }
        File arquivo = obterArquivo(usuario);
        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write(linha + System.lineSeparator());
        } catch (IOException e) {
        }
    }

    public static String carregar(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            return "";
        }
        File arquivo = obterArquivo(usuario);
        if (!arquivo.exists()) {
            return "";
        }
        try {
            return Files.readString(arquivo.toPath());
        } catch (IOException e) {
            return "";
        }
    }
}