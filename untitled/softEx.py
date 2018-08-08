import math

data = [1, 5, 3, 2, 15, 75, 323, 63, 2, 90] #특정 수에 가까운 순서대로 정렬하고픔



def check(num):
    return math.fabs(num - 15) # 절댓값 안붙이면 음수 처리 안되서 붙여야함

data.sort(key= check)

print(data)