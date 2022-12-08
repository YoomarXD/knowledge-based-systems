(defrule r-incision
   (paciente anesteciado) (msg ?msg)
   =>
   (assert (paciente incision))
   (printout t ?msg ": Haciendo incision" crlf)
)

(defrule r-remover-estorbos
   (paciente corazon-detenido) (msg ?msg)
   =>
   (assert (paciente remover-estorbos))
   (printout t ?msg ": Removiendo tejido" crlf)
)

(defrule r-curar-corazon
   (paciente remover-estorbos) (msg ?msg)
   =>
   (assert (paciente curar-corazon))
   (printout t ?msg ": Reparando el corazon por arte de magia" crlf)
)

(defrule r-cerrar-incision
   (paciente curar-corazon) (msg ?msg)
   =>
   (assert (paciente cerrar-incision))
   (printout t ?msg ": Cerrando la incision" crlf)
)

(defrule r-celebrar
   (paciente monitorear) (msg ?msg)
   =>
   (assert (paciente celebrar))
   (printout t ?msg ": AJUA!" crlf)
)
