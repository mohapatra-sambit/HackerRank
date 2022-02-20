read a
read b
read c

[[ ($a == $b) && ($a == $c) ]] && echo EQUILATERAL || ([[ $a == $b || $b == $c || $a == $c ]] && echo ISOSCELES || echo SCALENE)

