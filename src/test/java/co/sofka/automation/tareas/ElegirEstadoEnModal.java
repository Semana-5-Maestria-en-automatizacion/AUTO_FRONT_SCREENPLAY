package co.sofka.automation.tareas;

import co.sofka.automation.ui.InterfazModalCambioEstado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.annotations.Step;

public class ElegirEstadoEnModal implements Task {

    private final String estado;

    public ElegirEstadoEnModal(String estado) {
        this.estado = estado;
    }

    @Step("{0} elige el estado '{1}' en el modal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(estado).from(InterfazModalCambioEstado.SELECTOR_ESTADO));
    }

    public static ElegirEstadoEnModal conEtiqueta(String estado) {
        return Tasks.instrumented(ElegirEstadoEnModal.class, estado);
    }
}
