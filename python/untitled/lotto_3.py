
import random
balls = list(range(1, 46))
random.shuffle(balls)
print(balls[0:6])

#from random import randint
# result = []
# for x in range(6):
#     idx = randint(0, len(balls)-1)
#     num = balls.pop(idx)
#     result.append(num)
#     print("---------------------------------------")
# print(result)


# 1. 1~45 번호출력
# 2. 임의의 인덱스번호를 6번 뽑는다
# 3. 중복값 처리