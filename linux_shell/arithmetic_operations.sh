read expression

#printf "%.3f" `echo $expression | bc -l`

printf "%.3f" $(bc -l  <<< $expression);

