import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.security.MessageDigest;


public class AutenticadorSpotify {
    // visibilidad, modificador de clase, modificador de inmutabilidad, tipo de dato
    private static final String ID_APLICACION = "c86c729b012a485abafcf69d51b59916";
    private static final String URL_REDIRECCION = "https://accounts.spotify.com/authorize";
    private String verificador;

    // Verificador de autenticidad para el usuario (generador contraseña temporal)
    public String generarVerificador(){

        // Instanciamos el secureRandom nombrado random
        java.security.SecureRandom random = new SecureRandom();

        // Creamos un array con espacio para 32 bytes
        byte[] arregloBytes = new byte[32];

        // Llamamos a la herramienta para rellenar con bytes aleatorios
        random.nextBytes(arregloBytes);

        // Codificamos toString
        String arregloBytesCodificado = Base64.getUrlEncoder().withoutPadding().encodeToString(arregloBytes);
        return arregloBytesCodificado;
    }

    // Sombra de la contraseña temporal para mandar por url (algoritmo SHA-256)
    public String sombraVerificador(String arregloBytesCodificado){
        // Convertimos el string a byte, guardados en el arreglo byte
        byte[] bytes = arregloBytesCodificado.getBytes(StandardCharsets.US_ASCII);

        // Usamos try por si el algoritmo falla
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Creo un nuevo arreglo de bytes para la sombra
            byte[] bytesTriturados = digest.digest(bytes);

            // Herramienta para codificar toString
            String sombraCodificada = Base64.getUrlEncoder().withoutPadding().encodeToString(bytesTriturados);
            return sombraCodificada;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String obtenerURL(){
        this.verificador = generarVerificador();
        String challenge = sombraVerificador(verificador);

        String URL = "https://accounts.spotify.com/authorize?" + "client_id=" + ID_APLICACION + "&redirect_uri=" + URL_REDIRECCION + "&code_challenge=" + challenge + "&code_challenge_method=S256" + "&response_type=code" + "&scope=user-read-private%20user-read-email";
        return URL;

    }
}