package co.sofka.automation.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;

public class AbrirDashboard implements Task {

    @Step("{0} abre el Dashboard de gestión de tickets")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.relativeUrl("/dashboard"));
    }

    public static AbrirDashboard deGestionDeTickets() {
        return Tasks.instrumented(AbrirDashboard.class);
    }
}
