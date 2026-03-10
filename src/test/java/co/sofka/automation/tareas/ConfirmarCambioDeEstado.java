package co.sofka.automation.tareas;

import co.sofka.automation.ui.InterfazModalCambioEstado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.annotations.Step;

public class ConfirmarCambioDeEstado implements Task {

    @Step("{0} confirma el cambio de estado")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(InterfazModalCambioEstado.BOTON_CONFIRMAR));
    }

    public static ConfirmarCambioDeEstado enElModal() {
        return Tasks.instrumented(ConfirmarCambioDeEstado.class);
    }
}
