from random import randint
#step1 - 1000개의 리스트
#내용물은 1부터 45까지의 숫자 - arr

arr = [randint(1,45) for x in range(1000)]

print(arr)

#step2 - 어떤 숫자가 많이 나왔는지 기록하기
record = [0] * 45
print(record)
#step3 - 숫자들 중에서 가장 많이 나온 숫자 알아내기
for num in arr:
    record[num-1] += 1

for idx, count in enumerate(record):
    print(idx+1 , "COUNT: ", count)

max = 0
max_idx = 0
for idx, x in enumerate(record):
    if x > max:
        max = x
        max_idx = idx
print("max num: " + str(max_idx+1))
print("max: " + str(max))