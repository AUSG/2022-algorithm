for i in {1..12}; do
	for j in 예진 지우 성일 시온 성빈 한솔 가영 다롬 수민 나희 혜성 성찬; do
		mkdir -p week_$i/$j
		touch week_$i/$j/dummy
	done
done
