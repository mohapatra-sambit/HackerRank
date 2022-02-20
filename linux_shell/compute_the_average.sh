read n
sum=0
#for i in {1..n}
for (( c=1; c<=n; c++ ))
do
    read a
    sum=$((sum + a))
    #echo $sum
done
printf "%.3f" $(echo $sum/$n | bc -l)

