#1. 로또공 단위 정의 2. 단위 = 함수의 파라미터,리턴타입,자료구조

import random
class LottoBall:
    def __init__(self, num):
        self.num = num
        self.selected = False

    def isSelected(self):
        answer = self.selected
        self.selected = True
        return answer

    def __str__(self):
        return str(self.num)

balls = [LottoBall(x) for x in range(1,46)]

count = 0

while count < 6:

    idx = random.randint(0,44)
    aball = balls[idx]

    if aball.isSelected() == True:
        print("중복 발생", aball)
        continue
    print(aball)
    count += 1

    # if aball.isSelected() == False:
    #     count += 1
    #     print(aball)
    # else:
    #     print("중복 발생", aball)
