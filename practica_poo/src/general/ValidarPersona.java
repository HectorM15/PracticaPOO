package general;

import excepciones.CampoVacioException;
import excepciones.NoEsUnDNIException;
import banco.Persona;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarPersona {

    private boolean validarNIF(String nif) {
        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(nif);

        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);

            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
            }
        } else {
            correcto = false;
        }
        return correcto;
    }

    protected void validarPersona(Persona persona) throws NoEsUnDNIException, CampoVacioException {
       if(!validarNIF(persona.getDNI())){
        throw  new NoEsUnDNIException("El DNI introducido no es válido");
       }
       if(persona.getNombre().isEmpty()){
           throw new CampoVacioException("EL nombre está vacio");
       }
    }



}
