package co.sofka.automation.steps;

import co.sofka.automation.pages.PaginaModalExito;
import co.sofka.automation.pages.PaginaReporteIncidente;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.assertj.core.api.Assertions;

public class PasosReporteIncidente {

    private PaginaReporteIncidente paginaReporteIncidente;
    private PaginaModalExito paginaModalExito;

    @Dado("que el usuario está en la página de reporte de incidente")
    public void usuarioEnPaginaReporteIncidente() {
        paginaReporteIncidente.openAt("/");
    }

    @Cuando("completa el campo de correo electrónico con {string}")
    public void completaCampoEmail(String email) {
        paginaReporteIncidente.ingresarEmail(email);
    }

    @Cuando("completa el campo de número de línea con {string}")
    public void completaCampoNumeroLinea(String numero) {
        paginaReporteIncidente.ingresarNumeroLinea(numero);
    }

    @Cuando("selecciona el tipo de incidente {string}")
    public void seleccionaTipoIncidente(String tipo) {
        paginaReporteIncidente.seleccionarTipoIncidente(tipo);
    }

    @Cuando("hace clic en el botón {string}")
    public void haceClic(String etiquetaBoton) {
        if ("Enviar Reporte".equals(etiquetaBoton)) {
            paginaReporteIncidente.enviarFormulario();
        }
    }

    @Entonces("se muestra el modal con el título {string}")
    public void seMuestraModalConTitulo(String titulo) {
        Assertions.assertThat(paginaModalExito.estaMostrandoTitulo(titulo))
                .as("El modal de éxito debe mostrar el título: " + titulo)
                .isTrue();
    }

    @Entonces("el modal contiene el texto {string}")
    public void elModalContieneMensaje(String texto) {
        Assertions.assertThat(paginaModalExito.contieneMensaje(texto))
                .as("El modal debe contener el texto: " + texto)
                .isTrue();
    }

    @Entonces("se muestra el error {string} en el campo de correo")
    public void seMuestraErrorEnCampoEmail(String mensajeEsperado) {
        Assertions.assertThat(paginaReporteIncidente.obtenerMensajeErrorEmail())
                .as("El mensaje de error del correo debe ser: " + mensajeEsperado)
                .contains(mensajeEsperado);
    }

    @Entonces("se muestra el error {string} en el campo de número de línea")
    public void seMuestraErrorEnCampoNumeroLinea(String mensajeEsperado) {
        Assertions.assertThat(paginaReporteIncidente.obtenerMensajeErrorNumeroLinea())
                .as("El mensaje de error del número de línea debe ser: " + mensajeEsperado)
                .contains(mensajeEsperado);
    }

    @Entonces("se muestra el error {string} en el campo de descripción")
    public void seMuestraErrorEnCampoDescripcion(String mensajeEsperado) {
        Assertions.assertThat(paginaReporteIncidente.obtenerMensajeErrorDescripcion())
                .as("El mensaje de error de descripción debe ser: " + mensajeEsperado)
                .contains(mensajeEsperado);
    }
}
