#!/bin/bash

declare -A names
names=( ["gcj"]="Google Code Jam" ["codility"]="Codility" ["kattis"]="Kattis" ["hacker_rank"]="Hacker Rank")
folders=("gcj" "codility" "kattis" "hacker_rank")

printf "#Algorithms playground\n"
printf "\n"
printf "Project containing solutions to various algorithmic problems.\n"
printf "\n"
printf "Problem web-sites:\n"
printf "* [Googe Code Jam](http://code.google.com/codejam/)\n"
printf "* [Codility](https://codility.com/train/)\n"
printf "* [Spoj](http://www.spoj.com/)\n"
printf "* [Codeforces](http://codeforces.com/)\n"
printf "* [Kattis](https://open.kattis.com/)\n"
printf "\n"
printf "#Solved problems:\n"
printf "\n\n"


for folder in ${folders[*]};
    do
    name=${names[$folder]}
    printf "* ##%s\n" "$name"
    for file in $folder/*;
        do 
        #echo $file
        first_line=$(grep "link:" $file)
        second_line=$(grep "name:" $file)
        link=${first_line##*link:}
        name=${second_line##*name:}
        printf "    * [%s](%s) ([source](%s))\n" "${name## }" "${link## }" "$file"
        done;
        printf "\n\n"
    done;

