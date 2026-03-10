# AUTO_FRONT_SCREENPLAY

Proyecto de automatización frontend con el patrón **Screenplay** (Actores, Tareas, Preguntas e Interacciones), migrado desde el patrón POM Factory del proyecto `AUTO_FRONT_POM_FACTORY`.

Repo => [https://github.com/Semana-5-Maestria-en-automatizacion/AUTO_FRONT_POM_FACTORY](https://github.com/Semana-5-Maestria-en-automatizacion/AUTO_FRONT_POM_FACTORY)

---

## Flujo cubierto

**Cambio de estado de ticket desde el Dashboard**

| Escenario | Resultado esperado |
|-----------|-------------------|
| El agente cambia el estado de un ticket a "En Progreso" | El modal se cierra confirmando la actualización |
| El agente cancela el cambio de estado | El modal se cierra sin modificar el estado |
| No se puede actualizar el estado por fallo de conexión | Se muestra mensaje de error y el modal permanece abierto |


---

## Requisitos previos

- Java 17+
- Google Chrome instalado (ChromeDriver se descarga automáticamente)
- Stack completo levantado con Docker:

```bash
# Desde la raíz de AUTO_FRONT_SCREENPLAY/
docker compose up -d
```

La aplicación frontend queda disponible en `http://localhost:80`.

Proyecto testeado -> [https://github.com/AITraining-SofkaProyects-Team2](https://github.com/AITraining-SofkaProyects-Team2)

---

## Ejecución de las pruebas

```bash
# Linux / macOS
./gradlew clean test aggregate

# Windows (con navegador visible)
.\gradlew.bat clean test aggregate "-Dheadless.mode=false" "-Dwebdriver.driver=chrome"
```

El reporte Serenity se genera en:

```
target/site/serenity/index.html
```

Abrirlo en el navegador para ver el resultado completo con capturas de pantalla por cada paso.

---

## Estructura del proyecto

```
AUTO_FRONT_SCREENPLAY/
├── build.gradle                                        # Dependencias y configuración de Gradle
├── settings.gradle
└── src/test/
    ├── java/co/sofka/automation/
    │   ├── ui/
    │   │   ├── InterfazDashboard.java                  # Localizadores Target del Dashboard
    │   │   └── InterfazModalCambioEstado.java          # Localizadores Target del modal
    │   ├── interacciones/
    │   │   └── HacerClicConJavaScript.java             # Interacción reutilizable con JS
    │   ├── tareas/
    │   │   ├── AbrirDashboard.java                     # Tarea: navegar al Dashboard
    │   │   ├── SeleccionarPrimerTicket.java             # Tarea: clic en el primer ticket
    │   │   ├── ElegirEstadoEnModal.java                # Tarea: seleccionar estado en el dropdown
    │   │   ├── ConfirmarCambioDeEstado.java            # Tarea: clic en Confirmar
    │   │   └── CancelarCambioDeEstado.java             # Tarea: clic en Cancelar
    │   ├── preguntas/
    │   │   ├── TicketsEstanCargados.java               # Pregunta: ¿hay tickets en la tabla?
    │   │   ├── ModalEstaVisible.java                   # Pregunta: ¿el modal está visible?
    │   │   ├── ModalEstaOculto.java                    # Pregunta: ¿el modal desapareció?
    │   │   └── TextoDelMensajeDeError.java             # Pregunta: texto del mensaje de error
    │   ├── steps/
    │   │   └── PasosCambioEstado.java                  # Step Definitions con Actor/attemptsTo/asksFor
    │   └── runners/
    │       └── CucumberRunner.java                     # Runner JUnit 4 + Serenity
    └── resources/
        ├── features/
        │   └── cambio_estado.feature                   # Escenarios Gherkin en español
        └── serenity.conf                               # Configuración del driver y URL base
```

---

## Patrón Screenplay

| Elemento | Clase/Paquete | Rol |
|----------|--------------|-----|
| Actor | `OnStage` / `OnlineCast` | Representa al agente que ejecuta las acciones |
| Tareas | `tareas/` | Agrupan interacciones bajo una intención de negocio (principio de responsabilidad única) |
| Interacciones | `interacciones/` | Acciones atómicas reutilizables (ej. clic con JavaScript) |
| Preguntas | `preguntas/` | Consultan el estado de la UI para ser verificadas con AssertJ |
| Localizadores | `ui/` | Objetos `Target` que reemplazan los `@FindBy` del patrón POM |

---

## Stack tecnológico

| Herramienta | Versión | Rol |
|-------------|---------|-----|
| Java | 17 | Lenguaje |
| Gradle | 8.11 | Gestor de dependencias y build |
| Serenity BDD | 4.1.14 | Framework de automatización y reportes |
| Serenity Screenplay | 4.1.14 | Implementación del patrón Screenplay |
| Serenity Screenplay WebDriver | 4.1.14 | Integración Screenplay + WebDriver (`OnlineCast`) |
| Cucumber | 7.18.1 | Runner BDD (Gherkin) |
| Selenium WebDriver | transitivo vía Serenity | Automatización del navegador |
| JUnit | 4.13.2 | Runner de tests |
| AssertJ | 3.26.3 | Aserciones fluidas |
| Chrome | auto-descargado | Navegador (ChromeDriver automático) |