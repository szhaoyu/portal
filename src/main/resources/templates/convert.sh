

for file in $(find . -name "*.html")
do
        echo "Replacing on : $file"
        #sed 's/VERSION/8.04/' $file > $file.tmp
		sed  's#../assets#assets#g' $file > $file.tmp 
        mv $file.tmp $file
        echo "Replacement done on : $file"
done




