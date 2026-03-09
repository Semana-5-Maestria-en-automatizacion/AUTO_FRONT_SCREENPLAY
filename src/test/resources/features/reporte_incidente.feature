# language: es
Característica: Reportar incidente de servicio
  Como usuario con un problema de servicio
  Quiero enviar un reporte de incidente
  Para que el equipo técnico pueda asistirme

  @reporte-incidente
  Escenario: Envío exitoso de un reporte de incidente con tipo que no requiere descripción
    Dado que el usuario está en la página de reporte de incidente
    Cuando completa el campo de correo electrónico con "usuario@prueba.com"
    Y completa el campo de número de línea con "0123456789"
    Y selecciona el tipo de incidente "Conexión lenta"
    Y hace clic en el botón "Enviar Reporte"
    Entonces se muestra el modal con el título "¡Reporte Enviado!"
    Y el modal contiene el texto "Hemos recibido tu reporte de incidente"
