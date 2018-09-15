s1 = {"name":"KFC",
        "addr":"종각 4거리",
        "price": 5000,
        "next": None} # 각각 어트리뷰트

s2 = {"name":"버거킹",
        "addr":"종각 4거리 KFC 옆",
        "price": 5000,
        "next": None}

s3 = {"name":"맘스터치",
        "addr":"종각 지하철 옆",
        "price": 6000,
        "next": None}
s1['next'] = s2
s2['next'] = s3

current = s1

while True:
    if current  == None:
        print('다 떨어짐')
        break;
    print(current['name'], '에 도착하였습니다')
    opper = input('계속 드실겁니까? y/n')
    if opper == 'y':
        current = current['next']
    else:
        print("식사 끝!")
        break
