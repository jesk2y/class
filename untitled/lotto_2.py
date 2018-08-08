
from random import randint
#step1 - 1000개의 리스트
#내용물은 1부터 45까지의 숫자 - arr

arr = [randint(1,45) for x in range(1000)]

count = 0
record = [0] * 45

for num in arr:
    record[num-1] += 1

for idx, count in enumerate(record):
    result = [{"name": idx +1 , "count": count}]
    print(result)
