def doA(num): # 순수함수
    if num == 10:
        return num

    print("doA", num)
    return doA(num+1) #바깥에 변수 선언 안해도 됨 -> 메모리 안꼬임
    #안정적
print(doA(1))