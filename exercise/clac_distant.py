import math
points = [
    {"x": 12, "y": 2, "z": 'A', "n": '닼나',"d": None},
    {"x": 6, "y": 4, "z": 'A', "n": '인샙', "d": None},
    {"x": 2, "y": 4, "z": 'M', "n": '비포선', "d": None},
    {"x": 1, "y": 8, "z": 'M', "n": '지만', "d": None},
    {"x": 3, "y": 6, "z": 'M', "n": '모험쥐', "d": None},
    {"x": 9, "y": 1, "z": 'A', "n": '킬빌', "d": None}]

x_loc = int(input('격투신 횟수: '))
y_loc = int(input('키스신 횟수: '))

target = {"x": x_loc, "y": y_loc}
list = []

def calc_distance(p1):
    distance = math.sqrt(math.pow(target['x'] - p1['x'], 2) + math.pow(target['y'] - p1['y'], 2))
    return distance

for point in points:
    point['d'] = round(calc_distance( point), 2)
    list.append([point['d'], point['z'], point['n']])

list.sort()

for x in range(3):
    print(list[x])

a = m = 0
for x in list[0:3]:
    if x[1] == 'A':
        a += 1
    elif x[1] == 'M':
        m += 1

if a > m:
    print('입력하신 영화의 장르는 액션입니다')
else:
    print('입력하신 영화의 장르는 멜로입니다')