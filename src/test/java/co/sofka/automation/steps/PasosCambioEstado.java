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

    @Y("existen tickets listados en la tabla")
    public void existenTicketsListados() {
        Assertions.assertThat(paginaDashboard.tieneFichasListadas())
                .as("Deben existir tickets listados en la tabla del Dashboard")
                .isTrue();
    }

    @Cuando("hace clic en el primer ticket de la lista")
    public void haceCLicEnPrimerTicket() {
        paginaDashboard.hacerClicEnPrimerTicket();
    }

    @Entonces("se abre el modal con el título {string}")
    public void seAbreModalConTitulo(String titulo) {
        Assertions.assertThat(paginaModalCambioEstado.obtenerTitulo())
                .as("El modal debe mostrar el título: " + titulo)
                .contains(titulo);
    }

    @Cuando("selecciona el estado {string} en el modal")
    public void seleccionaEstadoEnModal(String estado) {
        paginaModalCambioEstado.seleccionarEstado(estado);
    }

    @Cuando("hace clic en el botón {string}")
    public void haceClic(String etiquetaBoton) {
        switch (etiquetaBoton) {
            case "Confirmar" -> paginaModalCambioEstado.confirmar();
            case "Cancelar" -> paginaModalCambioEstado.cancelar();
        }
    }

    @Entonces("se muestra el mensaje de éxito {string}")
    public void seMuestraMensajeDeExito(String mensajeEsperado) {
        Assertions.assertThat(paginaModalCambioEstado.obtenerMensajeExito())
                .as("Debe mostrarse el mensaje de éxito: " + mensajeEsperado)
                .contains(mensajeEsperado);
    }

    @Entonces("el modal se cierra sin realizar cambios")
    public void elModalSeCierra() {
        Assertions.assertThat(paginaModalCambioEstado.estaOculto())
                .as("El modal debe cerrarse después de cancelar")
                .isTrue();
    }
}
