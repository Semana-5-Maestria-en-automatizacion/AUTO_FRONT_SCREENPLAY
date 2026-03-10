package co.sofka.automation.tareas;

import co.sofka.automation.interacciones.HacerClicConJavaScript;
import co.sofka.automation.ui.InterfazDashboard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.annotations.Step;

public class SeleccionarPrimerTicket implements Task {

    @Step("{0} selecciona el primer ticket de la lista")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(HacerClicConJavaScript.en(InterfazDashboard.PRIMERA_FILA_TICKET));
    }

    public static SeleccionarPrimerTicket delaLista() {
        return Tasks.instrumented(SeleccionarPrimerTicket.class);
    }
}
