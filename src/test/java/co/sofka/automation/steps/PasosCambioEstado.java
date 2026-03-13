package co.sofka.automation.steps;

import co.sofka.automation.preguntas.ModalEstaOculto;
import co.sofka.automation.preguntas.TicketsEstanCargados;
import co.sofka.automation.preguntas.ModalEstaVisible;
import co.sofka.automation.tareas.AbrirDashboard;
import co.sofka.automation.tareas.ConfirmarCambioDeEstado;
import co.sofka.automation.tareas.ElegirEstadoEnModal;
import co.sofka.automation.tareas.SeleccionarPrimerTicket;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.assertj.core.api.Assertions;

public class PasosCambioEstado {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void limpiarEscenario() {
        OnStage.drawTheCurtain();
    }

    @Given("que el usuario está en el Dashboard de gestión de tickets")
    public void usuarioEnDashboard() {
        OnStage.theActorCalled("el agente").attemptsTo(
                AbrirDashboard.deGestionDeTickets()
        );
    }

    @And("los tickets están cargados en la tabla")
    public void ticketsCargadosEnTabla() {
        Actor agente = OnStage.theActorInTheSpotlight();
        Assertions.assertThat(agente.asksFor(TicketsEstanCargados.enLaTabla()))
                .as("Deben existir tickets listados en la tabla del Dashboard")
                .isTrue();
    }

    @When("selecciona el primer ticket de la lista")
    public void seleccionaPrimerTicket() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarPrimerTicket.delaLista()
        );
    }

    @Then("se visualiza el modal de cambio de estado")
    public void verificaModalVisible() {
        Actor agente = OnStage.theActorInTheSpotlight();
        Assertions.assertThat(agente.asksFor(ModalEstaVisible.deCambioDeEstado()))
                .as("El modal de cambio de estado debe estar visible")
                .isTrue();
    }

    @When("elige el estado {string} en el modal")
    public void eligeEstadoEnModal(String estado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ElegirEstadoEnModal.conEtiqueta(estado)
        );
    }

    @And("confirma el cambio de estado")
    public void confirmaElCambio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarCambioDeEstado.enElModal()
        );
    }

    @Then("el modal se cierra confirmando que el estado fue actualizado")
    public void verificaCierreDelModal() {
        Actor agente = OnStage.theActorInTheSpotlight();
        Assertions.assertThat(agente.asksFor(ModalEstaOculto.deCambioDeEstado()))
                .as("El modal debe cerrarse automáticamente tras la actualización exitosa")
                .isTrue();
    }
}
