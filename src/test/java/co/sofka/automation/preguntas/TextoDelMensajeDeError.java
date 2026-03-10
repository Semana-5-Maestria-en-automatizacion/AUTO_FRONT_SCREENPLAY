package co.sofka.automation.preguntas;

import co.sofka.automation.ui.InterfazModalCambioEstado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.Duration;

public class TextoDelMensajeDeError implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            return InterfazModalCambioEstado.MENSAJE_ERROR.resolveFor(actor)
                    .withTimeoutOf(Duration.ofSeconds(5))
                    .waitUntilVisible()
                    .getText();
        } catch (Exception e) {
            return "";
        }
    }

    public static TextoDelMensajeDeError enElModal() {
        return new TextoDelMensajeDeError();
    }
}
