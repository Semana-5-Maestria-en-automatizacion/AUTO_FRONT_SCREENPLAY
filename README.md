# AUTO_FRONT_POM_FACTORY

Suite de automatización E2E para el frontend del sistema de gestión de tickets, implementada con **Serenity BDD**, **Cucumber**, **Selenium WebDriver** y el patrón **Page Object Model (POM)** con anotaciones `@FindBy` de Page Factory.

---

## Requisitos previos

- Java 17+
- Google Chrome instalado
- La aplicación frontend corriendo en `http://localhost:8080`

Para levantar el frontend desde la carpeta `Semana 3/Frontend`:

```bash
docker compose up -d
```

---

## Ejecución de las pruebas

### Ejecutar todas las pruebas

```bash
./gradlew clean test aggregate
```

### Ejecutar por etiqueta

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@reporte-incidente"
./gradlew clean test aggregate -Dcucumber.filter.tags="@validacion-formulario"
./gradlew clean test aggregate -Dcucumber.filter.tags="@cambiar-estado"
```

### Modo headless (sin interfaz gráfica)

```bash
./gradlew clean test aggregate -Dheadless.mode=true
```

---

## Reportes

Después de ejecutar las pruebas, el reporte Serenity se genera en:

```
target/site/serenity/index.html
```

Abrir ese archivo en el navegador para ver el reporte completo con capturas de pantalla.

---

## Estructura del proyecto

```
src/
└── test/
    ├── java/co/sofka/automation/
    │   ├── pages/          # Page Objects con @FindBy (Page Factory)
    │   ├── steps/          # Step Definitions de Cucumber
    │   └── runners/        # CucumberRunner (JUnit 4)
    └── resources/
        ├── features/       # Escenarios Gherkin
        └── serenity.conf   # Configuración del driver
```

---

## Flujos cubiertos

| # | Flujo | Etiqueta |
|---|-------|----------|
| 1 | Reporte de incidente exitoso | `@reporte-incidente` |
| 2 | Validación del formulario | `@validacion-formulario` |
| 3 | Cambio de estado de ticket | `@cambiar-estado` |

## Escenarios Gherkin — Flujo 3 (Cambiar estado de ticket)

Feature: Cambiar estado de un ticket desde el Dashboard

  Scenario: Cambiar estado exitosamente a "IN_PROGRESS"
    Given existe un ticket listado en el Dashboard con id "{ticketId}"
    When el usuario hace click en la fila del ticket con id "{ticketId}"
    And en el modal selecciona "En Progreso" (valor `IN_PROGRESS`)
    And pulsa el botón "Confirmar"
    Then se realiza un PATCH a `/api/tickets/{ticketId}/status` con el nuevo estado
    And se muestra el mensaje "Estado actualizado exitosamente"
    And el modal se cierra automáticamente

  Scenario: Cancelar cambio de estado
    Given el modal de cambio de estado está abierto para el ticket "{ticketId}"
    When el usuario pulsa el botón "Cancelar"
    Then no se realiza ninguna petición al endpoint de actualización
    And el modal se cierra sin cambios

  Scenario: Error al actualizar estado
    Given existe un ticket listado en el Dashboard con id "{ticketId}"
    When el usuario abre el modal y selecciona un nuevo estado
    And el backend responde con un error al hacer PATCH
    Then el usuario ve un mensaje de error con el detalle devuelto por la API
    And el modal permanece abierto para reintentar o cancelar

---

Notas:
- Estos escenarios están ubicados aquí a modo de especificación ejecutable en alto nivel.
- Al implementar los tests se crearán `*.feature` y step definitions que repliquen exactamente estas reglas.
# AUTO_FRONT_POM_FACTORY