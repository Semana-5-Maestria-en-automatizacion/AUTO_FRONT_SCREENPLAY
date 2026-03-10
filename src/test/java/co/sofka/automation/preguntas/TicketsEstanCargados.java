package co.sofka.automation.preguntas;

import co.sofka.automation.ui.InterfazDashboard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TicketsEstanCargados implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return InterfazDashboard.PRIMERA_FILA_TICKET.resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public static TicketsEstanCargados enLaTabla() {
        return new TicketsEstanCargados();
    }
}
