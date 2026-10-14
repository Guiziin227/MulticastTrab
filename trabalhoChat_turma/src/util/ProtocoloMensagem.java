package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ProtocoloMensagem {

    private static final DateTimeFormatter FORMATADOR_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final String tipo;
    private final String remetente;
    private final String destinatario;
    private final String horario;
    private final String conteudo;

    public ProtocoloMensagem(String tipo, String remetente, String destinatario, String horario, String conteudo) {
        this.tipo = tipo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.horario = horario;
        this.conteudo = conteudo;
    }

    public static String horarioAtual() {
        return LocalTime.now().format(FORMATADOR_HORA);
    }

    public static String montarEntrada(String usuario) {
        return "ENTROU|" + usuario;
    }

    public static String montarOnline(String usuario) {
        return "ONLINE|" + usuario;
    }

    public static String montarSaida(String usuario) {
        return "SAIU|" + usuario;
    }

    public static String montarTexto(String remetente, String destinatario, String texto) {
        String destino = (destinatario == null || destinatario.isEmpty()) ? "Todos" : destinatario;
        return "MSG|" + remetente + "|" + destino + "|" + horarioAtual() + "|" + texto;
    }

    public static ProtocoloMensagem interpretar(String pacoteBruto) {
        if (pacoteBruto == null || pacoteBruto.isEmpty()) {
            return null;
        }
        String[] partes = pacoteBruto.split("\\|", 5);
        String comando = partes[0];

        if ((comando.equals("ENTROU") || comando.equals("ONLINE") || comando.equals("SAIU")) && partes.length >= 2) {
            return new ProtocoloMensagem(comando, partes[1], "Todos", horarioAtual(), "");
        }

        if (comando.equals("MSG") && partes.length == 5) {
            return new ProtocoloMensagem(comando, partes[1], partes[2], partes[3], partes[4]);
        }

        return null;
    }

    public boolean deveExibirPara(String meuUsuario) {
        if (destinatario.equals("Todos")) {
            return true;
        }
        return destinatario.equals(meuUsuario) || remetente.equals(meuUsuario);
    }

    public String formatarExibicao(String meuUsuario) {
        if (destinatario.equals("Todos")) {
            return "[" + horario + "] " + remetente + ": " + conteudo;
        }
        if (remetente.equals(meuUsuario)) {
            return "[" + horario + "] " + remetente + " (privado para " + destinatario + "): " + conteudo;
        }
        return "[" + horario + "] " + remetente + " (privado): " + conteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getHorario() {
        return horario;
    }

    public String getConteudo() {
        return conteudo;
    }
}