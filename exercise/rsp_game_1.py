import random

com=random.randint(0,2)
user=int(input("0:가위, 1:바위, 2:보"))

if com<user:
    com=com+3

if com-user==1:
    print(com)
    print("짐")
elif com-user==2:
    print(com)
    print("이김")
elif com-user==0:
    print(com)
    print("비김")