package co.sofka.automation.preguntas;

import co.sofka.automation.ui.InterfazModalCambioEstado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ModalEstaVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return InterfazModalCambioEstado.TITULO_MODAL.resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public static ModalEstaVisible deCambioDeEstado() {
        return new ModalEstaVisible();
    }
}
