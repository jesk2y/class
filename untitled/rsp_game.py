import random
a=0
b=0
c=0

for i in range(0,5):
   com=random.randint(0,2)
   user=int(input("0:가위, 1:바위, 2:보"))

   if com<user:
      com=com+3

   if com-user==1 :
      print(com)
      print("짐")
      a=a+1
      break
   elif com-user==2:
      print(com)
      print("이김")
      b=b+1

   elif com-user==0:
      print(com)
      print("비김")
      c=c+1

print(str(a)+"번 지고 "+str(b)+"번 이기고 "+str(c)+"번 비겼습니다.")