import math
points = [
    {"x": 12, "y": 2, "z": 'A', "n": '닼나',"d": None},
    {"x": 6, "y": 4, "z": 'A', "n": '인샙', "d": None},
    {"x": 2, "y": 4, "z": 'M', "n": '비포선', "d": None},
    {"x": 1, "y": 8, "z": 'M', "n": '지만', "d": None},
    {"x": 3, "y": 6, "z": 'M', "n": '모험쥐', "d": None},
    {"x": 9, "y": 1, "z": 'A', "n": '킬빌', "d": None}]

loc_x = int(input('x좌표를 입력하세요\n'))
loc_y = int(input('y좌표를 입력하세요\n'))

target = (loc_x, loc_y)
list = []
for point in points:
    distance = round(math.sqrt(pow(target[0] - point['x'], 2) + pow(target[1] - point['y'], 2)), 2)
    point['d'] = distance
    list.append((point['d'], point['n'], point['z']))

list.sort()
print(list[0:3])

a = m = 0
for i in list[0:3]:
    if i[2] == 'A':
        a += 1
    elif i[2] == 'M':
        m += 1

if a > m:
    print('이 영화는 액션영화입니다')
else:
    print('이 영화는 멜로영화입니다')