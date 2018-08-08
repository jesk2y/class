#업다운게임
def make_mid(max,min):

    return round((max+min)/2)

max = 100
min = 1

while True:
    mid = make_mid(max,min)
    print(mid)
    player = input("H or L or C\n")
    if player == "H":
       min = mid
    elif player == "L":
        max = mid
    else:
        print("정답!")
        break