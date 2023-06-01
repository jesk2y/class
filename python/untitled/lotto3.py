from random import randint

"""
def lotto():

   list = [x+1 for x in range(45)]
   lotto = []

   for x in range(7):
      temp2 = randint(0, 44-x)
      temp = list.pop(temp2)
      lotto.append(temp)
   print(lotto)
   return

oper = int(input('돌릴 횟수를 입력하세요'))
for idx, i in enumerate(range(oper)):
   lotto()
"""
list = [x + 1 for x in range(45)]
lotto = []

for x in range(6):
   num = randint(0, 44 - x)
   temp = list.pop(num)
   lotto.append(temp)

for idx, i in enumerate(lotto):
   result = {str(idx + 1) + ' number': i}
   print(result)
