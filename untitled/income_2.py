def make_benefit(people, ticket_price): #이 함수의 make_benefit~result까지의 계산과정?이 for문에서도 적용(make_benefit이 나옴)
   income=people*ticket_price
   outcome=180+(people*0.04)
   result=income-outcome
   return result #for문의 max(최대수익), def의 결과로 return이 남는다.

ticket=5.0
people_count=120
max=0

for i in range(0, 50):
    money=make_benefit(people_count, ticket)
    if money>max: # money 최고 지점에서 falas가 됨(money=max) - max는 money의 최대값
        max=money # =의 오른쪽 왼쪽 구분(오른쪽에서 왼쪽으로 읽기)
        best_ticket=ticket  # =의 오른쪽 왼쪽 구분(오른쪽에서 왼쪽으로 읽기)

        ticket = ticket - 0.1
        people_count = people_count + 15

print(best_ticket,":", max )