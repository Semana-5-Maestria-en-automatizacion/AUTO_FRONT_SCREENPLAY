# language: es
Característica: Validación del formulario de reporte de incidente
  Como usuario en la página de reporte
  Quiero ver mensajes de error claros al ingresar datos incorrectos
  Para saber exactamente qué campos debo corregir

  @validacion-formulario
  Escenario: Mostrar error cuando el correo electrónico tiene formato inválido
    Dado que el usuario está en la página de reporte de incidente
    Cuando completa el campo de correo electrónico con "correo-invalido"
    Y completa el campo de número de línea con "0123456789"
    Y selecciona el tipo de incidente "Conexión lenta"
    Y hace clic en el botón "Enviar Reporte"
    Entonces se muestra el error "Debe ser un correo electrónico válido" en el campo de correo

  @validacion-formulario
  Escenario: Mostrar error cuando el número de línea tiene menos de 8 dígitos
    Dado que el usuario está en la página de reporte de incidente
    Cuando completa el campo de correo electrónico con "usuario@prueba.com"
    Y completa el campo de número de línea con "123"
    Y selecciona el tipo de incidente "Conexión lenta"
    Y hace clic en el botón "Enviar Reporte"
    Entonces se muestra el error "El número de línea debe tener al menos 8 dígitos" en el campo de número de línea

  @validacion-formulario
  Escenario: La descripción es obligatoria cuando el tipo de incidente es "Otro"
    Dado que el usuario está en la página de reporte de incidente
    Cuando completa el campo de correo electrónico con "usuario@prueba.com"
    Y completa el campo de número de línea con "0123456789"
    Y selecciona el tipo de incidente "Otro"
    Y hace clic en el botón "Enviar Reporte"
    Entonces se muestra el error "La descripción es obligatoria para este tipo de incidente" en el campo de descripción
