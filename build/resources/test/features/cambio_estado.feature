# language: es
Característica: Cambio de estado de ticket desde el Dashboard
  Como agente de soporte
  Quiero cambiar el estado de un ticket
  Para gestionar la atención al cliente

  @cambiar-estado
  Escenario: El agente cambia el estado de un ticket a "En Progreso"
    Dado que el usuario está en el Dashboard de gestión de tickets
    Y los tickets están cargados en la tabla
    Cuando selecciona el primer ticket de la lista
    Entonces se visualiza el modal de cambio de estado
    Cuando elige el estado "En Progreso" en el modal
    Y confirma el cambio de estado
    Entonces el modal se cierra confirmando que el estado fue actualizado
