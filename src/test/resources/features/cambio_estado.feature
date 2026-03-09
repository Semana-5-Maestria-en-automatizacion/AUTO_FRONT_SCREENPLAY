# language: es
Característica: Cambiar estado de un ticket desde el Dashboard
  Como agente de soporte
  Quiero cambiar el estado de un ticket
  Para gestionar el flujo de atención al cliente

  @cambiar-estado
  Escenario: Cambiar el estado de un ticket a "En Progreso" exitosamente
    Dado que el usuario está en el Dashboard de gestión de tickets
    Y existen tickets listados en la tabla
    Cuando hace clic en el primer ticket de la lista
    Entonces se abre el modal con el título "Cambiar estado del ticket"
    Cuando selecciona el estado "En Progreso" en el modal
    Y hace clic en el botón "Confirmar"
    Entonces se muestra el mensaje de éxito "Estado actualizado exitosamente"

  @cambiar-estado
  Escenario: Cancelar el cambio de estado de un ticket
    Dado que el usuario está en el Dashboard de gestión de tickets
    Y existen tickets listados en la tabla
    Cuando hace clic en el primer ticket de la lista
    Entonces se abre el modal con el título "Cambiar estado del ticket"
    Cuando hace clic en el botón "Cancelar"
    Entonces el modal se cierra sin realizar cambios
