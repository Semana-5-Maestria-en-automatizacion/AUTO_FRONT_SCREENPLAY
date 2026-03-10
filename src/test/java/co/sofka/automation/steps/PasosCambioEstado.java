package co.sofka.automation.steps;

import co.sofka.automation.pages.PaginaDashboard;
import co.sofka.automation.pages.PaginaModalCambioEstado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.assertj.core.api.Assertions;

public class PasosCambioEstado {

    private PaginaDashboard paginaDashboard;
    private PaginaModalCambioEstado paginaModalCambioEstado;

    @Dado("que el usuario está en el Dashboard de gestión de tickets")
    public void usuarioEnDashboard() {
        paginaDashboard.openAt("/dashboard");
    }

    @Y("los tickets están cargados en la tabla")
    public void ticketsCargadosEnTabla() {
        Assertions.assertThat(paginaDashboard.tieneFichasListadas())
                .as("Deben existir tickets listados en la tabla del Dashboard")
                .isTrue();
    }

    @Cuando("selecciona el primer ticket de la lista")
    public void seleccionaPrimerTicket() {
        paginaDashboard.hacerClicEnPrimerTicket();
    }

    @Entonces("se visualiza el modal de cambio de estado")
    public void verificaModalVisible() {
        Assertions.assertThat(paginaModalCambioEstado.estaVisible())
                .as("El modal de cambio de estado debe estar visible")
                .isTrue();
    }

    @Cuando("elige el estado {string} en el modal")
    public void eligeEstadoEnModal(String estado) {
        paginaModalCambioEstado.seleccionarEstado(estado);
    }

    @Y("confirma el cambio de estado")
    public void confirmaElCambio() {
        paginaModalCambioEstado.confirmar();
    }

    @Entonces("el modal se cierra confirmando que el estado fue actualizado")
    public void verificaCierreDelModal() {
        Assertions.assertThat(paginaModalCambioEstado.estaOculto())
                .as("El modal debe cerrarse automáticamente tras la actualización exitosa")
                .isTrue();
    }
}
