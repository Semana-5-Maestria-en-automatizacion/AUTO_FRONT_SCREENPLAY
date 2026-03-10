package co.sofka.automation.preguntas;

import co.sofka.automation.ui.InterfazModalCambioEstado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.Duration;

public class ModalEstaOculto implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            InterfazModalCambioEstado.TITULO_MODAL.resolveFor(actor)
                    .withTimeoutOf(Duration.ofSeconds(8))
                    .waitUntilNotVisible();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ModalEstaOculto deCambioDeEstado() {
        return new ModalEstaOculto();
    }
}
