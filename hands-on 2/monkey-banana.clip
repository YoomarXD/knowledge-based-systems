(defrule MAIN::grab-box
   (monkey-at "box")
   (monkey-has "nothing")
   =>
   (assert (monkey-has "box")))

(defrule MAIN::drop-box-bellow-banana
   (monkey-has "box")
   =>
   (assert (monkey-at "bellow-banana"))
   (assert (monkey-has "nothing"))
   (assert (box-at "bellow-banana")))

(defrule MAIN::climb-box
   (monkey-at "bellow-banana")
   (box-at "bellow-banana")
   =>
   (assert (monkey-at "over-banana")))

(defrule MAIN::grab-banana
   (monkey-at "over-banana")
   (monkey-has "nothing")
   =>
   (assert (monkey-has "banana")))

(defrule MAIN::go-to-box
   (monkey-at "door")
   (monkey-has "nothing")
   =>
   (assert (monkey-at "box")))

(defrule MAIN::final
   (monkey-has "banana")
   =>
   (printout t "Monkey got banana. End." crlf))

