
def convert(value):

    odd = value % 2

    if int(value / 2) == 0:
        return "1"

    return str(convert(int(value/2))) + str(odd)

for x in range(1,30):
    print(convert(x))

#재귀호출 예제  = sum, 팩토리얼, 피보나치
#로또 프로그램으로 돌리기(똑같은 숫자 어떻게 해결?

